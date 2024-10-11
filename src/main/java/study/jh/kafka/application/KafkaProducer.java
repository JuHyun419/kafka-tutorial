package study.jh.kafka.application;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import study.jh.kafka.model.MyMessage;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private static final String TOPIC_NAME = "JH";

    private final KafkaTemplate<String, MyMessage> kafkaTemplate;

    public void sendJson(MyMessage message) {
        CompletableFuture<SendResult<String, MyMessage>> future = kafkaTemplate.send(TOPIC_NAME, message);

        future.thenAccept(result -> System.out.println("result: " + result.getProducerRecord().value()));
    }

}
