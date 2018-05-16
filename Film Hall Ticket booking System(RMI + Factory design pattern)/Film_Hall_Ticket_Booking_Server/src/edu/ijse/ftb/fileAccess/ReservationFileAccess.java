/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.ftb.fileAccess;

import edu.ijse.ftb.dto.ReservationDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Dell
 */
public class ReservationFileAccess {
    private static final String filePath="./src/edu/ijse/ftb/file/Reservation.txt";
    private static final java.io.File file =new java.io.File(filePath);
    private static  ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();
    
     public static boolean saveReservation(ReservationDTO reservation) throws IOException,FileNotFoundException,ParseException{
        if(!file.exists()){
            boolean createNewFile=file.createNewFile();
        }
        rwlock.writeLock().lock();
        String line="";
          line+=reservation.getRid()+"#";
          line+=reservation.getCid()+"#";
          line+=reservation.getSid()+"#";
          line+=reservation.getMoid()+"#";
          line+=reservation.getSeatQ()+"#";
          line+=reservation.getRdate()+"#";
          line+=reservation.getRtime()+"#";
          line+=reservation.getMdate()+"#";
          line+=reservation.getMtime()+"#";
          line+=reservation.getNoAudults()+"#";
          line+=reservation.getNoChild();
        
        BufferedWriter bufferedwriter=null;
        try{
            FileWriter filewriter=new FileWriter(file,true);
            bufferedwriter=new BufferedWriter(filewriter);
            bufferedwriter.write(line);
            bufferedwriter.newLine();
            return isReservationAvailable(reservation.getRid());
        }finally{
            if(bufferedwriter!=null){
                bufferedwriter.close();
            }
            rwlock.writeLock().unlock();
        }
   }
   public static ReservationDTO searchReservations(String cid) throws IOException,FileNotFoundException,ParseException{
       BufferedReader bufferedreader=null;
       ReservationDTO reservationdto=null;
       try{
       rwlock.readLock().lock();
       FileReader filereader=new FileReader(file);
       bufferedreader=new BufferedReader(filereader);
       String line=null;
       while((line=bufferedreader.readLine())!=null){
           String[] data=line.split("#");
           if(data[0].equals(cid)){
               reservationdto=new ReservationDTO();
//               customerdto.setCid(data[0]);
//               customerdto.setName(data[1]);
//               customerdto.setEmail(data[2]);
//               customerdto.setMobnum(Integer.parseInt(data[3]));
                reservationdto.setRid(data[0]);
                reservationdto.setCid(data[1]);
                reservationdto.setSid(data[2]);
                reservationdto.setMoid(data[3]);
                reservationdto.setSeatQ(Double.parseDouble(data[4]));
                reservationdto.setRdate(data[5]);
                reservationdto.setRtime(data[6]);
                reservationdto.setMdate(data[7]);
                reservationdto.setMtime(data[8]);
                reservationdto.setNoAudults(Integer.parseInt(data[9]));
                reservationdto.setNoChild(Integer.parseInt(data[10]));
           }
       }
       return reservationdto;
       }finally{
               if(bufferedreader!=null){
                   bufferedreader.close();
               }
               rwlock.readLock().unlock();
       }
   }
   public static boolean updateReservation(ReservationDTO reservation)throws IOException,FileNotFoundException,ParseException{
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
               if(!data[0].equals(reservation.getRid())){
                   fileData.add(line);
               }else{
                   String updline="";
                    updline+=reservation.getRid()+"#";
                    updline+=reservation.getCid()+"#";
                    updline+=reservation.getSid()+"#";
                    updline+=reservation.getMoid()+"#";
                    updline+=reservation.getSeatQ()+"#";
                    updline+=reservation.getRdate()+"#";
                    updline+=reservation.getRtime()+"#";
                    updline+=reservation.getMdate()+"#";
                    updline+=reservation.getMtime()+"#";
                    updline+=reservation.getNoAudults()+"#";
                    updline+=reservation.getNoChild();
                   fileData.add(updline);
               }
           }
                FileWriter filewriter=new FileWriter(file);
                bufferedwriter=new BufferedWriter(filewriter);
                for(String linedata:fileData){
                    bufferedwriter.write(linedata);
                    bufferedwriter.newLine();
                }
                return isReservationAvailable(reservation.getRid());
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
   public static boolean deleteReservation(String rid) throws IOException,FileNotFoundException,ParseException{
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
               if(!data[0].equals(rid)){
                   filedata.add(line);
               }
           }
           FileWriter filewriter=new FileWriter(file);
           bufferedwriter=new BufferedWriter(filewriter);
           for(String linedata:filedata){
               bufferedwriter.write(linedata);
               bufferedwriter.newLine();
           }
           return isReservationAvailable(rid);
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
   public static List<ReservationDTO> getAllReservations() throws FileNotFoundException,IOException,ParseException{
       BufferedReader bufferedreader=null;
       List<ReservationDTO> reservation=new ArrayList<>();
       try{
           rwlock.readLock().lock();
           FileReader filereader=new FileReader(file);
           bufferedreader=new BufferedReader(filereader);
           String line=null;
           while((line=bufferedreader.readLine())!=null){
               String [] data=line.split("#");
               ReservationDTO reservationdto=new ReservationDTO();
               reservationdto.setRid(data[0]);
               reservationdto.setCid(data[1]);
               reservationdto.setSid(data[2]);
               reservationdto.setMoid(data[3]);
               reservationdto.setSeatQ(Double.parseDouble(data[4]));
               reservationdto.setRdate(data[5]);
               reservationdto.setRtime(data[6]);
               reservationdto.setMdate(data[7]);
               reservationdto.setMtime(data[8]);
               reservationdto.setNoAudults(Integer.parseInt(data[9]));
               reservationdto.setNoChild(Integer.parseInt(data[10]));
               reservation.add(reservationdto);
           }
           return reservation;
       }finally{
            if(bufferedreader!=null){
                bufferedreader.close();
            }
            rwlock.readLock().unlock();
       }
   
   
   }
   
  
    private static boolean isReservationAvailable(String cid) throws IOException,FileNotFoundException,ParseException {
        ReservationDTO reservation=searchReservations(cid);
        return reservation==null;
    }
}
