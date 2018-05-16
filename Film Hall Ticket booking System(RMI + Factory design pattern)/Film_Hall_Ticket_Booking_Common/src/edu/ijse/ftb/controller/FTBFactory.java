package edu.ijse.ftb.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FTBFactory extends Remote {
    public enum ControllerTypes{
        Customer,Movie,Payment,Reservation,Seat,Booked,User;
    }
    public SuperController getController(ControllerTypes controller)throws RemoteException;
    public BookedController getControllers()throws RemoteException;
}
