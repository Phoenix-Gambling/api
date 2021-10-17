package phoenix.api.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class JSON {

    private final JsonObject result = new JsonObject();

    public JSON primitive(String key, String value) {
        result.addProperty(key, value);
        return this;
    }

    public JSON primitive(String key, Number value) {
        result.addProperty(key, value);
        return this;
    }

    public JSON primitive(String key, boolean value) {
        result.addProperty(key, value);
        return this;
    }

    public JSON array(String key, String... values) {
        JsonArray array = new JsonArray();
        for(String value: values) array.add(value);
        result.add(key, array);
        return this;
    }

    public JSON array(String key, List<String> values) {
        JsonArray array = new JsonArray();
        for(String value: values) array.add(value);
        result.add(key, array);
        return this;
    }

    public JSON array(String key, Number... values) {
        JsonArray array = new JsonArray();
        for(Number value: values) array.add(value);
        result.add(key, array);
        return this;
    }

    public JSON array(String key, int[] values) {
        JsonArray array = new JsonArray();
        for(int value: values) array.add(value);
        result.add(key, array);
        return this;
    }

    public JSON array(String key, boolean... values) {
        JsonArray array = new JsonArray();
        for(boolean value: values) array.add(value);
        result.add(key, array);
        return this;
    }

    public JsonObject get() {
        return this.result;
    }

}
