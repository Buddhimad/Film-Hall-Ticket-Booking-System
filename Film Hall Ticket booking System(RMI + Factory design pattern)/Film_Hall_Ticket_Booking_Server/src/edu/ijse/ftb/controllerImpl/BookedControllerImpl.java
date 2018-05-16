package edu.ijse.ftb.controllerImpl;

import edu.ijse.ftb.controller.BookedController;
import edu.ijse.ftb.observable.BookedObservable;
import edu.ijse.ftb.observer.BookedObserver;
import edu.ijse.ftb.observer.Observer;
import edu.ijse.ftb.observer.Subject;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;

public class BookedControllerImpl extends UnicastRemoteObject implements BookedController, Subject {

    private static ArrayList<Observer> book = new ArrayList<>();
    private static BookedObservable bo = new BookedObservable();

    public BookedControllerImpl() throws RemoteException {
    }

    @Override
    public void changeLabel(String messege) throws RemoteException {
        notifyObservers(messege);
    }

    @Override
    public void addBookedObserver(BookedObserver bookedobserver) throws RemoteException {
        bo.addBookedObserver(bookedobserver);
    }

    @Override
    public void removeBookedObserver(BookedObserver bookedobserver) throws RemoteException {
        bo.removeBookedObserver(bookedobserver);
    }

    @Override
    public void registerObserver(Observer o) throws RemoteException {
        book.add(o);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unregisterObserver(Observer o) throws RemoteException {
        book.remove(o);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObservers(String message) throws RemoteException {
        for (Observer ob : book) {
            ob.incCID(message);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObservers(JLabel lbl, String txt) throws RemoteException {
        //notifyObservers(lbl,txt);
        for (Observer ob : book) {
            ob.updateLbl(lbl, txt);
        }
    }

    @Override
    public void changelbls(JLabel lbl, String txt) throws RemoteException {
        notifyObservers(lbl, txt);
    }

    @Override
    public void changeButtons(JButton btn, String text) throws RemoteException {
        notifyObservers(btn, text);
    }

    @Override
    public void notifyObservers(JButton btn, String text) throws RemoteException {
        for (Observer ob : book) {
            ob.updateButton(btn, text);
        }
    }
}
