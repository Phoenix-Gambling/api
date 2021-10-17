package phoenix.api.utils;

import com.google.gson.JsonObject;
import phoenix.api.annotation.Icon;

public class SvgIcon {

    private final int width, height;
    private String src = "";
    private String color = "white";

    private SvgIcon(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public SvgIcon set(String src) {
        this.src = src;
        return this;
    }

    public SvgIcon path(String path) {
        this.src += path + " ";
        return this;
    }

    public SvgIcon color(String color) {
        this.color = color;
        return this;
    }

    public JsonObject toJsonObject() {
        JsonObject object = new JsonObject();
        object.addProperty("width", width);
        object.addProperty("height", height);
        object.addProperty("src", src);
        object.addProperty("color", color);
        return object;
    }

    public static SvgIcon fromAnnotation(Icon icon) {
        SvgIcon svgIcon = viewBox(icon.width(), icon.height()).color(icon.color());
        for(String path: icon.path()) svgIcon.path(path);
        return svgIcon;
    }

    public static SvgIcon viewBox(int width, int height) {
        return new SvgIcon(width, height);
    }

}
