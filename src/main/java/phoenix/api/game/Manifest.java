package phoenix.api.game;

import com.google.gson.JsonObject;

public interface Manifest {

    String id();

    String name();

    String image();

    String description();

    default boolean comingSoon() {
        return false;
    }

    default JsonObject toJsonObject() {
        JsonObject object = new JsonObject();

        object.addProperty("id", this.id());
        object.addProperty("name", this.name());
        object.addProperty("image", this.image());
        object.addProperty("description", this.description());
        object.addProperty("comingSoon", this.comingSoon());

        return object;
    }

}
