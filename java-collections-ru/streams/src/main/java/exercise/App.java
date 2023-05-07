package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        long count1 = emails.stream()
                .filter(mail -> mail.contains("@gmail.com"))
                .collect(Collectors.counting());

        long count2 = emails.stream()
                .filter(mail -> mail.contains("@yandex.ru"))
                .collect(Collectors.counting());

        long count3 = emails.stream()
                .filter(mail -> mail.contains("@hotmail.com"))
                .collect(Collectors.counting());

        var result = count1 + count2 + count3;

        return result;
    }
}
// END
