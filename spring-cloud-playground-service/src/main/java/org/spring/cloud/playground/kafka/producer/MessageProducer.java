package org.spring.cloud.playground.kafka.producer;

import lombok.extern.log4j.Log4j2;
import org.spring.cloud.playground.avro.Message;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
@Log4j2
public class MessageProducer {

    private static final String MESSAGE_TOPIC = "message-topic";
    private final StreamBridge streamBridge;

    public MessageProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void produceMessage(Message message) {
        streamBridge.send(MESSAGE_TOPIC, MessageBuilder.withPayload(message).build());
    }

}
