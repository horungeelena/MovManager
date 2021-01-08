package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    MovieManager manager = new MovieManager();
    private Movie first = new Movie(1, "Bloodshot", "thriller",true);
    private Movie second = new Movie(2, "Onward", "cartoon", true);
    private Movie third = new Movie(3, "Hotel Belgrade", "comedy", true);
    private Movie fourth = new Movie(4, "The Gentlemen", "crime",true);
    private Movie fifth = new Movie(5, "The Invisible Man", "fantasy", true);
    private Movie sixth = new Movie(6, "Trolls World Tour", "cartoon",false);
    private Movie seventh = new Movie(7, "Number One","comedy",false);
    private Movie eighth = new Movie(8,"eighth","none",false);
    private Movie ninth = new Movie(9,"ninth","none",false);
    private Movie tenth = new Movie(10,"tenth","none",false);

    Movie[] expected = { tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

    @Test
    void giveOutTenMovies() {
        MovieManager manager = new MovieManager(10);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        Movie[] actual = manager.getAddLastMovie();
        assertArrayEquals(expected, actual);
    }

    @Test
    void giveOutActualNumberMovies() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        Movie movieAdd = new Movie( 5, "The Invisible Man", "fantasy", true);
        manager.addMovie(movieAdd);
        Movie[] actual = manager.getAddLastMovie();
        Movie[] expected = {new Movie(5, "The Invisible Man", "fantasy", true), fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }
}