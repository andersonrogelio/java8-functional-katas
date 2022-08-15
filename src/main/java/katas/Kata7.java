package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.sun.java.accessibility.util.EventID;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> moviesmallest = movieLists.stream()
                .map(videolist->videolist.getVideos())
                .flatMap(video->video.stream())
                .map(provideo-> ImmutableMap.of(
                        "id", provideo.getId(),
                        "title", provideo.getTitle(),
                        "boxart", provideo.getBoxarts().stream()
                                .reduce((boxArt, boxArt2) -> boxArt.getHeight() * boxArt.getWidth() < boxArt2.getHeight() * boxArt2.getWidth() ? boxArt : boxArt2)
                                .get()
                                .getUrl()))
                .collect(Collectors.toUnmodifiableList());
        return moviesmallest;
    }


}
