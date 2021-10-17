package phoenix.api.game.external;

import phoenix.api.game.Game;
import phoenix.api.utils.JSON;
import phoenix.api.wallet.Node;

public interface ExternalGame extends Game {

    ExternalGameResponse url(Node node);

}
