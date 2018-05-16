package edu.ijse.ftb.fileaccessfactory;

import edu.ijse.ftb.fileAccess.CustomerFileAccess;
import edu.ijse.ftb.fileAccess.MovieFileAccess;
import edu.ijse.ftb.fileAccess.PaymentFileAccess;
import edu.ijse.ftb.fileAccess.ReservationFileAccess;
import edu.ijse.ftb.fileAccess.SeatFileAccess;
import edu.ijse.ftb.fileAccess.UserFileAccess;

public interface FileAccessFactory {
    public CustomerFileAccess getCustomerFileAccess();
    public MovieFileAccess getMovieFileAccess();
    public PaymentFileAccess getPaymentFileAccess();
    public ReservationFileAccess getReservationFileAccess();
    public SeatFileAccess getSeatFileAccess();
    public UserFileAccess getUserFileAccess();
}
