package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Movie;

@Data
public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int defaultMovieLength = 10;

    public MovieManager() {
    }

    public MovieManager(int customMovieLength) {
        if (customMovieLength > 0)
        this.defaultMovieLength = customMovieLength;
    }

    public void addMovie(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new  Movie[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        System.arraycopy(movies,0, tmp, 0, movies.length);
        int lastMovie = tmp.length - 1;
        tmp[lastMovie] = movie;
        movies = tmp;
    }

    public Movie[] getAddLastMovie() {
        Movie[] custom = new Movie[defaultMovieLength];
        for (int i = 0; i < custom.length; i++) {
            int result = movies.length - i - 1;
            custom[i] = movies[result];
        }
        return custom;
    }
}
