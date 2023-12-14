package org.spring.cloud.playground.kafka.consumer;

import org.junit.jupiter.api.Test;
import org.spring.cloud.playground.avro.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.verify;

@SpringBootTest
@ImportAutoConfiguration(classes = TestChannelBinderConfiguration.class)
@ActiveProfiles("local")
class MessageConsumerTest {

    private static final String MESSAGE_TOPIC = "messageConsumer-in-0";
    private static final String NAME = "Sudheep";
    private static final String MESSAGE = "Hola Amigo";
    @Autowired
    InputDestination inputDestination;
    @SpyBean
    MessageConsumer messageConsumer;

    @Test
    void accept() {
        // Given
        final Message message = new Message(NAME, MESSAGE);

        // When
        inputDestination.send(MessageBuilder.withPayload(message).build(), MESSAGE_TOPIC);

        // Then
        verify(messageConsumer).accept(message);
    }

}