package phoenix.api.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

    public static <T> ResponseEntity<T> ok(T object) {
        return ResponseEntity.ok(object);
    }

    public static ResponseEntity<String> ok() {
        return ok("");
    }

    public static ResponseEntity<String> invalid(String message, int code) {
        JsonObject object = new JsonObject(), objectBody = new JsonObject();
        objectBody.addProperty("message", message);
        objectBody.addProperty("code", code);
        object.add("error", objectBody);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(object.toString());
    }

    public static ResponseEntity<String> unauthorized() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }

    public static ResponseEntity<String> invalid(String message) {
        return invalid(message, -1);
    }

    public static JsonObject parse(String json) {
        return JsonParser.parseString(json).getAsJsonObject();
    }

}
