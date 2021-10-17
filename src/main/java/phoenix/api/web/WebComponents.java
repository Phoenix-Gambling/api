package phoenix.api.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebComponents {

    private final Map<WebComponentType, List<WebComponent>> components = new HashMap<>();

    public TargetBuilder type(WebComponentType type) {
        return new TargetBuilder(type);
    }

    public Map<WebComponentType, List<WebComponent>> getComponents() {
        return components;
    }

    public class TargetBuilder {

        private final WebComponentType target;

        private final List<WebComponent> list = new ArrayList<>();

        TargetBuilder(WebComponentType target) {
            this.target = target;
        }

        public ComponentBuilder builder(String component) {
            if(component.endsWith(".vue")) throw new IllegalArgumentException("Remove .vue extension in component name.");
            if(component.startsWith("/")) component = component.substring(1);

            return new ComponentBuilder(component, this);
        }

        void add(WebComponent component) {
            this.list.add(component);
        }

        public void inject() {
            components.put(this.target, this.list);
        }

        public class ComponentBuilder {

            private final String component;
            private String name, description = "";

            private final TargetBuilder parent;

            ComponentBuilder(String component, TargetBuilder parent) {
                this.component = component;
                this.name = component;
                this.parent = parent;
            }

            public ComponentBuilder name(String name) {
                this.name = name;
                return this;
            }

            public ComponentBuilder description(String description) {
                this.description = description;
                return this;
            }

            public TargetBuilder build() {
                parent.add(new WebComponent(this.component, this.name, this.description));
                return parent;
            }

        }

    }

}
