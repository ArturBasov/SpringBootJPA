package com.basov.springbootjpa.activemq;

import com.basov.springbootjpa.entity.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQConsumer {

    Logger logger = LoggerFactory.getLogger(ActiveMQConsumer.class);

//    For text messages
    @JmsListener(destination = "messageQueue")
    public void processMessage(String message){
        logger.info("Received: {}", message);
    }

//    For objects
    @JmsListener(destination = "objectQueue")
    public void processMessage(Author author){
        logger.info("Received: {}", author);
    }
}
