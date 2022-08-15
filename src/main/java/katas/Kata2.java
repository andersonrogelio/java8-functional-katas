package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {
    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Integer> moviesRating = movies.stream()
                .filter(movie -> movie.getRating() == 5.0)
                .map(movie -> movie.getId())
                .collect(Collectors.toUnmodifiableList());
//        return ImmutableList.of(1, 2, 3);
        return moviesRating;
    }
}
