package edu.ijse.ftb.controller;

import edu.ijse.ftb.observer.BookedObserver;
import edu.ijse.ftb.observer.Observer;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JLabel;


public interface BookedController extends Remote {
    public void changeLabel(String messege) throws RemoteException;
    public void changelbls(JLabel lbl,String txt)throws RemoteException;
    public void changeButtons(JButton btn,String text)throws RemoteException;
    public void addBookedObserver(BookedObserver bookedobserver)throws RemoteException;
    public void removeBookedObserver(BookedObserver bookedobserver)throws RemoteException;
}
