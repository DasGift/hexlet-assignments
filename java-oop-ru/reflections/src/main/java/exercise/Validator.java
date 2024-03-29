package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static List<String> validate(Object obj) {
        List<String> notValidFields = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true); // Позволяет обращаться к приватным полям
                    if (field.get(obj) == null) { // Проверка значения поля на null
                        notValidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace(); // В реальных приложениях лучше использовать логирование
                }
            }
        }

        return notValidFields;
    }
}
// END
