package phoenix.api.wallet.crypto;

import phoenix.api.wallet.Node;
import phoenix.api.wallet.WalletTransaction;

public interface Blockchain extends Node {

    /** @return CoinGecko API ticker name */
    String tickerName();

    void start(Runnable callback);

    void stop();

    default void install(Runnable callback) {
        callback.run();
    }

    void send(String to, float amount);

    float getBalance();

    default void processBlock(String blockId, WalletTransaction transaction) {}

    default void processTransaction(String tx, WalletTransaction transaction) {}

    String newWalletAddress(String accountName);

    int minConfirmations();

    default boolean isInstalled() {
        return true;
    }

    boolean isStarted();

    boolean isSynchronized();

    float getSyncProgress();

    @Override default int zeros() {
        return 8;
    }

    default void setupWallet() {}

    default String url() {
        return null;
    }

    @Override default float minBet() {
        return 0.00000001f;
    }

}
