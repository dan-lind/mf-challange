package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by danlin on 2016-06-26.
 */
public class Puzzle {

    @JsonCreator
    public Puzzle(@JsonProperty("puzzle") String puzzle,
                  @JsonProperty("info") String info,
                  @JsonProperty("submission") String submission,
                  @JsonProperty("data") List<Quote> data) {
        this.puzzle = puzzle;
        this.info = info;
        this.submission = submission;
        this.data = data;
    }

    private final String puzzle;
    private final String info;
    private final String submission;
    private final List<Quote> data;

    public List<Quote> getData() {
        return data;
    }

    public String getSubmission() {
        return submission;
    }

    public String getInfo() {
        return info;
    }

    public String getPuzzle() {
        return puzzle;
    }

}
