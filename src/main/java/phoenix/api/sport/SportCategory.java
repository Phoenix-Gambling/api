package phoenix.api.sport;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import phoenix.api.utils.SvgIcon;

import java.util.List;

public interface SportCategory {

    String id();

    SvgIcon icon();

    List<SportGame> getGames();

    default JsonObject toJson() {
        JsonObject object = new JsonObject();
        JsonArray games = new JsonArray();

        this.getGames().forEach(game -> games.add(game.toJson()));

        object.addProperty("id", id());
        object.add("icon", icon().toJsonObject());
        object.add("games", games);
        return object;
    }

}
