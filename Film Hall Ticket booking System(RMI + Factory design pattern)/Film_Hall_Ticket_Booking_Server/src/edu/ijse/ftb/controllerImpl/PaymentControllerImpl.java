package edu.ijse.ftb.controllerImpl;

import edu.ijse.ftb.controller.PaymentController;
import edu.ijse.ftb.dto.PaymentDTO;
import edu.ijse.ftb.fileAccess.PaymentFileAccess;
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

public class PaymentControllerImpl extends UnicastRemoteObject implements PaymentController,Subject {

    private final PaymentFileAccess paymentfileaccess=new PaymentFileAccess();
    private static ArrayList<Observer> allobservers=new ArrayList<>();
     private ServiceFactory sf=new ServiceFactoryImpl();
    public PaymentControllerImpl() throws RemoteException{
    }
    
    
    @Override
    public boolean add(PaymentDTO ob)throws ParseException,IOException,FileNotFoundException{
        return sf.getPaymentService().addPayment(ob);
    }

    @Override
    public boolean update(PaymentDTO ob)throws ParseException,IOException,FileNotFoundException{
      return sf.getPaymentService().updatePayment(ob);
    }

    @Override
    public boolean delete(String id)throws ParseException,IOException,FileNotFoundException{
       return sf.getPaymentService().deletePayment(id);
    }

    @Override
    public PaymentDTO search(String id)throws ParseException,IOException,FileNotFoundException{
      return sf.getPaymentService().searchPayment(id);
    }

    @Override
    public List<PaymentDTO> getAll()throws ParseException,IOException,FileNotFoundException{
       return sf.getPaymentService().getAllPayment();
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
        for(Observer ao:allobservers){
          ao.updateLbl(lbl, txt);
      } 
    }

    @Override
    public void notifyObservers(JButton btn, String text) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
