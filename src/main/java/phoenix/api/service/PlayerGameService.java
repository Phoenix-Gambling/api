package phoenix.api.service;

import phoenix.api.game.Game;
import phoenix.api.game.GameStatus;
import phoenix.api.game.provider.Provider;
import phoenix.api.model.PlayerGame;
import phoenix.api.model.Transaction;
import phoenix.api.model.User;
import phoenix.api.wallet.Node;

public interface PlayerGameService {

    PlayerGame create(User user, Node node, Provider provider, Game game, String serviceId, GameStatus status, Transaction transaction);

    PlayerGame create(Node node, Provider provider, Game game, String serviceId, GameStatus status, Transaction transaction);

    PlayerGame findByServiceId(String serviceId);

    PlayerGameService setStatus(PlayerGame game, GameStatus status);

    PlayerGameService finish(PlayerGame game, Transaction endTransaction, float bet, float payout);

}
