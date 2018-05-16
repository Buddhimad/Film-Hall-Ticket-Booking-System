package edu.ijse.ftb.observerImpl;

import edu.ijse.ftb.observer.BookedObserver;
import edu.ijse.ftb.view.TestingWindow;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Dell
 */
public class BookedObserverImpl extends UnicastRemoteObject implements BookedObserver{
    private  TestingWindow tw;
    
    public BookedObserverImpl(TestingWindow tw)throws RemoteException{
        this.tw=tw;
    }

    @Override
    public void updateLabel(String messege) throws RemoteException {
        tw.showBooked(messege);
    }
    
}
