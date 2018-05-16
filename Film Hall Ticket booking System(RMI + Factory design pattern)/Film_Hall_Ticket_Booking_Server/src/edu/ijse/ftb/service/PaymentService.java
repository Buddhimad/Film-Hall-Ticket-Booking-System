package edu.ijse.ftb.service;

import edu.ijse.ftb.dto.PaymentDTO;
import edu.ijse.ftb.fileaccessfactory.FileAccessFactory;
import edu.ijse.ftb.fileaccessfactoryimpl.FileAccessFactoryImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class PaymentService {
    
    private FileAccessFactory faf=new FileAccessFactoryImpl();
    
    
    public boolean addPayment(PaymentDTO payment) throws IOException,FileNotFoundException,ParseException{
        return faf.getPaymentFileAccess().savePayment(payment);
    }
    public PaymentDTO searchPayment(String id) throws IOException,FileNotFoundException,ParseException{
        return faf.getPaymentFileAccess().searchPayment(id);
    }
    public boolean updatePayment(PaymentDTO payment) throws IOException,FileNotFoundException,ParseException{
        return faf.getPaymentFileAccess().updatePayment(payment);
    }
    public boolean deletePayment(String cid) throws IOException,FileNotFoundException,ParseException{
        return faf.getPaymentFileAccess().deletePayment(cid);
    }
    public List<PaymentDTO> getAllPayment() throws IOException,FileNotFoundException,ParseException{
        return faf.getPaymentFileAccess().getAllPayments();
    }
}
