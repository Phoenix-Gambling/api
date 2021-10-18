package phoenix.api.sport;

import java.util.List;

public interface SportLineProvider {

    String id();

    String name();

    String description();

    List<SportCategory> getCategories();

    List<SportRegion> getRegions(String category);

    List<SportGame> getLeagueGames(String leagueId);

    SportGame findGame(String id);

    SportMarketHandler findMarket(String market, String runner);

    default SportCategory findCategory(String id) {
        for(SportCategory category: getCategories())
            if(category.id().equals(id)) return category;

        return null;
    }

}
