package phoenix.api.wallet;

import phoenix.api.utils.SvgIcon;

import java.util.Collections;
import java.util.List;

public interface Node {

    String id();

    String name();

    default float minBet() {
        return 0;
    }

    default float maxBet() {
        return -1;
    }

    default SvgIcon svgIcon() {
        return SvgIcon.viewBox(32, 32)
            .path("M17.333 24c0 0.736-0.597 1.333-1.333 1.333s-1.333-0.597-1.333-1.333 0.597-1.333 1.333-1.333 1.333 0.597 1.333 1.333z")
            .path("M16 32c-8.823 0-16-7.177-16-16s7.177-16 16-16 16 7.177 16 16-7.177 16-16 16zM16 2c-7.72 0-14 6.28-14 14s6.28 14 14 14 14-6.28 14-14-6.28-14-14-14z")
            .path("M16 19.667c-0.552 0-1-0.448-1-1v-1.347c0-1.269 0.805-2.407 2.003-2.829 1.593-0.561 2.664-2.259 2.664-3.491 0-2.023-1.644-3.667-3.667-3.667s-3.667 1.644-3.667 3.667c0 0.552-0.448 1-1 1s-1-0.448-1-1c0-3.124 2.541-5.667 5.667-5.667s5.667 2.543 5.667 5.667c0 2.224-1.756 4.585-3.999 5.377-0.4 0.14-0.668 0.52-0.668 0.944v1.345c0 0.552-0.448 1-1 1z");
    }

    default String walletId() {
        return id();
    }

    default String shortName() {
        return name();
    }

    default int zeros() {
        return 2;
    }

    default List<Parameter> getParameters() {
        return Collections.emptyList();
    }

    default void onParameterChange(String key, String value) {}

    class Parameter {

        private final String key;
        private final String defaultValue;
        private final String description;

        public Parameter(String key, String defaultValue, String description) {
            this.key = key;
            this.defaultValue = defaultValue;
            this.description = description;
        }

        public String getKey() {
            return key;
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        public String getDescription() {
            return description;
        }

        public static Parameter of(String key, String defaultValue) {
            return new Parameter(key, defaultValue, null);
        }

        public static Parameter of(String key, String defaultValue, String description) {
            return new Parameter(key, defaultValue, description);
        }

    }

}
