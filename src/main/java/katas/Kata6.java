package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    //Volver a pensarlo a ver si lo logro hacer con un map
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        String url = movies.stream()
                .flatMap(movie -> movie.getBoxarts().stream())
                .reduce((boxArt, boxArt2) -> boxArt.getHeight() * boxArt.getWidth() > boxArt2.getHeight() * boxArt2.getWidth() ? boxArt : boxArt2)
                .get()
                .getUrl();
        return url;
    }
}
