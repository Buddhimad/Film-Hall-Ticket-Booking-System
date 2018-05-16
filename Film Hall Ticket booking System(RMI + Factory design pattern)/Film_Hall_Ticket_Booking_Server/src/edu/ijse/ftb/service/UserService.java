package edu.ijse.ftb.service;

import edu.ijse.ftb.dto.UserDTO;
import edu.ijse.ftb.fileaccessfactory.FileAccessFactory;
import edu.ijse.ftb.fileaccessfactoryimpl.FileAccessFactoryImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class UserService {
     private FileAccessFactory faf=new FileAccessFactoryImpl();
    public boolean addUser(UserDTO user) throws IOException,FileNotFoundException,ParseException{
        return faf.getUserFileAccess().saveUsers(user);
    }
    public UserDTO searchUserr(String id) throws IOException,FileNotFoundException,ParseException{
        return faf.getUserFileAccess().searchUser(id);
    }
    public boolean updateUsers(UserDTO user) throws IOException,FileNotFoundException,ParseException{
        return faf.getUserFileAccess().updateUser(user);
    }
    public boolean deleteUser(String cid) throws IOException,FileNotFoundException,ParseException{
        return faf.getUserFileAccess().deleteUser(cid);
    }
    public List<UserDTO> getAllCustomers() throws IOException,FileNotFoundException,ParseException{
        return faf.getUserFileAccess().getAllUsers();
    }
}
