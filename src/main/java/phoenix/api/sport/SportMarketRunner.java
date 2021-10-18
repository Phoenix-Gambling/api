package phoenix.api.sport;

import com.google.gson.JsonObject;

public interface SportMarketRunner {

    String marketName();

    String name();

    boolean isOpen();

    float price();

    SportTranslation translation();

    default JsonObject toJson() {
        JsonObject object = new JsonObject();

        object.addProperty("name", name());
        object.addProperty("open", isOpen());
        object.addProperty("price", price());
        object.addProperty("marketName", marketName());
        object.add("translation", translation().toJson());

        return object;
    }

}
