package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String result = om.writeValueAsString(this);
        return result;
    }

    public static Car unserialize(String jsonString) throws IOException {
        ObjectMapper om = new ObjectMapper();
        Car result = om.readValue(jsonString, Car.class);
        return result;
    }
    // END
}
