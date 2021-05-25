package controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.Movie;
import repositories.MovieRepo;

import java.util.List;

public class MovieController {

    //Typically Our controllers would communicate to a Service; however,
    //in the interest of time I am going to use our Repos.

    private MovieRepo mr;
    private Gson gson = new Gson();

    public MovieController(MovieRepo movieRepo) {
        this.mr = movieRepo;
    }

    public Handler getAllMovies = (context) -> {

        List<Movie> movies = this.mr.getAllMovies();
        String moviesJSON = gson.toJson(movies);
        //You pass information through result() to send information back (response)
        context.result(moviesJSON);
    };

    public Handler getMovieById = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        Movie m = mr.getMovie(id);
        context.result(gson.toJson(m));
    };

    public Handler createMovie = (context) -> {
        Movie movie = gson.fromJson(context.body(), Movie.class);

        Movie updatedMovie = mr.addMovie(movie);
        context.result(gson.toJson(updatedMovie));
    };

}