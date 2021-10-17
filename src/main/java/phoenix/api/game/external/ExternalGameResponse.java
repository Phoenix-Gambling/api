package phoenix.api.game.external;

public class ExternalGameResponse {

    private final String url;

    private ExternalGameResponse(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }

    public static ExternalGameResponse url(String url) {
        return new ExternalGameResponse(url);
    }

}
