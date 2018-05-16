package edu.ijse.ftb.observable;

import edu.ijse.ftb.observer.BookedObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class BookedObservable {
    private final ArrayList<BookedObserver>observerlist=new ArrayList<>();
    
    public void addBookedObserver(BookedObserver bo)throws RemoteException{
        observerlist.add(bo);
    }
    public void removeBookedObserver(BookedObserver bo)throws RemoteException{
        observerlist.remove(bo);
    }
    public void notifyObserver(String messege)throws RemoteException{
        for(BookedObserver obl:observerlist){
            obl.updateLabel(messege);
        }
    }
}
