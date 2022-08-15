package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {

    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();
        Double rating = movies.stream()
                .map(movie -> movie.getRating())
                .reduce(0.0,(rating1,rating2)->rating1 > rating2 ? rating1:rating2);
        return rating;
    }










//forma adryan
//    public static Double execute() {
//        List<Movie> movies = DataUtil.getMovies();
//        return movies.stream().map(movie -> movie.getRating())
//                .reduce(0.0, (rating1, rating2) -> rating1 > rating2 ? rating1 : rating2);
//    }
//forma gianni
//List<Movie> movies = DataUtil.getMovies();
//
//    Double res = movies.stream()
//            .map(movie -> movie.getRating())
//            .reduce(0.0, Double::max);
//
//        return res;
}
