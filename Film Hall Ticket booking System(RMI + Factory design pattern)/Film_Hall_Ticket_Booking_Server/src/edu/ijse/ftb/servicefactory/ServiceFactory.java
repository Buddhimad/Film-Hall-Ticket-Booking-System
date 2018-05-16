package edu.ijse.ftb.servicefactory;

import edu.ijse.ftb.service.CustomerService;
import edu.ijse.ftb.service.MovieService;
import edu.ijse.ftb.service.PaymentService;
import edu.ijse.ftb.service.ReservationService;
import edu.ijse.ftb.service.SeatService;
import edu.ijse.ftb.service.UserService;

public interface ServiceFactory {
    public CustomerService getCustomerService();
    public MovieService getMovieService();
    public PaymentService getPaymentService();
    public ReservationService getReservationService();
    public SeatService getSeatService();
    public UserService getUserService();
}
