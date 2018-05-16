package edu.ijse.ftb.controller;

import edu.ijse.ftb.dto.CustomerDTO;
import java.rmi.RemoteException;

public interface CustomerController extends SuperController<CustomerDTO>{
      public void changeCID(String cid)throws RemoteException;
}
