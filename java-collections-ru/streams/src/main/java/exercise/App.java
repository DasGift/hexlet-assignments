package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        List<String> freeDomains = Stream.of("gmail.com", "yandex.ru", "hotmail.com").collect(Collectors.toList());

        return emails.stream()
                .filter(email -> freeDomains.stream()
                        .anyMatch(domain -> email.endsWith(domain)))
                .count();
    }
}
// END
