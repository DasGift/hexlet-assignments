package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("<%s%s>", name, renderAttributes()));
        if (!body.isEmpty()) {
            builder.append(body);
        }
        for (Tag child : children) {
            builder.append(child.toString());
        }
        builder.append(String.format("</%s>", name));
        return builder.toString();
    }
}
// END
