package phoenix.api.model;

import phoenix.api.game.GameStatus;
import phoenix.api.wallet.Node;

public interface PlayerGame {

    User getUser();

    Node getNode();

    /**
     * @return unique id from third-party service database
     */
    String getServiceId();

    /**
     * @return id of this PlayerGame model in website database
     */
    String getId();

    String getGame();

    String getProvider();

    GameStatus getGameStatus();

    Transaction getTransaction();

    Transaction getEndTransaction();

    float getBet();

    float getPayout();

}
