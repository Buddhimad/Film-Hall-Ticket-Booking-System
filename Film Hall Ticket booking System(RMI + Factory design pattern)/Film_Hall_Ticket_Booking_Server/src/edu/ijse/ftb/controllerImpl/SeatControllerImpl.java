package edu.ijse.ftb.controllerImpl;

import edu.ijse.ftb.controller.SeatController;
import edu.ijse.ftb.dto.SeatDTO;
import edu.ijse.ftb.observer.Observer;
import edu.ijse.ftb.observer.Subject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SeatControllerImpl extends UnicastRemoteObject implements SeatController,Subject {
private static ArrayList<Observer> allobservers=new ArrayList<>();
    public SeatControllerImpl() throws RemoteException{
    }

    @Override
    public boolean add(SeatDTO ob)throws ParseException,IOException,FileNotFoundException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(SeatDTO ob)throws ParseException,IOException,FileNotFoundException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id)throws ParseException,IOException,FileNotFoundException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SeatDTO search(String id)throws ParseException,IOException,FileNotFoundException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SeatDTO> getAll()throws ParseException,IOException,FileNotFoundException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
           allobserver.update(message);
          
          
       }
    }

    @Override
    public void notifyObservers(JLabel lbl, String txt) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObservers(JButton btn, String text) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
