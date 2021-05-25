package services;

import models.Movie;
import repositories.MovieRepo;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    public MovieRepo mr;


    public MovieService(MovieRepo mr) {
        this.mr = mr;
    }

    public List<Movie> getMoviesAbovePrice(int price) {

        List<Movie> movies = mr.getAllMovies();
        List<Movie> refinedMovies = new ArrayList<Movie>();

        for (Movie m : movies) {
            if (m.getPrice() >= price) {
                refinedMovies.add(m);
            }
        }

        return refinedMovies;
    }

}