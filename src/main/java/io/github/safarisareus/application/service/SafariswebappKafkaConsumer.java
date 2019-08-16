package io.github.safarisareus.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SafariswebappKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(SafariswebappKafkaConsumer.class);
    private static final String TOPIC = "topic_safariswebapp";

    @KafkaListener(topics = "topic_safariswebapp", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
