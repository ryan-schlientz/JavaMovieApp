package app;

import controllers.MovieController;
import io.javalin.Javalin;
import models.Movie;
import repositories.MovieRepo;
import repositories.MovieRepoImpl;

public class App {

    public static void main(String[] args) {

//      testRepos();

        Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());
        establishRoutes(app);

        app.start(7001);

    }

    private static void testRepos() {
        MovieRepo mr = new MovieRepoImpl();

        //Get Movie
        Movie m = mr.getMovie(11);
        System.out.println(m);
        //Get All Movies
        System.out.println(mr.getAllMovies());

        //Add Movie
        Movie movie = new Movie();
        movie.setTitle("The Incredible Hulk");
        movie.setPrice(4.50);
        movie.setAvailable(true);

        movie = mr.addMovie(movie);
        System.out.println(movie);

        movie.setPrice(movie.getPrice() + 1);
        movie.setTitle("Captain America: The First Avenger");
        movie = mr.updateMovie(movie);

        System.out.println(movie);

        System.out.println(mr.deleteMovie(movie.getId()));
    }

    public static void establishRoutes(Javalin app) {

        //This can be a place for us to put all of our Javalin work.
        //Instantiate any classes that Javalin would need.

        //Please remember that I am skipping over the Service layer for now!!!!!
        MovieRepo mr = new MovieRepoImpl();
        MovieController mc = new MovieController(mr);

        //Anonymous Functions (Callback Function)
        app.get("/hello", (context) -> context.result("Hello World!!!!!!"));
        app.get("/", (context) -> context.result("This is Our Movie App Home Page!"));

        app.get("/movies", mc.getAllMovies);
        app.get("/movies/:id", mc.getMovieById);
        app.post("/movies", mc.createMovie);

    }


}
