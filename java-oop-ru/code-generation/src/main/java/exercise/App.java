package exercise;

import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class App {

    public static void save(Path path, Car car) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonRepresentation = mapper.writeValueAsString(car);
        Files.writeString(path, jsonRepresentation);
    }

    public static Car extract(Path path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonRepresentation = Files.readString(path);
        return mapper.readValue(jsonRepresentation, Car.class);
    }
}
// END
