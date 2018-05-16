package edu.ijse.ftb.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dell
 */
public interface BookedObserver extends Remote {
    public void updateLabel(String messege)throws RemoteException;
}
