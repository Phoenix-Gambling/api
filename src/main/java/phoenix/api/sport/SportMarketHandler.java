package phoenix.api.sport;

public interface SportMarketHandler {

    boolean isHandling(String market, String runner);

    SportMarketResult result(String runner, SportGameSnapshot snapshot);

    boolean isGameFinished(String gameId);

    default SportTranslation translate(String market, String runner) {
        return new SportTranslation().same(market, runner);
    }

}
