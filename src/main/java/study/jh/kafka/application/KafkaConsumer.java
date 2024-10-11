package study.jh.kafka.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import study.jh.kafka.model.MyMessage;

@Slf4j
@Component
public class KafkaConsumer {

    private static final String TOPIC_NAME = "JH";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = TOPIC_NAME)
    public void listenMessage(String jsonMessage) {
        try {
            MyMessage message = objectMapper.readValue(jsonMessage, MyMessage.class);
            log.info(">>> Json -> Object: {}", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
