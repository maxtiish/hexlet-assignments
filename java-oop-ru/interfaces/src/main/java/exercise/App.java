package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> list, int number) {
        List<String> result = list.stream()
                .sorted(Home::compareTo)
                .map(home -> home.toString())
                .limit(number)
                .collect(Collectors.toList());

        return result;
    }
}
// END
