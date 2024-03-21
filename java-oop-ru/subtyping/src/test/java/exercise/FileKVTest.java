package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void testFileKVOperations() throws Exception {
        String testFilePath = "src/test/resources/testFileKV.json";
        KeyValueStorage storage = new FileKV(testFilePath, Map.of("initialKey", "initialValue"));

        storage.set("key", "value");
        assertEquals("value", storage.get("key", "default"));

        storage.unset("initialKey");
        assertNull(storage.get("initialKey", null));

        // Проверка сохранения в файл
        String fileContent = Files.readString(Paths.get(testFilePath));
        assertTrue(fileContent.contains("\"key\":\"value\""));
        assertFalse(fileContent.contains("\"initialKey\""));

        Files.deleteIfExists(Paths.get(testFilePath)); // Удалите тестовый файл после выполнения теста
    }
    // END
}
