package edu.ijse.ftb.service;

import edu.ijse.ftb.dto.CustomerDTO;
import edu.ijse.ftb.fileaccessfactory.FileAccessFactory;
import edu.ijse.ftb.fileaccessfactoryimpl.FileAccessFactoryImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    
    private FileAccessFactory faf=new FileAccessFactoryImpl();
    public boolean addCustomer(CustomerDTO customer) throws IOException,FileNotFoundException,ParseException{
        return faf.getCustomerFileAccess().saveCustomer(customer);
    }
    public CustomerDTO searchCustomer(String id) throws IOException,FileNotFoundException,ParseException{
        return faf.getCustomerFileAccess().searchCustomers(id);
    }
    public boolean updateCustomers(CustomerDTO customer) throws IOException,FileNotFoundException,ParseException{
        return faf.getCustomerFileAccess().updateCustomer(customer);
    }
    public boolean deleteCustomer(String cid) throws IOException,FileNotFoundException,ParseException{
        return faf.getCustomerFileAccess().deleteCustomers(cid);
    }
    public List<CustomerDTO> getAllCustomers() throws IOException,FileNotFoundException,ParseException{
        return faf.getCustomerFileAccess().getAllCustomer();
    }
}
