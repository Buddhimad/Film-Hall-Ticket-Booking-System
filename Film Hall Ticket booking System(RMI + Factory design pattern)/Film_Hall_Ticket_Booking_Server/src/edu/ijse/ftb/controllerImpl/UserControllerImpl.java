package edu.ijse.ftb.controllerImpl;

import edu.ijse.ftb.controller.UserController;
import edu.ijse.ftb.dto.UserDTO;
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

public class UserControllerImpl extends UnicastRemoteObject implements UserController,Subject {
    private static ArrayList<Observer> allobservers=new ArrayList<>();
    //Observer o=new Observer();
    private ServiceFactory sf=new ServiceFactoryImpl();
    public UserControllerImpl() throws RemoteException {
    }
    
    @Override
    public boolean add(UserDTO ob) throws ParseException, IOException, FileNotFoundException {
        return sf.getUserService().addUser(ob);
    }

    @Override
    public boolean update(UserDTO ob) throws ParseException, IOException, FileNotFoundException {
        return sf.getUserService().updateUsers(ob);
    }

    @Override
    public boolean delete(String id) throws ParseException, IOException, FileNotFoundException {
        return sf.getUserService().deleteUser(id);
    }

    @Override
    public UserDTO search(String id) throws ParseException, IOException, FileNotFoundException {
        return sf.getUserService().searchUserr(id);
    }

    @Override
    public List<UserDTO> getAll() throws ParseException, IOException, FileNotFoundException {
        return sf.getUserService().getAllCustomers();
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
