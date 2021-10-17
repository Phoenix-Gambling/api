package phoenix.api.game.provider;

import phoenix.api.game.Game;
import phoenix.api.utils.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Provider {

    protected final List<Game> games = new ArrayList<>();

    public abstract String id();

    public abstract String name();

    public abstract String image();

    public JSON callback(String body) {
        return new JSON();
    }

    public List<Game> getGames() {
        return games;
    }

}
