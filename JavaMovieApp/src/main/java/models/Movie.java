package models;

import java.util.Objects;

public class Movie {

    private int id;
    private String title;
    private int genreId;
    private double price;
    private boolean available;
    private long returnDate;
    private int directorId;

    public Movie() {
        super();
    }

    public Movie(int id, String title, int genreId, double price, boolean available, long returnDate, int directorId) {
        super();
        this.id = id;
        this.title = title;
        this.genreId = genreId;
        this.price = price;
        this.available = available;
        this.returnDate = returnDate;
        this.directorId = directorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(long returnDate) {
        this.returnDate = returnDate;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return getId() == movie.getId() && getGenreId() == movie.getGenreId() && Double.compare(movie.getPrice(), getPrice()) == 0 && isAvailable() == movie.isAvailable() && getReturnDate() == movie.getReturnDate() && getDirectorId() == movie.getDirectorId() && getTitle().equals(movie.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getGenreId(), getPrice(), isAvailable(), getReturnDate(), getDirectorId());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title=" + title +
                ", genreId=" + genreId +
                ", price=" + price +
                ", available=" + available +
                ", returnDate=" + returnDate +
                ", directorId=" + directorId +
                '}';
    }
}
