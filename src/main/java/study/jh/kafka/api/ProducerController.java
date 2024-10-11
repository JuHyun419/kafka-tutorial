package study.jh.kafka.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.jh.kafka.application.KafkaProducer;
import study.jh.kafka.model.MyMessage;

@RestController
@RequestMapping("/api")
public class ProducerController {

    private final KafkaProducer service;

    public ProducerController(KafkaProducer service) {
        this.service = service;
    }

    @PostMapping("/publish")
    public String publish(@RequestBody MyMessage message) {
        service.sendJson(message);

        return "published a message: " + message.getName() + ", " + message.getMessage();
    }

}
