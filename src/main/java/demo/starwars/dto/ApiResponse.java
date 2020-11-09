package demo.starwars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {
    private int count;
    private List<T> results;

    public int getCount() {
        return count;
    }

    public List<T> getResults() {
        return results;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}