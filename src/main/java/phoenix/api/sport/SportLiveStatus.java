package phoenix.api.sport;

import com.google.gson.JsonObject;

public interface SportLiveStatus {

    String stage();

    String score();

    String setScores();

    long createdAt();

    default JsonObject toJson() {
        JsonObject object = new JsonObject();
        object.addProperty("stage", stage());
        object.addProperty("score", score());
        object.addProperty("setScores", setScores());
        object.addProperty("createdAt", createdAt());
        return object;
    }

}
