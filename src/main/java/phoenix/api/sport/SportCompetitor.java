package phoenix.api.sport;

import com.google.gson.JsonObject;

public interface SportCompetitor {

    String name();

    String logo();

    default JsonObject toJson() {
        JsonObject object = new JsonObject();
        object.addProperty("name", this.name());
        object.addProperty("logo", this.logo());
        return object;
    }

}
