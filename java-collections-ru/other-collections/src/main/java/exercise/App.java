package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, ?> dict1, Map<String, ?> dict2) {
        // Создаем результирующий словарь с сохранением порядка добавления элементов
        Map<String, String> diffDict = new LinkedHashMap<>();

        // Собираем все уникальные ключи из обоих словарей
        TreeSet<String> allKeys = new TreeSet<>(dict1.keySet());
        allKeys.addAll(dict2.keySet());

        // Проверяем каждый ключ
        for (String key : allKeys) {
            // Проверяем наличие ключа в обоих словарях
            boolean keyExistsInDict1 = dict1.containsKey(key);
            boolean keyExistsInDict2 = dict2.containsKey(key);

            if (!keyExistsInDict1 && keyExistsInDict2) {
                // Ключ отсутствует в первом словаре, но добавлен во второй
                diffDict.put(key, "added");
            } else if (keyExistsInDict1 && !keyExistsInDict2) {
                // Ключ был в первом словаре, но отсутствует во втором
                diffDict.put(key, "deleted");
            } else if (dict1.get(key).equals(dict2.get(key))) {
                // Значения ключа одинаковы
                diffDict.put(key, "unchanged");
            } else {
                // Значения ключа отличаются
                diffDict.put(key, "changed");
            }
        }

        return diffDict;
    }

    public static void main(String[] args) {
        Map<String, Object> dict1 = Map.of(
                "key1", "value1",
                "key2", "value2",
                "key3", "value3"
        );

        Map<String, Object> dict2 = Map.of(
                "key1", "value1",
                "key3", "new value",
                "key4", "value4"
        );

        Map<String, String> diffDict = genDiff(dict1, dict2);

        for (Map.Entry<String, String> entry : diffDict.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
//END
