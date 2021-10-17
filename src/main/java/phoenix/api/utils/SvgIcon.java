package phoenix.api.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import phoenix.api.annotation.Icon;

import java.util.ArrayList;
import java.util.List;

public class SvgIcon {

    private final int width, height;
    private final List<Path> paths = new ArrayList<>();

    private SvgIcon(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public SvgIcon path(String d, String fill) {
        this.paths.add(new Path(d, fill));
        return this;
    }

    public SvgIcon path(String d) {
        this.paths.add(new Path(d, "white"));
        return this;
    }

    public JsonObject toJsonObject() {
        JsonObject object = new JsonObject();
        JsonArray pathArray = new JsonArray();

        for(Path path: paths) pathArray.add(path.toJson());

        object.addProperty("width", width);
        object.addProperty("height", height);
        object.add("paths", pathArray);
        return object;
    }

    public static SvgIcon fromAnnotation(Icon icon) {
        SvgIcon svgIcon = viewBox(icon.width(), icon.height());
        for(phoenix.api.annotation.Path annotationPath: icon.path())
            svgIcon.path(annotationPath.d(), annotationPath.fill());
        return svgIcon;
    }

    public static SvgIcon viewBox(int width, int height) {
        return new SvgIcon(width, height);
    }

    public static class Path {

        private final String d, fill;

        Path(String d, String fill) {
            this.d = d;
            this.fill = fill;
        }

        public JsonObject toJson() {
            JsonObject object = new JsonObject();
            object.addProperty("d", d);
            object.addProperty("fill", fill);
            return object;
        }

    }

}
