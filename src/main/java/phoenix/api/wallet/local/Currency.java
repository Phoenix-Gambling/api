package phoenix.api.wallet.local;

import phoenix.api.wallet.local.aggregator.Aggregator;
import phoenix.api.wallet.Node;

import java.util.List;

@Deprecated
public interface Currency extends Node {

    List<Class<? extends Aggregator>> aggregators();

    @Override default int zeros() {
        return 2;
    }

    @Override default float minBet() {
        return 0.01f;
    }

}
