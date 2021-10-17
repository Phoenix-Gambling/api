package phoenix.api.model;

import java.math.BigDecimal;

public interface Transaction {

    String getId();

    User getUser();

    String getWalletId();

    BigDecimal getBefore();

    BigDecimal getAfter();

    BigDecimal getChange();

    String getMessage();

}
