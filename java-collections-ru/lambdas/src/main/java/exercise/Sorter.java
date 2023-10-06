package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
import java.util.*;

public class Sorter {

    public static List<String> takeOldestMans(List<Map<String, String>> userList) {
        List<String> oldestMans = new ArrayList<>();

        // Фильтруем список пользователей, чтобы оставить только мужчин
        List<Map<String, String>> mansList = userList.stream()
                .filter(user -> user.get("gender").equalsIgnoreCase("male"))
                .collect(Collectors.toList());

        // Сортируем список мужчин по дате рождения
        mansList.sort(Comparator.comparing(user -> user.get("birthday")));

        // Создаем список имен мужчин в отсортированном порядке
        oldestMans = mansList.stream()
                .map(user -> user.get("name"))
                .collect(Collectors.toList());

        return oldestMans;
    }
}

// END
