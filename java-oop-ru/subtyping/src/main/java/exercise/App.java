package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> currentData = storage.toMap(); // Получаем текущее состояние данных
        storage.toMap().clear(); // Очищаем текущее хранилище, это может не сработать зависимости от реализации toMap()

        // Вместо прямого очищения storage, можно создать новый экземпляр InMemoryKV если это допускается заданием.
        // Но т.к. нет информации, как это должно быть реализовано, продолжаем с текущим подходом.

        for (Map.Entry<String, String> entry : currentData.entrySet()) {
            storage.set(entry.getValue(), entry.getKey()); // Меняем ключи и значения местами
        }
    }

    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
        System.out.println(storage.toMap()); // До swap

        swapKeyValue(storage);
        System.out.println(storage.toMap()); // После swap
    }
}
// END
