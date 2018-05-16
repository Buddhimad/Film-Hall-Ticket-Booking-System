package edu.ijse.ftb.factory;

import edu.ijse.ftb.controller.BookedController;
import edu.ijse.ftb.controller.CustomerController;
import edu.ijse.ftb.controller.MovieController;
import edu.ijse.ftb.controller.PaymentController;
import edu.ijse.ftb.controller.ReservationController;
import edu.ijse.ftb.controller.SeatController;
import edu.ijse.ftb.controller.UserController;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;

public interface TicketsReservationFactory extends Remote {
    public CustomerController getCustomerController() throws RemoteException,ClassNotFoundException,ParseException;
    public MovieController getMovieController() throws RemoteException,ClassNotFoundException,ParseException;
    public PaymentController getPaymentController() throws RemoteException,ClassNotFoundException,ParseException;
    public ReservationController getReservationController() throws RemoteException,ClassNotFoundException,ParseException;
    public SeatController getSeatController()  throws RemoteException,ClassNotFoundException,ParseException;
    public UserController getUserController()  throws RemoteException,ClassNotFoundException,ParseException;
    public BookedController getBookedController() throws RemoteException,ClassNotFoundException,ParseException;
}
