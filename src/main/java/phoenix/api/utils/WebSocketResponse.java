package phoenix.api.utils;

import com.google.gson.JsonObject;

import java.util.function.Consumer;

public class WebSocketResponse {

    public static String ok(JsonObject jsonObject) {
        return jsonObject.toString();
    }

    public static String ok(Consumer<JsonObject> consumer) {
        JsonObject object = new JsonObject();
        consumer.accept(object);
        return object.toString();
    }

    public static String ok() {
        return "{}";
    }

    public static String invalid(String message, int code) {
        JsonObject object = new JsonObject(), objectBody = new JsonObject();
        objectBody.addProperty("message", message);
        objectBody.addProperty("code", code);
        object.add("error", objectBody);

        return object.toString();
    }

    public static String invalid(String message) {
        return invalid(message, -1);
    }

}
