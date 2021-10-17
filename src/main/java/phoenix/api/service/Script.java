package phoenix.api.service;

import java.util.ArrayList;
import java.util.List;

public class Script {

    private final List<Injection> injections = new ArrayList<>();

    public Script inject(Injection... injection) {
        this.injections.addAll(List.of(injection));
        return this;
    }

    public static class Injection {

        private final String html;
        private final InjectBlock block;

        private String targetUserGroup = "all";
        private String[] targetUserRoles = null;

        Injection(String html, InjectBlock block) {
            this.html = html;
            this.block = block;
        }

        public String getTargetUserGroup() {
            return targetUserGroup;
        }

        public String[] getTargetUserRoles() {
            return targetUserRoles;
        }

        public Injection forAll() {
            this.targetUserGroup = "all";
            return this;
        }

        public Injection forAllUsers() {
            this.targetUserGroup = "allUsers";
            return this;
        }

        public Injection forRoles(String... roles) {
            this.targetUserGroup = "roles";
            this.targetUserRoles = roles;
            return this;
        }

        public String getHtml() {
            return html;
        }

        public InjectBlock getBlock() {
            return block;
        }

        public static Injection cssFrom(String url) {
            return new Injection(String.format("""
                    <link rel="stylesheet" href="%s">""", url), InjectBlock.HEAD);
        }

        public static Injection css(String css) {
            return new Injection(String.format("""
                    <style>%s</style>""", css), InjectBlock.HEAD);
        }

        public static Injection jsFrom(String url) {
            return new Injection(String.format("""
                    <script type="text/javascript" src="%s"></script>""", url), InjectBlock.DOCUMENT);
        }

        public static Injection js(String javascript) {
            return new Injection(String.format("""
                    <script type="text/javascript">%s</script>""", javascript), InjectBlock.DOCUMENT);
        }

        public static Injection custom(String html) {
            return new Injection(html, InjectBlock.BODY);
        }

        public static Injection custom(String html, InjectBlock block) {
            return new Injection(html, block);
        }

        public enum InjectBlock {
            HEAD,
            BODY,
            DOCUMENT
        }

    }

    public List<Injection> getInjections() {
        return injections;
    }

}
