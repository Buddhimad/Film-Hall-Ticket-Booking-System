package edu.ijse.ftb.connector;

import edu.ijse.ftb.controller.BookedController;
import edu.ijse.ftb.controller.CustomerController;
import edu.ijse.ftb.controller.FTBFactory;
import edu.ijse.ftb.controller.MovieController;
import edu.ijse.ftb.controller.PaymentController;
import edu.ijse.ftb.controller.ReservationController;
import edu.ijse.ftb.controller.SeatController;
import edu.ijse.ftb.controller.UserController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ServerConnector {
    private static ServerConnector serverconnector;
    private CustomerController customercontroller;
    private MovieController moviecontroller;
    private PaymentController paymentcontroller;
    private ReservationController reservationcontroller;
    private SeatController seatcontroller;
    private FTBFactory ftbfactory;
    private BookedController bookedcontroller;
    private UserController usrcontroller;
    private ServerConnector() throws NotBoundException,MalformedURLException,RemoteException{
        ftbfactory=(FTBFactory)Naming.lookup("rmi://localhost:4040/ftbserver");
        
    }
    public CustomerController getCustomerController() throws RemoteException{
        if(customercontroller==null){
            customercontroller=(CustomerController)ftbfactory.getController(FTBFactory.ControllerTypes.Customer);
        }
        return customercontroller;
    }
    public MovieController getMovieController() throws RemoteException{
        if(moviecontroller==null){
            moviecontroller=(MovieController)ftbfactory.getController(FTBFactory.ControllerTypes.Movie);
        }
        return moviecontroller;
    }
    public PaymentController getPaymentController() throws RemoteException{
        if(paymentcontroller==null){
            paymentcontroller=(PaymentController)ftbfactory.getController(FTBFactory.ControllerTypes.Payment);
        }
        return paymentcontroller;
    }
    public ReservationController getReservationController() throws RemoteException{
        if(reservationcontroller==null){
            reservationcontroller=(ReservationController)ftbfactory.getController(FTBFactory.ControllerTypes.Reservation);
        }
        return reservationcontroller;
    }
    public SeatController getSeatController() throws RemoteException{
        if(seatcontroller==null){
            seatcontroller=(SeatController)ftbfactory.getController(FTBFactory.ControllerTypes.Seat);
        }
        return seatcontroller;
    }
    public BookedController getBookedController()throws RemoteException{
        if(bookedcontroller==null){
            bookedcontroller=ftbfactory.getControllers();
        }
        return bookedcontroller;
        
    }
     public UserController getUserController() throws RemoteException{
        if(usrcontroller==null){
            usrcontroller=(UserController)ftbfactory.getController(FTBFactory.ControllerTypes.User);
        }
        return usrcontroller;
    }
    public static ServerConnector getServerConnector() throws NotBoundException,MalformedURLException,RemoteException{
        if(serverconnector==null){
            serverconnector=new ServerConnector();
        }
        return serverconnector;
    }
}
