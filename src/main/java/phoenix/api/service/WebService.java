package phoenix.api.service;

import java.util.ArrayList;
import java.util.List;

public class WebService {

    private final List<Inject> injections = new ArrayList<>();

    public WebService inject(Inject... injects) {
        this.injections.addAll(List.of(injects));
        return this;
    }

    public static class Inject {

        private final String html;
        private final Block block;

        private String targetUserGroup = "all";
        private String[] targetUserRoles = null;

        Inject(String html, Block block) {
            this.html = html;
            this.block = block;
        }

        public String getTargetUserGroup() {
            return targetUserGroup;
        }

        public String[] getTargetUserRoles() {
            return targetUserRoles;
        }

        public Inject forAll() {
            this.targetUserGroup = "all";
            return this;
        }

        public Inject forAllUsers() {
            this.targetUserGroup = "allUsers";
            return this;
        }

        public Inject forRoles(String... roles) {
            this.targetUserGroup = "roles";
            this.targetUserRoles = roles;
            return this;
        }

        public String getHtml() {
            return html;
        }

        public Block getBlock() {
            return block;
        }

        public static Inject cssFrom(String url) {
            return new Inject(String.format("""
                    <link rel="stylesheet" href="%s">""", url), Block.HEAD);
        }

        public static Inject css(String css) {
            return new Inject(String.format("""
                    <style>%s</style>""", css), Block.HEAD);
        }

        public static Inject jsFrom(String url) {
            return new Inject(String.format("""
                    <script type="text/javascript" src="%s"></script>""", url), Block.DOCUMENT);
        }

        public static Inject js(String javascript) {
            return new Inject(String.format("""
                    <script type="text/javascript">%s</script>""", javascript), Block.DOCUMENT);
        }

        public static Inject custom(String html) {
            return new Inject(html, Block.BODY);
        }

        public static Inject custom(String html, Block block) {
            return new Inject(html, block);
        }

        public enum Block {
            HEAD,
            BODY,
            DOCUMENT
        }

    }

    public List<Inject> getInjects() {
        return injections;
    }

}
