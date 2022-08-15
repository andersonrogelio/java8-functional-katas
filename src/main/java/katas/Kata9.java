package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.InterestingMoment;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> videos = movieLists.stream().map(movies -> movies.getVideos())
                .flatMap(movie -> movie.stream())
                .map(movie -> ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(), "time", movie.getInterestingMoments().stream()
                        .filter(InterestingMoment-> InterestingMoment.getType().equals("Middle"))
                        .findAny()
                        .get()
                        .getTime() , "url", movie.getBoxarts().stream().reduce((box1, box2) -> box1.getWidth() < box2.getWidth() ? box1:box2)
                        .get()
                        .getUrl())).collect(Collectors.toUnmodifiableList());

        return videos;
    }
}
