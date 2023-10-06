package exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static exercise.App.enlargeArrayImage;

// BEGIN
class AppTest {
    @Test
    public static void main(String[] args) {
        // Тесты
        String[][] image = {{"#","#"},{"#","#"}};
        String[][] enlargedImage = enlargeArrayImage(image);

        System.out.println("Исходное изображение:");
        for (String[] row : image) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nУвеличенное изображение:");
        for (String[] row : enlargedImage) {
            System.out.println(Arrays.toString(row));
        }
    }
}
// END
