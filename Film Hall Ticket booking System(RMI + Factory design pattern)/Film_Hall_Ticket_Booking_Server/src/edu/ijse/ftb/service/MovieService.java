package edu.ijse.ftb.service;

import edu.ijse.ftb.dto.MovieDTO;
import edu.ijse.ftb.fileaccessfactory.FileAccessFactory;
import edu.ijse.ftb.fileaccessfactoryimpl.FileAccessFactoryImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
     private FileAccessFactory faf=new FileAccessFactoryImpl();
    
    
    public boolean addMovie(MovieDTO movie) throws IOException,FileNotFoundException,ParseException{
        return faf.getMovieFileAccess().saveMovie(movie);
    }
    public MovieDTO searchMovie(String id) throws IOException,FileNotFoundException,ParseException{
        return faf.getMovieFileAccess().searchMovie(id);
    }
    public boolean updateMovie(MovieDTO movie) throws IOException,FileNotFoundException,ParseException{
        return faf.getMovieFileAccess().updateMovie(movie);
    }
    public boolean deleteMovie(String id) throws IOException,FileNotFoundException,ParseException{
        return faf.getMovieFileAccess().deleteMovie(id);
    }
    public ArrayList<MovieDTO> getAllMovies() throws IOException,FileNotFoundException,ParseException{
        return faf.getMovieFileAccess().getAllMovies();
    }
}
