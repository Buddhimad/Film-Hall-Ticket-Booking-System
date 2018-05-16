package edu.ijse.ftb.fileAccess;

import edu.ijse.ftb.dto.MovieDTO;
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


public class MovieFileAccess {
   private static final String filePath="./src/edu/ijse/ftb/file/Movie.txt";
//   private static final String fileExtension=".txt";
   private static final String ffile=filePath;
//+date+"."+fileExtension;
   private static final java.io.File file =new java.io.File(ffile);
   private static  ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();
   
   
    public static boolean saveMovie(MovieDTO movie) throws IOException,FileNotFoundException,ParseException{
        if(!file.exists()){
            boolean createNewFile=file.createNewFile();
        }
        rwlock.writeLock().lock();
        String line="";
        line+=movie.getMoid()+"#";
        line+=movie.getName()+"#";
        line+=movie.getLanguage()+"#";
        line+=movie.getDuration()+"#";
        line+=movie.getAvailableTime()+"#";
        line+=movie.getStartDate()+"#";
        line+=movie.getEndDate()+"#";
        line+=movie.getVideoQuality();
        
        BufferedWriter bufferedwriter=null;
        try{
            FileWriter filewriter=new FileWriter(file,true);
            bufferedwriter=new BufferedWriter(filewriter);
            bufferedwriter.write(line);
            bufferedwriter.newLine();
            return isMovieAvailable(movie.getMoid());
        }finally{
            if(bufferedwriter!=null){
                bufferedwriter.close();
            }
            rwlock.writeLock().unlock();
        }
   }
   public static MovieDTO searchMovie(String pid) throws IOException,FileNotFoundException,ParseException{
       BufferedReader bufferedreader=null;
       MovieDTO moviedto=null;
       try{
       rwlock.readLock().lock();
       FileReader filereader=new FileReader(file);
       bufferedreader=new BufferedReader(filereader);
       String line=null;
       while((line=bufferedreader.readLine())!=null){
           String[] data=line.split("#");
           if(data[0].equals(pid)){
              moviedto=new MovieDTO();
              moviedto.setMoid(data[0]);
              moviedto.setName(data[1]);
              moviedto.setLanguage(data[2]);
              moviedto.setDuration(data[3]);
              moviedto.setAvailableTime(data[4]);
              moviedto.setStartDate(data[5]);
              moviedto.setEndDate(data[6]);
              moviedto.setVideoQuality(data[7]);
           }
       }
       return moviedto;
       }finally{
               if(bufferedreader!=null){
                   bufferedreader.close();
               }
               rwlock.readLock().unlock();
       }
   }
   public static boolean updateMovie(MovieDTO movie)throws IOException,FileNotFoundException,ParseException{
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
               if(!data[0].equals(movie.getMoid())){
                   fileData.add(line);
               }else{
                   String updline="";
                  updline+=movie.getMoid()+"#";
                  updline+=movie.getName()+"#";
                  updline+=movie.getLanguage()+"#";
                  updline+=movie.getDuration()+"#";
                  updline+=movie.getAvailableTime()+"#";
                  updline+=movie.getStartDate()+"#";
                  updline+=movie.getEndDate()+"#";
                  updline+=movie.getVideoQuality();
                   fileData.add(updline);
               }
           }
                FileWriter filewriter=new FileWriter(file);
                bufferedwriter=new BufferedWriter(filewriter);
                for(String linedata:fileData){
                    bufferedwriter.write(linedata);
                    bufferedwriter.newLine();
                }
                return isMovieAvailable(movie.getMoid());
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
   public static boolean deleteMovie(String mid) throws IOException,FileNotFoundException,ParseException{
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
               if(!data[0].equals(mid)){
                   filedata.add(line);
               }
           }
           FileWriter filewriter=new FileWriter(file);
           bufferedwriter=new BufferedWriter(filewriter);
           for(String linedata:filedata){
               bufferedwriter.write(linedata);
               bufferedwriter.newLine();
           }
           return isMovieAvailable(mid);
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
   public static ArrayList<MovieDTO> getAllMovies() throws FileNotFoundException,IOException,ParseException{
       BufferedReader bufferedreader=null;
       ArrayList<MovieDTO> movie=new ArrayList<>();
       try{
           rwlock.readLock().lock();
           FileReader filereader=new FileReader(file);
           bufferedreader=new BufferedReader(filereader);
           String line=null;
           while((line=bufferedreader.readLine())!=null){
               String [] data=line.split("#");
               MovieDTO movies=new MovieDTO();
               movies.setMoid(data[0]);
               movies.setName(data[1]);
               movies.setLanguage(data[2]);
               movies.setDuration(data[3]);
               movies.setAvailableTime(data[4]);
               movies.setStartDate(data[5]);
               movies.setEndDate(data[6]);
               movies.setVideoQuality(data[7]);
               movie.add(movies);
           }
           return movie;
       }finally{
            if(bufferedreader!=null){
                bufferedreader.close();
            }
            rwlock.readLock().unlock();
       }
   
   
   }
  
    private static boolean isMovieAvailable(String cid) throws IOException,FileNotFoundException,ParseException {
        MovieDTO movie=searchMovie(cid);
        return movie==null;
    }

}
