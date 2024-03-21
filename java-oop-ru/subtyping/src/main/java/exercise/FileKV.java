package exercise;

// BEGIN
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileKV implements KeyValueStorage {

    private Map<String, String> storage = new HashMap<>();
    private String filePath;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        try {
            Utils.writeFile(filePath, Utils.serialize(initialData));
            this.storage.putAll(initialData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void set(String key, String value) {
        storage.put(key, value);
        saveToFile();
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
        saveToFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }

    private void saveToFile() {
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    private void loadFromFile() {
        String fileContent = Files.readString(Paths.get(filePath));
        storage = Utils.unserialize(fileContent);
    }
}
// END
