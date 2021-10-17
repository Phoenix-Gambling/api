package phoenix.api.wallet;

public interface WalletTransaction {

    /**
     * Accepts transaction.
     *
     * @param confirmations Number of confirmations.
     *                      If it's zero or a number that is less than minimal confirmation amount set by CoinNode instance,
     *                      transaction will appear in user dashboard, but funds will be frozen
     *                      until another instance of Transaction will change transaction status.
     * @param node Node instance
     * @param address Deposit address
     * @param txId Transaction id
     * @param amount Normalized amount
     */
    void accept(Node node, int confirmations, String address, String txId, float amount);

}
