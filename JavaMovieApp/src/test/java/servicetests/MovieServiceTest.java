package servicetests;

import models.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import repositories.MovieRepo;
import repositories.MovieRepoImpl;
import services.MovieService;

import java.util.ArrayList;
import java.util.List;

@TestInstance(Lifecycle.PER_CLASS)
public class MovieServiceTest {

    @Mock
    MovieRepo movieRepo;

    @InjectMocks
    MovieService movieService;


    @BeforeAll
    public void setUp() {
        movieRepo = new MovieRepoImpl();
        movieService = new MovieService(movieRepo);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getMoviesAbovePriceSuccess() {

//        List<Movie> movies = this.movieService.getMoviesAbovePrice(5);

        List<Movie> mockMovies = new ArrayList<Movie>();
        mockMovies.add(new Movie(1, "Iron Man", 0, 5, true, 0, 0));
        mockMovies.add(new Movie(2, "Thor", 0, 4, true, 0, 0));
        mockMovies.add(new Movie(3, "Ant-Man", 0, 5, true, 0, 0));
        mockMovies.add(new Movie(4, "The Avengers", 0, 6, true, 0, 0));

        Mockito.when(movieRepo.getAllMovies()).thenReturn(mockMovies);

        List<Movie> actual = this.movieService.getMoviesAbovePrice(5);

        List<Movie> expected = new ArrayList<Movie>();
        expected.add(new Movie(1, "Iron Man", 0, 5, true, 0, 0));
        expected.add(new Movie(3, "Ant-Man", 0, 5, true, 0, 0));
        expected.add(new Movie(4, "The Avengers", 0, 6, true, 0, 0));

        Assertions.assertEquals(actual, expected);

    }

}