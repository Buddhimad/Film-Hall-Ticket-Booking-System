package edu.ijse.ftb.fileAccess;

import edu.ijse.ftb.dto.PaymentDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PaymentFileAccess {
//   private static final Date dt=new Date();
//   private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//   private static final String date=sdf.format(dt);
   private static final String filePath="./src/edu/ijse/ftb/file/Payment.txt";
//   private static final String fileExtension=".txt";
   private static final String ffile=filePath;
//+date+"."+fileExtension;
   private static final java.io.File file =new java.io.File(ffile);
   private static  ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();
   
    public static boolean savePayment(PaymentDTO payment) throws IOException,FileNotFoundException,ParseException{
        if(!file.exists()){
            boolean createNewFile=file.createNewFile();
        }
        rwlock.writeLock().lock();
        String line="";
        line+=payment.getPid()+"#";
        line+=payment.getAmount();
        
        BufferedWriter bufferedwriter=null;
        try{
            FileWriter filewriter=new FileWriter(file,true);
            bufferedwriter=new BufferedWriter(filewriter);
            bufferedwriter.write(line);
            bufferedwriter.newLine();
            return isPaymentAvailable(payment.getPid());
        }finally{
            if(bufferedwriter!=null){
                bufferedwriter.close();
            }
            rwlock.writeLock().unlock();
        }
   }
   public static PaymentDTO searchPayment(String pid) throws IOException,FileNotFoundException,ParseException{
       BufferedReader bufferedreader=null;
       PaymentDTO paymentdto=null;
       try{
       rwlock.readLock().lock();
       FileReader filereader=new FileReader(file);
       bufferedreader=new BufferedReader(filereader);
       String line=null;
       while((line=bufferedreader.readLine())!=null){
           String[] data=line.split("#");
           if(data[0].equals(pid)){
              paymentdto=new PaymentDTO();
              paymentdto.setAmount(Double.parseDouble(data[1]));
           }
       }
       return paymentdto;
       }finally{
               if(bufferedreader!=null){
                   bufferedreader.close();
               }
               rwlock.readLock().unlock();
       }
   }
   public static boolean updatePayment(PaymentDTO payment)throws IOException,FileNotFoundException,ParseException{
       BufferedReader bufferedreader=null;
       BufferedWriter bufferedwriter=null;
       try{
           rwlock.writeLock().lock();
           FileReader filereader=new FileReader(file);
           bufferedreader=new BufferedReader(filereader);
           List<String>fileData=new ArrayList<>();
           String line=null;
           while((line=bufferedreader.readLine())!=null){
               String[] data=line.split("#");
               if(!data[0].equals(payment.getPid())){
                   fileData.add(line);
               }else{
                   String updline="";
                  updline+=payment.getPid()+"#";
                  updline+=payment.getAmount();
                   fileData.add(updline);
               }
           }
                FileWriter filewriter=new FileWriter(file);
                bufferedwriter=new BufferedWriter(filewriter);
                for(String linedata:fileData){
                    bufferedwriter.write(linedata);
                    bufferedwriter.newLine();
                }
                return isPaymentAvailable(payment.getPid());
       }finally{
                if(bufferedreader!=null){
                    bufferedreader.close();
                }
                if(bufferedwriter!=null){
                    bufferedwriter.close();
                }
                rwlock.writeLock().unlock();
       }
   
   
   }
   public static boolean deletePayment(String pid) throws IOException,FileNotFoundException,ParseException{
       BufferedReader bufferedreader=null;
       BufferedWriter bufferedwriter=null;
       try{
           rwlock.writeLock().lock();
           FileReader filereader=new FileReader(file);
           bufferedreader=new BufferedReader(filereader);
           List<String>filedata=new ArrayList<>();
           String line=null;
           while((line=bufferedreader.readLine())!=null){
               String [] data=line.split("#");
               if(!data[0].equals(pid)){
                   filedata.add(line);
               }
           }
           FileWriter filewriter=new FileWriter(file);
           bufferedwriter=new BufferedWriter(filewriter);
           for(String linedata:filedata){
               bufferedwriter.write(linedata);
               bufferedwriter.newLine();
           }
           return isPaymentAvailable(pid);
       }finally{
           if(bufferedwriter!=null){
               bufferedwriter.close();
           }
           if(bufferedreader!=null){
               bufferedreader.close();
           }
           rwlock.writeLock().unlock();
       }
   
   }
   public static List<PaymentDTO> getAllPayments() throws FileNotFoundException,IOException,ParseException{
       BufferedReader bufferedreader=null;
       List<PaymentDTO> payment=new ArrayList<>();
       try{
           rwlock.readLock().lock();
           FileReader filereader=new FileReader(file);
           bufferedreader=new BufferedReader(filereader);
           String line=null;
           if((line=bufferedreader.readLine())!=null){
               String [] data=line.split("#");
               PaymentDTO Payments=new PaymentDTO();
               Payments.setAmount(Double.parseDouble(data[1]));
               payment.add(Payments);
           }
           return payment;
       }finally{
            if(bufferedreader!=null){
                bufferedreader.close();
            }
            rwlock.readLock().unlock();
       }
   
   
   }
  
    private static boolean isPaymentAvailable(String cid) throws IOException,FileNotFoundException,ParseException {
        PaymentDTO payment=searchPayment(cid);
        return payment==null;
    }


}
