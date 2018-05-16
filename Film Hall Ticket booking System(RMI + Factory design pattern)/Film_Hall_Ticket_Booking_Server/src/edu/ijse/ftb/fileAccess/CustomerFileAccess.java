package edu.ijse.ftb.fileAccess;

import edu.ijse.ftb.dto.CustomerDTO;
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

/* String filename = "of".split(".")[0] + sdf.format(dt) + of.split(".")[1];*/
public class CustomerFileAccess {
   private static final Date dt=new Date();
   private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
   private static final String date=sdf.format(dt);
   private static final String filePath="./src/edu/ijse/ftb/file/Customer.txt";
   private static final String fileExtension=".txt";
   //private static final String ffile=filePath+date+"."+fileExtension;
   private static final String ffile=filePath;
   private static final java.io.File file =new java.io.File(ffile);
   private static  ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();
   
   public static boolean saveCustomer(CustomerDTO customer) throws IOException,FileNotFoundException,ParseException{
        if(!file.exists()){
            boolean createNewFile=file.createNewFile();
        }
        rwlock.writeLock().lock();
        String line="";
        line+=customer.getCid()+"#";
        line+=customer.getName()+"#";
        line+=customer.getEmail()+"#";
        line+=customer.getMobnum();
        
        BufferedWriter bufferedwriter=null;
        try{
            FileWriter filewriter=new FileWriter(file,true);
            bufferedwriter=new BufferedWriter(filewriter);
            bufferedwriter.write(line);
            bufferedwriter.newLine();
            return isCustomerAvailable(customer.getCid());
        }finally{
            if(bufferedwriter!=null){
                bufferedwriter.close();
            }
            rwlock.writeLock().unlock();
        }
   }
   public static CustomerDTO searchCustomers(String cid) throws IOException,FileNotFoundException,ParseException{
       BufferedReader bufferedreader=null;
       CustomerDTO customerdto=null;
       try{
       rwlock.readLock().lock();
       FileReader filereader=new FileReader(file);
       bufferedreader=new BufferedReader(filereader);
       String line=null;
       while((line=bufferedreader.readLine())!=null){
           String[] data=line.split("#");
           if(data[0].equals(cid)){
               customerdto=new CustomerDTO();
               customerdto.setCid(data[0]);
               customerdto.setName(data[1]);
               customerdto.setEmail(data[2]);
               customerdto.setMobnum(Integer.parseInt(data[3]));
           }
       }
       return customerdto;
       }finally{
               if(bufferedreader!=null){
                   bufferedreader.close();
               }
               rwlock.readLock().unlock();
       }
   }
   public static boolean updateCustomer(CustomerDTO customer)throws IOException,FileNotFoundException,ParseException{
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
               if(!data[0].equals(customer.getCid())){
                   fileData.add(line);
               }else{
                   String updline="";
                   updline+=customer.getCid()+"#";
                   updline+=customer.getName()+"#";
                   updline+=customer.getEmail()+"#";
                   updline+=Integer.toString(customer.getMobnum());
                   fileData.add(updline);
               }
           }
                FileWriter filewriter=new FileWriter(file);
                bufferedwriter=new BufferedWriter(filewriter);
                for(String linedata:fileData){
                    bufferedwriter.write(linedata);
                    bufferedwriter.newLine();
                }
                return isCustomerAvailable(customer.getCid());
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
   public static boolean deleteCustomers(String cid) throws IOException,FileNotFoundException,ParseException{
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
               if(!data[0].equals(cid)){
                   filedata.add(line);
               }
           }
           FileWriter filewriter=new FileWriter(file);
           bufferedwriter=new BufferedWriter(filewriter);
           for(String linedata:filedata){
               bufferedwriter.write(linedata);
               bufferedwriter.newLine();
           }
           return isCustomerAvailable(cid);
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
   public static List<CustomerDTO> getAllCustomer() throws FileNotFoundException,IOException,ParseException{
       BufferedReader bufferedreader=null;
       List<CustomerDTO> customer=new ArrayList<>();
       try{
           rwlock.readLock().lock();
           FileReader filereader=new FileReader(file);
           bufferedreader=new BufferedReader(filereader);
           String line=null;
           while((line=bufferedreader.readLine())!=null){
               String [] data=line.split("#");
               CustomerDTO customero=new CustomerDTO();
               customero.setCid(data[0]);
               customero.setName(data[1]);
               customero.setEmail(data[2]);
               customero.setMobnum(Integer.parseInt(data[3]));
               customer.add(customero);
           }
           return customer;
       }finally{
            if(bufferedreader!=null){
                bufferedreader.close();
            }
            rwlock.readLock().unlock();
       }
   
   
   }
  
    private static boolean isCustomerAvailable(String cid) throws IOException,FileNotFoundException,ParseException {
        CustomerDTO customer=searchCustomers(cid);
        return customer==null;
    }
}
