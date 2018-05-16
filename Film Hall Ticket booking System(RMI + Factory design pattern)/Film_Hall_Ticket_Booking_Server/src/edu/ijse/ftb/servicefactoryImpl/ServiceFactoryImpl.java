package edu.ijse.ftb.servicefactoryImpl;

import edu.ijse.ftb.service.CustomerService;
import edu.ijse.ftb.service.MovieService;
import edu.ijse.ftb.service.PaymentService;
import edu.ijse.ftb.service.ReservationService;
import edu.ijse.ftb.service.SeatService;
import edu.ijse.ftb.service.UserService;
import edu.ijse.ftb.servicefactory.ServiceFactory;

public class ServiceFactoryImpl implements ServiceFactory {

    @Override
    public CustomerService getCustomerService() {
        return new CustomerService();
    }

    @Override
    public MovieService getMovieService() {
      return new MovieService();  
    }

    @Override
    public PaymentService getPaymentService() {
        return new PaymentService();
    }

    @Override
    public ReservationService getReservationService() {
        return new ReservationService();
    }

    @Override
    public SeatService getSeatService() {
       return new SeatService();
    }

    @Override
    public UserService getUserService() {
       return new UserService();
    }
    
}
