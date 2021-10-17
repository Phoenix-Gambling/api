package phoenix.api.game.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Providers {

    private final List<Provider> providers = new ArrayList<>();

    public Providers add(Provider... providers) {
        this.providers.addAll(Arrays.asList(providers));
        return this;
    }

    public Provider getProvider(String id) {
        return this.providers.stream().filter((e) -> e.id().equals(id)).findFirst().orElse(null);
    }

    public List<Provider> getProviders() {
        return providers;
    }

}
