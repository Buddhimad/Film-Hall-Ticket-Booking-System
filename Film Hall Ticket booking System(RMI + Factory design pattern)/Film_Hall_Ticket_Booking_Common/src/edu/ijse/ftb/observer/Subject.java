package edu.ijse.ftb.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JLabel;


public interface Subject extends Remote{
    public void registerObserver(Observer o) throws RemoteException;
    public void unregisterObserver(Observer o) throws RemoteException;
    public void notifyObservers(String message) throws RemoteException;
    public void notifyObservers(JLabel lbl,String txt)throws RemoteException;
    public void notifyObservers(JButton btn,String text)throws RemoteException;
    
    
   // public void notifyBookedObserver(String messege)throws RemoteException;
}
