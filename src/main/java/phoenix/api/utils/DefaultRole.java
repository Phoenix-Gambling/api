package phoenix.api.utils;

public enum DefaultRole {

    USER("user"),
    ADMIN("admin");

    private final String name;

    DefaultRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
