package exercise;

import java.util.StringJoiner;
import java.util.Map;

// BEGIN
public abstract class Tag {
    protected String name;
    protected Map<String, String> attributes;

    protected Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    protected String renderAttributes() {
        if (attributes.isEmpty()) {
            return "";
        }
        StringJoiner sj = new StringJoiner(" ", " ", "");
        attributes.forEach((key, value) -> sj.add(String.format("%s=\"%s\"", key, value)));
        return sj.toString();
    }
}
// END
