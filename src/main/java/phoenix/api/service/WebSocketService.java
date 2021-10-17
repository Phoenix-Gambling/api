package phoenix.api.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;

public interface WebSocketService {

    SimpMessagingTemplate getSimpMessagingTemplate();

}
