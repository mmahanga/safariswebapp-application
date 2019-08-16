package io.github.safarisareus.application.web.rest;

import io.github.safarisareus.application.service.SafariswebappKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/safariswebapp-kafka")
public class SafariswebappKafkaResource {

    private final Logger log = LoggerFactory.getLogger(SafariswebappKafkaResource.class);

    private SafariswebappKafkaProducer kafkaProducer;

    public SafariswebappKafkaResource(SafariswebappKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
