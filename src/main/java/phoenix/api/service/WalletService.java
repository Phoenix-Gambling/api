package phoenix.api.service;

import phoenix.api.model.Transaction;
import phoenix.api.model.User;
import phoenix.api.wallet.Node;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface WalletService {

    Wallet get(User user, Node node);

    User getByDepositAddress(String address);

    abstract class Wallet {

        protected final User user;
        protected final Node node;

        public Wallet(User user, Node node) {
            this.user = user;
            this.node = node;
        }

        public abstract String getDepositAddress();

        public abstract BigDecimal getAmount();

        public abstract Transaction process(Consumer<WalletTransactionBuilder> walletTransactionBuilder);

        public Node getNode() {
            return node;
        }

        public User getUser() {
            return user;
        }

    }

    class WalletTransactionBuilder {

        private float change = 0;
        private String message = "";

        public WalletTransactionBuilder change(float change) {
            this.change = change;
            return this;
        }

        public WalletTransactionBuilder add(float change) {
            return change(change);
        }

        public WalletTransactionBuilder subtract(float change) {
            return change(-change);
        }

        public WalletTransactionBuilder message(String message) {
            this.message = message;
            return this;
        }

        public float getChange() {
            return change;
        }

        public String getMessage() {
            return message;
        }

    }

}
