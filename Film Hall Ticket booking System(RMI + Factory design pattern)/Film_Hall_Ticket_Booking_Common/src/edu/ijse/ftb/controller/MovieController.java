package edu.ijse.ftb.controller;

import edu.ijse.ftb.dto.MovieDTO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

public interface MovieController extends SuperController<MovieDTO> {
    public ArrayList<MovieDTO> getAllMovies() throws ParseException,IOException,FileNotFoundException;
    public void checkMovieId(String mid)throws RemoteException;
}
