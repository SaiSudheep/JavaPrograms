package org.spring.cloud.playground.controller;

import lombok.Generated;
import lombok.extern.log4j.Log4j2;
import org.spring.cloud.playground.avro.Message;
import org.spring.cloud.playground.datetimeprovider.DateTimeProvider;
import org.spring.cloud.playground.kafka.producer.MessageProducer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
@Generated
@Log4j2
public class ControllerImpl implements Controller {

    private final DateTimeProvider dateTimeProvider;
    private final MessageProducer messageProducer;

    public ControllerImpl(DateTimeProvider dateTimeProvider,
                          MessageProducer messageProducer) {
        this.dateTimeProvider = dateTimeProvider;
        this.messageProducer = messageProducer;
    }

    @Override
    public void printDateTime() {
        if (log.isInfoEnabled()) {
            log.info("DateTime is: {}", dateTimeProvider.getCurrentDateTime());
        }
    }

    @Override
    public void printDate() {
        if (log.isInfoEnabled()) {
            log.info("Date is: {}", dateTimeProvider.getCurrentDate());
        }
    }

    @Override
    public void printTime() {
        if (log.isInfoEnabled()) {
            log.info("Time is: {}", dateTimeProvider.getCurrentTime());
        }
    }

    @Override
    public void produceMessage(String name, String message) {
        messageProducer.produceMessage(new Message(name, message));
    }

}
