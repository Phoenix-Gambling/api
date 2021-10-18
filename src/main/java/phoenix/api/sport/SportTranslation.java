package phoenix.api.sport;

import com.google.gson.JsonObject;

public class SportTranslation {

    private String marketKey, runnerKey;
    private JsonObject marketData = new JsonObject(), runnerData = new JsonObject();

    public SportTranslation market(String key, JsonObject data) {
        this.marketKey = key;
        this.marketData = data;
        return this;
    }

    public SportTranslation market(String key) {
        this.marketKey = key;
        return this;
    }

    public SportTranslation runner(String key, JsonObject data) {
        this.runnerKey = key;
        this.runnerData = data;
        return this;
    }

    public SportTranslation runner(String key) {
        this.runnerKey = key;
        return this;
    }

    public SportTranslation same(String market, String runner) {
        this.marketKey = market;
        this.runnerKey = runner;
        return this;
    }

    public JsonObject toJson() {
        JsonObject object = new JsonObject(), market = new JsonObject(), runner = new JsonObject();

        market.addProperty("key", marketKey);
        market.add("data", marketData);

        runner.addProperty("key", runnerKey);
        runner.add("data", runnerData);

        object.add("market", market);
        object.add("runner", runner);
        return object;
    }

}
