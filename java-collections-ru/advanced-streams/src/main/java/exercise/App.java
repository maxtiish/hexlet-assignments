package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String data) {
        var dataToArray = data.split("\n");

        var environmnetsdata = Arrays.stream(dataToArray)
                .filter(str -> str.startsWith("environment="))
                .map(str -> str.replaceAll("environment=", ""))
                .map(str -> str.replaceAll("\"", ""))
                .collect(Collectors.joining(","));

        var array = environmnetsdata.split(",");
        return Arrays.stream(array)
                .filter(str -> str.startsWith("X_FORWARDED_"))
                .map(str -> str.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
/*
        var dataArray = data.split("environment=");
        var firstStep = Arrays.stream(dataArray)
                .filter(str -> str.startsWith("\""))
                .map(str -> str.replaceAll("\"", ""))
                .collect(Collectors.joining(","));

        var array = firstStep.split(",");

        var help = Arrays.stream(array)
                .filter(str -> str.contains("X_FORWARDED_"))
                .map(str -> str.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));

        return help;*/