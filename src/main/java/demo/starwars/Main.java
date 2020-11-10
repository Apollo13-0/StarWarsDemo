package demo.starwars;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.starwars.dto.*;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;

import java.io.IOException;

public class Main {
    private static final ObjectMapper parser = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        Content response = Request.Get("https://swapi.dev/api/people/").execute().returnContent();
//        ("https://swapi.dev/api/people/").execute().returnContent();
        ApiResponse<People> parsedResponse = parser.readValue(response.asString(), new TypeReference<ApiResponse<People>>() {});
        for (People person : parsedResponse.getResults()) {
            System.out.printf("%s has a height of %s\n",  person.getName(), person.getHeight());
        }
    }
}