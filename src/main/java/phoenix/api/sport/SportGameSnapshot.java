package phoenix.api.sport;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public interface SportGameSnapshot {

    String id();

    String market();

    JsonArray markets();

    default JsonObject toJson() {
        JsonObject object = new JsonObject();

        object.addProperty("id", id());
        object.add("markets", markets());

        return object;
    }

    static SportGameSnapshot fromArray(JsonObject array) {
        return new SportGameSnapshot() {
            @Override public String id() {
                return array.get("id").getAsString();
            }

            @Override public String market() {
                return array.get("market").getAsString();
            }

            @Override public JsonArray markets() {
                return array.getAsJsonArray("markets");
            }
        };
    }

    static SportGameSnapshot createSnapshot(SportGame game, String market) {
        return new SportGameSnapshot() {
            @Override public String id() {
                return game.serviceId();
            }

            @Override public String market() {
                return market;
            }

            @Override public JsonArray markets() {
                return game.toJson().getAsJsonArray("markets");
            }
        };
    }

}
