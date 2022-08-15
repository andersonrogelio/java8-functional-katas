package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> moviesMap = movieLists.stream()
                .map(movie -> movie.getVideos())
                .flatMap(list -> list.stream())
                .map(movie -> ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(),
                        "boxart", new BoxArt(150, 200,
                                movie.getBoxarts().stream().map(boxArt -> boxArt.getUrl())
                                        .filter(url -> url.contains("150")).collect(Collectors.toList()).get(0))))
                .collect(Collectors.toUnmodifiableList());
        return moviesMap;
    }
}
