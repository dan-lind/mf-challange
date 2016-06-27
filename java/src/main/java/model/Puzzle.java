package model;

import java.util.List;

/**
 * Created by danlin on 2016-06-26.
 */
public class Puzzle {

    private String puzzle;
    private String info;
    private String submission;
    private List<Quote> data;

    public List<Quote> getData() {
        return data;
    }

    public void setData(List<Quote> data) {
        this.data = data;
    }

    public String getSubmission() {
        return submission;
    }

    public void setSubmission(String submission) {
        this.submission = submission;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

}
