package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    private String name;
    private Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String attributesToString() {
        String result = attributes.keySet().stream()
                .map(at -> at + "=\"" + attributes.get(at) + "\"")
                .collect(Collectors.joining(" "));
        return result.trim();
    }

    public abstract String toString();
}
// END
