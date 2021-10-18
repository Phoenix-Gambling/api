package phoenix.api.sport;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public interface SportGame {

    String id();

    String name();

    boolean isLive();

    boolean isOpen();

    List<SportCompetitor> competitors();

    List<SportMarket> markets();

    SportLeague league();

    SportLiveStatus liveStatus();

    String serviceId();

    default JsonObject toJson() {
        JsonObject object = new JsonObject();
        JsonArray competitors = new JsonArray(), markets = new JsonArray();

        this.competitors().forEach(competitor -> competitors.add(competitor.toJson()));
        this.markets().forEach(market -> markets.add(market.toJson()));

        object.addProperty("id", id());
        object.addProperty("live", isLive());
        object.addProperty("data", serviceId());
        object.addProperty("name", name());
        object.addProperty("open", isOpen());
        object.add("competitors", competitors);
        object.add("markets", markets);
        object.add("liveStatus", liveStatus().toJson());

        SportLeague league = league();
        object.add("league", league == null ? null : league.toJson());
        return object;
    }

}
