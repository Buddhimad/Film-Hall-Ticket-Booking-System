package edu.ijse.ftb.controllerImpl;

import edu.ijse.ftb.controller.MovieController;
import edu.ijse.ftb.dto.MovieDTO;
import edu.ijse.ftb.fileAccess.MovieFileAccess;
import edu.ijse.ftb.observer.Observer;
import edu.ijse.ftb.observer.Subject;
import edu.ijse.ftb.servicefactory.ServiceFactory;
import edu.ijse.ftb.servicefactoryImpl.ServiceFactoryImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;


public class MovieControllerImpl extends UnicastRemoteObject implements MovieController,Subject {
 private ServiceFactory sf=new ServiceFactoryImpl();
 private final MovieFileAccess moviefileaccess=new MovieFileAccess();
  private static ArrayList<Observer> allobservers=new ArrayList<>();
    public MovieControllerImpl() throws RemoteException{
    }

    @Override
    public boolean add(MovieDTO ob) throws ParseException,IOException,FileNotFoundException{
      return sf.getMovieService().addMovie(ob);
      //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(MovieDTO ob) throws ParseException,IOException,FileNotFoundException{
     return sf.getMovieService().updateMovie(ob);
    }

    @Override
    public boolean delete(String id)throws ParseException,IOException,FileNotFoundException{
     return sf.getMovieService().deleteMovie(id);
    }

    @Override
    public MovieDTO search(String id) throws ParseException,IOException,FileNotFoundException{
        return sf.getMovieService().searchMovie(id);
    }

    @Override
    public List<MovieDTO> getAll()throws ParseException,IOException,FileNotFoundException{
        return sf.getMovieService().getAllMovies();
    }

    @Override
    public void registerObserver(Observer o) throws RemoteException {
       allobservers.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) throws RemoteException {
          allobservers.remove(o);
    }

    @Override
    public void notifyObservers(String message) throws RemoteException {
         for(Observer allobserver:allobservers){
           allobserver.AdjustMID(message);
         
       }
    }

    @Override
    public void notifyObservers(JLabel lbl, String txt) throws RemoteException {
        for(Observer ao:allobservers){
          ao.updateLbl(lbl, txt);
      } 
    }

    @Override
    public void notifyObservers(JButton btn, String text) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MovieDTO> getAllMovies() throws ParseException, IOException, FileNotFoundException {
       return sf.getMovieService().getAllMovies();
    }

    @Override
    public void checkMovieId(String mid) throws RemoteException {
       notifyObservers(mid);
    }
    
}
