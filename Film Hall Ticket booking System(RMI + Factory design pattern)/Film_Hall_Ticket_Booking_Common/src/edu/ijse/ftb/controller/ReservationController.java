package edu.ijse.ftb.controller;

import edu.ijse.ftb.dto.ReservationDTO;
import java.io.IOException;
import java.rmi.RemoteException;


public interface ReservationController extends SuperController<ReservationDTO> {
      public void changeButton(String messege)throws RemoteException,IOException;
      
}
