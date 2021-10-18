package phoenix.api.service.web;

public class WebComponent {

    private final String component;
    private final String name;
    private final String description;

    WebComponent(String component, String name, String description) {
        this.component = component;
        this.name = name;
        this.description = description;
    }

    public String getComponent() {
        return component;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
