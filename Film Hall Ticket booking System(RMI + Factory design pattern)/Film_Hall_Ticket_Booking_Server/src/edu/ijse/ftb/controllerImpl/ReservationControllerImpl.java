package edu.ijse.ftb.controllerImpl;

import edu.ijse.ftb.controller.ReservationController;
import edu.ijse.ftb.dto.ReservationDTO;
import edu.ijse.ftb.observer.Observer;
import edu.ijse.ftb.observer.Subject;
import edu.ijse.ftb.servicefactory.ServiceFactory;
import edu.ijse.ftb.servicefactoryImpl.ServiceFactoryImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;


public class ReservationControllerImpl extends UnicastRemoteObject implements ReservationController,Subject {
      //  private TestingWindow tw;
    private ServiceFactory sf=new ServiceFactoryImpl(); 
    private static ArrayList<Observer>ob=new ArrayList<>();
    public ReservationControllerImpl() throws RemoteException{
    }

    @Override
    public boolean add(ReservationDTO ob)throws ParseException,IOException,FileNotFoundException{
        return sf.getReservationService().addReservation(ob);
    }

    @Override
    public boolean update(ReservationDTO ob) throws ParseException,IOException,FileNotFoundException{
      return sf.getReservationService().updateReservation(ob);
    }

    @Override
    public boolean delete(String id)throws ParseException,IOException,FileNotFoundException{
        return sf.getReservationService().deleteReservation(id);
    }

    @Override
    public ReservationDTO search(String id)throws ParseException,IOException,FileNotFoundException{
       return sf.getReservationService().searchReservation(id);
    }

    @Override
    public List<ReservationDTO> getAll()throws ParseException,IOException,FileNotFoundException{
      return sf.getReservationService().getAllReservations();
    }

    @Override
    public void registerObserver(Observer o) throws RemoteException {
     ob.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) throws RemoteException {
        ob.remove(o);
    }

    @Override
    public void notifyObservers(String message) throws RemoteException {
        for(Observer obb:ob){
            obb.update(message);
        }
    }

    @Override
    public void changeButton(String messege) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
