package phoenix.api.model;

import java.util.List;

public interface User {

    String getId();

    String getUsername();

    List<String> getRoles();

}
