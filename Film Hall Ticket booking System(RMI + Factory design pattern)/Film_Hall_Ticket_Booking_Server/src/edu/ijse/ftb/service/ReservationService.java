package edu.ijse.ftb.service;

import edu.ijse.ftb.dto.ReservationDTO;
import edu.ijse.ftb.fileaccessfactory.FileAccessFactory;
import edu.ijse.ftb.fileaccessfactoryimpl.FileAccessFactoryImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;


public class ReservationService {
     private FileAccessFactory faf=new FileAccessFactoryImpl();
    public boolean addReservation(ReservationDTO reservation) throws IOException,FileNotFoundException,ParseException{
        return faf.getReservationFileAccess().saveReservation(reservation);
    }
    public ReservationDTO searchReservation(String id) throws IOException,FileNotFoundException,ParseException{
        return faf.getReservationFileAccess().searchReservations(id);
    }
    public boolean updateReservation(ReservationDTO reservation) throws IOException,FileNotFoundException,ParseException{
        return faf.getReservationFileAccess().updateReservation(reservation);
    }
    public boolean deleteReservation(String cid) throws IOException,FileNotFoundException,ParseException{
        return faf.getReservationFileAccess().deleteReservation(cid);
    }
    public List<ReservationDTO> getAllReservations() throws IOException,FileNotFoundException,ParseException{
        return faf.getReservationFileAccess().getAllReservations();
    }
}
