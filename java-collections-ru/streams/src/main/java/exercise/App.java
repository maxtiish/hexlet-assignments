package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        long count1 = emails.stream()
                .filter(mail -> emails.contains("gmail.com"))
                .count();

        long count2 = emails.stream()
                .filter(mail -> emails.contains("yandex.ru"))
                .count();

        long count3 = emails.stream()
                .filter(mail -> emails.contains("hotmail.com"))
                .count();
        var result = count1 + count2 + count3;

        return result;
    }
}
// END
