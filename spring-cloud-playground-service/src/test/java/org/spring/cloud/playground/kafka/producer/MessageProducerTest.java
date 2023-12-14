package org.spring.cloud.playground.kafka.producer;

import org.junit.jupiter.api.Test;
import org.spring.cloud.playground.avro.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ImportAutoConfiguration(classes = TestChannelBinderConfiguration.class)
class MessageProducerTest {

    private static final String NAME = "Sudheep";
    private static final String MESSAGE = "Hola Amigo";
    @SpyBean
    MessageProducer messageProducer;
    @Autowired
    OutputDestination outputDestination;

    @Test
    void produceMessage() {
        // Given
        final Message message = new Message(NAME, MESSAGE);

        // When
        messageProducer.produceMessage(message);
        final org.springframework.messaging.Message<?> actualMessage = outputDestination.receive(0);

        // Then
        assertThat(actualMessage).isNotNull();
        assertThat(actualMessage.getPayload()).isEqualTo(message);
    }

}