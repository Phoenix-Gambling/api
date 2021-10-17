package phoenix.api.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public interface User {

    String getId();

    String getUsername();

    String getImage();

    List<String> getRoles();

    default JsonObject toJson() {
        JsonObject object = new JsonObject();
        object.addProperty("id", getId());
        object.addProperty("name", getUsername());
        object.addProperty("image", getImage());

        JsonArray roles = new JsonArray();
        getRoles().forEach(roles::add);
        object.add("roles", roles);
        return object;
    }

}
