package phoenix.api.theme;

import java.util.ArrayList;
import java.util.List;

public class Themes {

    private final List<Theme> themes = new ArrayList<>();

    public Themes add(Theme theme) {
        themes.add(theme);
        return this;
    }

    public List<Theme> getThemes() {
        return themes;
    }

}
