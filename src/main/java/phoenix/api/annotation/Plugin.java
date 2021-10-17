package phoenix.api.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface Plugin {

    String id();

    String name();

    String description() default "";

    int[] version() default { 1, 0, 0 };

    String author() default "";

    Icon icon() default @Icon(width = 32, height = 32, path = { "M17.333 24c0 0.736-0.597 1.333-1.333 1.333s-1.333-0.597-1.333-1.333 0.597-1.333 1.333-1.333 1.333 0.597 1.333 1.333z",
        "M16 32c-8.823 0-16-7.177-16-16s7.177-16 16-16 16 7.177 16 16-7.177 16-16 16zM16 2c-7.72 0-14 6.28-14 14s6.28 14 14 14 14-6.28 14-14-6.28-14-14-14z",
        "M16 19.667c-0.552 0-1-0.448-1-1v-1.347c0-1.269 0.805-2.407 2.003-2.829 1.593-0.561 2.664-2.259 2.664-3.491 0-2.023-1.644-3.667-3.667-3.667s-3.667 1.644-3.667 3.667c0 0.552-0.448 1-1 1s-1-0.448-1-1c0-3.124 2.541-5.667 5.667-5.667s5.667 2.543 5.667 5.667c0 2.224-1.756 4.585-3.999 5.377-0.4 0.14-0.668 0.52-0.668 0.944v1.345c0 0.552-0.448 1-1 1z" });

    class Container {

        private final Plugin annotation;
        private final Object instance;

        public Container(Plugin annotation, Object instance) {
            this.instance = instance;
            this.annotation = annotation;

            Pattern p = Pattern.compile("[^A-Za-z0-9-_]");
            Matcher m = p.matcher(this.getData().id());

            boolean b = m.find();
            if (b) throw new IllegalArgumentException("Invalid plugin id: \"" + this.getData().id() + "\"! It can't contain any special characters.");
        }

        public Object getInstance() {
            return instance;
        }

        @SuppressWarnings("unchecked")
        public <T> T get() {
            return (T) this.instance;
        }

        public Plugin getData() {
            return this.annotation;
        }

        public String version() {
            return Arrays.stream(getData().version())
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("."));
        }

    }

}
