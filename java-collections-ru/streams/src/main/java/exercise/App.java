package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        long count1 = emails.stream()
                .filter(mail -> emails.contains("gmail.com"))
                .collect(Collectors.counting());

        var result = count1;

        return result;
    }
}
// END
