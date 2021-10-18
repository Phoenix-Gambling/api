package phoenix.api.sport;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public interface SportRegion {

    String name();

    List<SportLeague> getLeagues();

    default JsonObject toJson() {
        JsonObject object = new JsonObject();
        JsonArray leagues = new JsonArray();

        this.getLeagues().forEach(league -> leagues.add(league.toJson()));
        object.addProperty("name", name());
        object.add("leagues", leagues);

        return object;
    }

}
