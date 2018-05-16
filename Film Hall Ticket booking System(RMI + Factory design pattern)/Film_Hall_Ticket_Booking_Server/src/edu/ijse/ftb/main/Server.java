package edu.ijse.ftb.main;

import edu.ijse.ftb.controllerImpl.BookedControllerImpl;
import edu.ijse.ftb.controllerImpl.FTBFactoryImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
//    public static void main(String [] args){
//        
//            try {
//                Registry registry=LocateRegistry.createRegistry(4040);
//                System.out.println("Server is Strat...");
//                registry.rebind("ftbserver", FTBFactoryImpl.getFTBFactory());
//                //registry.rebind("ftbserver",new BookedControllerImpl());
//            } catch (RemoteException ex) {
//                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        }
    
}
