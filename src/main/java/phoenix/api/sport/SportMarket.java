package phoenix.api.sport;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public interface SportMarket {

    String name();

    boolean isOpen();

    List<SportMarketRunner> getRunners();

    default JsonObject toJson() {
        JsonObject object = new JsonObject();
        JsonArray runners = new JsonArray();

        this.getRunners().forEach(runner -> runners.add(runner.toJson()));

        object.addProperty("name", name());
        object.addProperty("open", isOpen());
        object.add("runners", runners);

        return object;
    }

}
