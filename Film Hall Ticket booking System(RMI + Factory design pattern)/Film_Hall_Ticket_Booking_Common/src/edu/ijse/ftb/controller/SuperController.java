package edu.ijse.ftb.controller;

import edu.ijse.ftb.dto.SuperDTO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.text.ParseException;
import java.util.List;
 

public interface SuperController<T extends SuperDTO> extends Remote {
    public boolean add(T ob) throws ParseException,IOException,FileNotFoundException;
    public boolean update(T ob) throws ParseException,IOException,FileNotFoundException;
    public boolean delete(String id) throws ParseException,IOException,FileNotFoundException;
    public T search(String id) throws ParseException,IOException,FileNotFoundException;
    public List<T> getAll() throws ParseException,IOException,FileNotFoundException;
}
