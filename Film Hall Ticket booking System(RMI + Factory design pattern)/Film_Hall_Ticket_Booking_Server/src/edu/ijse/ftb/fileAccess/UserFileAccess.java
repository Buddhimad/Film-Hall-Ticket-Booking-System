package edu.ijse.ftb.fileAccess;

import edu.ijse.ftb.dto.UserDTO;
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
public class UserFileAccess {
    
    private static final String filePath="./src/edu/ijse/ftb/file/User.txt";
//   private static final String fileExtension=".txt";
    private static final String ffile=filePath;
//+date+"."+fileExtension;
    private static final java.io.File file =new java.io.File(ffile);
    private static  ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();
   
   
    public static boolean saveUsers(UserDTO user) throws IOException,FileNotFoundException,ParseException{
        if(!file.exists()){
            boolean createNewFile=file.createNewFile();
        }
        rwlock.writeLock().lock();
        String line="";
        line+=user.getUserName()+"#";
        line+=user.getPassword()+"#";
        line+=user.getConfirmPassword()+"#";
        line+=user.getUid()+"#";
        line+=user.getNic()+"#";
        line+=user.getPhonenumber()+"#";
        line+=user.getEmail();
        
        BufferedWriter bufferedwriter=null;
        try{
            FileWriter filewriter=new FileWriter(file,true);
            bufferedwriter=new BufferedWriter(filewriter);
            bufferedwriter.write(line);
            bufferedwriter.newLine();
            return isUserAvailable(user.getUid());
        }finally{
            if(bufferedwriter!=null){
                bufferedwriter.close();
            }
            rwlock.writeLock().unlock();
        }
   }
   public static UserDTO searchUser(String uid) throws IOException,FileNotFoundException,ParseException{
       BufferedReader bufferedreader=null;
       UserDTO userdto=null;
       try{
       rwlock.readLock().lock();
       FileReader filereader=new FileReader(file);
       bufferedreader=new BufferedReader(filereader);
       String line=null;
       while((line=bufferedreader.readLine())!=null){
           String[] data=line.split("#");
           if(data[3].equals(uid)){
              userdto=new UserDTO();
              userdto.setUserName(data[0]);
              userdto.setPassword(data[1]);
              userdto.setConfirmPassword(data[2]);
              userdto.setUid(data[3]);
              userdto.setNic(data[4]);
              userdto.setPhonenumber(data[5]);
              userdto.setEmail(data[6]);
           }
       }
       return userdto;
       }finally{
               if(bufferedreader!=null){
                   bufferedreader.close();
               }
               rwlock.readLock().unlock();
       }
   }
   public static boolean updateUser(UserDTO user)throws IOException,FileNotFoundException,ParseException{
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
               if(!data[3].equals(user.getUid())){
                   fileData.add(line);
               }else{
                   String updline="";
                   updline+=user.getUserName()+"#";
                   updline+=user.getPassword()+"#";
                   updline+=user.getConfirmPassword()+"#";
                   updline+=user.getUid()+"#";
                   updline+=user.getNic()+"#";
                   updline+=user.getPhonenumber()+"#";
                   updline+=user.getEmail();
                   fileData.add(updline);
               }
           }
                FileWriter filewriter=new FileWriter(file);
                bufferedwriter=new BufferedWriter(filewriter);
                for(String linedata:fileData){
                    bufferedwriter.write(linedata);
                    bufferedwriter.newLine();
                }
                return isUserAvailable(user.getUid());
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
   public static boolean deleteUser(String uid) throws IOException,FileNotFoundException,ParseException{
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
               if(!data[3].equals(uid)){
                   filedata.add(line);
               }
           }
           FileWriter filewriter=new FileWriter(file);
           bufferedwriter=new BufferedWriter(filewriter);
           for(String linedata:filedata){
               bufferedwriter.write(linedata);
               bufferedwriter.newLine();
           }
           return isUserAvailable(uid);
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
   public static ArrayList<UserDTO> getAllUsers() throws FileNotFoundException,IOException,ParseException{
       BufferedReader bufferedreader=null;
       ArrayList<UserDTO> user=new ArrayList<>();
       try{
           rwlock.readLock().lock();
           FileReader filereader=new FileReader(file);
           bufferedreader=new BufferedReader(filereader);
           String line=null;
           while((line=bufferedreader.readLine())!=null){
               String [] data=line.split("#");
               UserDTO userdto=new UserDTO();
               userdto.setUserName(data[0]);
               userdto.setPassword(data[1]);
               userdto.setConfirmPassword(data[2]);
               userdto.setUid(data[3]);
               userdto.setNic(data[4]);
               userdto.setPhonenumber(data[5]);
               userdto.setEmail(data[6]);
               user.add(userdto);
           }
           return user;
       }finally{
            if(bufferedreader!=null){
                bufferedreader.close();
            }
            rwlock.readLock().unlock();
       }
   
   
   }
  
    private static boolean isUserAvailable(String uid) throws IOException,FileNotFoundException,ParseException {
        UserDTO user=searchUser(uid);
        return user==null;
    }

}
