package phoenix.api.service;

import phoenix.api.wallet.Node;
import java.util.List;

public interface NodeService {

    NodeService add(Node... nodes);

    Node get(String id);

    String getParameter(Node node, String key);

    List<Node> getNodes();

}
