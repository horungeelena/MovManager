package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Movie;

@Data
public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int MovieLength = 10;

    public MovieManager() {
    }

    public MovieManager(int MovieLength) {
        this.MovieLength = MovieLength;
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
        int resultLength = Math.min(MovieLength, movies.length);
        Movie[] result = new Movie[MovieLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
