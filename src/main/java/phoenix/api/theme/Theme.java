package phoenix.api.theme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theme {

    private final String source, name, description;
    private final List<String> npmModules;

    Theme(String source, String name, String description, List<String> npmModules) {
        this.source = source;
        this.name = name;
        this.description = description;
        this.npmModules = npmModules;
    }

    public List<String> getNpmModules() {
        return npmModules;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSource() {
        return source;
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    public static class Builder {

        private final String name;
        private String description = "", source = "/";
        private final List<String> npmModules = new ArrayList<>();

        Builder(String name) {
            this.name = name;
        }

        public Builder source(String directory) {
            this.source = directory;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder installModule(String... names) {
            Collections.addAll(npmModules, names);
            return this;
        }

        public Theme build() {
            return new Theme(this.source, this.name, this.description, this.npmModules);
        }

    }

}
