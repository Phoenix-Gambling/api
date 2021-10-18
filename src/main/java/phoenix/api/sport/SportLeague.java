package phoenix.api.sport;

import com.google.gson.JsonObject;

public interface SportLeague {

    int id();

    String name();

    default JsonObject toJson() {
        JsonObject object = new JsonObject();

        object.addProperty("id", id());
        object.addProperty("name", name());
        return object;
    }

}
