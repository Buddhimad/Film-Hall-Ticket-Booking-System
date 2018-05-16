package edu.ijse.ftb.controllerImpl;

import edu.ijse.ftb.controller.CustomerController;
import edu.ijse.ftb.dto.CustomerDTO;
import edu.ijse.ftb.fileAccess.CustomerFileAccess;
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

public class CustomerControllerImpl extends UnicastRemoteObject implements CustomerController,Subject {
    private final CustomerFileAccess customerfileaccess=new CustomerFileAccess();
    private static ArrayList<Observer> allobservers=new ArrayList<>();
    //Observer o=new Observer();
    private ServiceFactory sf=new ServiceFactoryImpl();
    public CustomerControllerImpl() throws RemoteException{
    }
    

    @Override
    public boolean add(CustomerDTO ob) throws IOException, FileNotFoundException,ParseException {
       return sf.getCustomerService().addCustomer(ob);
        
    }

    @Override
    public boolean update(CustomerDTO ob)throws IOException, FileNotFoundException,ParseException {
        return sf.getCustomerService().updateCustomers(ob);
    }

    @Override
    public boolean delete(String id)throws IOException, FileNotFoundException,ParseException {
       return sf.getCustomerService().deleteCustomer(id);
    }

    @Override
    public CustomerDTO search(String id)throws IOException, FileNotFoundException,ParseException {
        return sf.getCustomerService().searchCustomer(id);
    }

    @Override
    public List<CustomerDTO> getAll()throws IOException, FileNotFoundException,ParseException {
        return sf.getCustomerService().getAllCustomers();
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
       for(Observer al:allobservers){
           al.incCID(message);
           
       }
      // System.out.println("OK");
    }

    @Override
    public void notifyObservers(JLabel lbl, String txt) throws RemoteException {
      for(Observer ao:allobservers){
          ao.updateLbl(lbl, txt);
      } 
    }

    @Override
    public void changeCID(String cid) throws RemoteException {
        notifyObservers(cid);
        System.out.println("OK");
    }

    @Override
    public void notifyObservers(JButton btn, String text) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
