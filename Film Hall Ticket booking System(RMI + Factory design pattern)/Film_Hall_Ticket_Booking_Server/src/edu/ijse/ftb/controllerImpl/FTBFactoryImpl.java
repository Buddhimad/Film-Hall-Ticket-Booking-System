package edu.ijse.ftb.controllerImpl;

import edu.ijse.ftb.controller.BookedController;
import edu.ijse.ftb.controller.FTBFactory;
import edu.ijse.ftb.controller.SuperController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FTBFactoryImpl extends UnicastRemoteObject implements FTBFactory{
    
    private static FTBFactory ftbfactory;

    public FTBFactoryImpl() throws RemoteException {
    }
    public static FTBFactory getFTBFactory() throws RemoteException{
        if(ftbfactory==null){
            ftbfactory=new FTBFactoryImpl();
        }
        return ftbfactory;
    }
    @Override
    public SuperController getController(ControllerTypes controller) throws RemoteException {
        switch(controller){
            case Customer:
                return new CustomerControllerImpl();
            case Movie:
                return new MovieControllerImpl();
            case Payment:
                return new PaymentControllerImpl();
            case Reservation:
                return new ReservationControllerImpl();
            case Seat:
                return new SeatControllerImpl();
            case User:
                return new UserControllerImpl();
            default:
                return null;
        }
    }

    @Override
    public BookedController getControllers() throws RemoteException {
       return new BookedControllerImpl();
    }
    
    
}
