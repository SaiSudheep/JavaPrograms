package org.spring.cloud.playground.kafka.consumer;

import lombok.extern.log4j.Log4j2;
import org.spring.cloud.playground.avro.Message;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Profile("local")
@Log4j2
public class MessageConsumer implements Consumer<Message> {

    @Override
    public void accept(Message message) {
        log.info(message);
    }

}
