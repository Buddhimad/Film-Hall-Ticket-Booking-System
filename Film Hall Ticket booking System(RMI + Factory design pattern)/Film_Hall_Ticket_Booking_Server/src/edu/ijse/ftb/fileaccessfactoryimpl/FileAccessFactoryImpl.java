package edu.ijse.ftb.fileaccessfactoryimpl;

import edu.ijse.ftb.fileAccess.CustomerFileAccess;
import edu.ijse.ftb.fileAccess.MovieFileAccess;
import edu.ijse.ftb.fileAccess.PaymentFileAccess;
import edu.ijse.ftb.fileAccess.ReservationFileAccess;
import edu.ijse.ftb.fileAccess.SeatFileAccess;
import edu.ijse.ftb.fileAccess.UserFileAccess;
import edu.ijse.ftb.fileaccessfactory.FileAccessFactory;

public class FileAccessFactoryImpl implements FileAccessFactory{

  
    @Override
    public CustomerFileAccess getCustomerFileAccess() {
        return new CustomerFileAccess();
    }

    @Override
    public MovieFileAccess getMovieFileAccess() {
        return new MovieFileAccess();
    }

    @Override
    public PaymentFileAccess getPaymentFileAccess() {
        return new PaymentFileAccess();
    }

    @Override
    public ReservationFileAccess getReservationFileAccess() {
        return new ReservationFileAccess();
    }

    @Override
    public SeatFileAccess getSeatFileAccess() {
       return new SeatFileAccess();
    }

    @Override
    public UserFileAccess getUserFileAccess() {
      return new UserFileAccess(); 
    }
    
    
}
