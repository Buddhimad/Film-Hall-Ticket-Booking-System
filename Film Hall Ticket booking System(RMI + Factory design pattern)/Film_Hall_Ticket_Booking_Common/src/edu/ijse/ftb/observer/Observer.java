
package edu.ijse.ftb.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JLabel;

public interface Observer extends Remote{
   public void update(String message) throws RemoteException;
   public void updateLabel(String messege)throws RemoteException;
   public void updateButton(JButton btn,String text)throws RemoteException;
   public void updateLbl(JLabel lbl,String text)throws RemoteException;
   public void incCID(String cid)throws RemoteException;
   public void AdjustMID(String mid)throws RemoteException;
}
