package com.basov.springbootjpa.activemq;

import com.basov.springbootjpa.entity.Author;
import com.basov.springbootjpa.exception_handling.NoSuchException;
import com.basov.springbootjpa.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/active")
@Api(tags = "Контроллер для взаимодействия с брокером сообщений ActiveMQ")
public class ActiveMQControllerRest {

    Logger logger = LoggerFactory.getLogger(ActiveMQControllerRest.class);

    private final JmsTemplate jmsTemplate;
    private final AuthorService authorService;

    public ActiveMQControllerRest(JmsTemplate jmsTemplate, AuthorService authorService) {
        this.jmsTemplate = jmsTemplate;
        this.authorService = authorService;
    }

    //    For text messages
    @GetMapping("/send-message/{message}")
    @ApiOperation("Отправить текстовое сообщение")
    public String sendMessage(@PathVariable("message") String message) {
        jmsTemplate.convertAndSend("messageQueue", message);
        return "Done!";
    }

//    For objects
    @GetMapping("/send-object/{id}")
    @ApiOperation("Отправить JSON объект")
    public Author sendMessage(@PathVariable("id") int id) {
        Author author = authorService.getAuthorById(id);
        logger.info("***INFO*** Author id: {}", id);
        if (author == null) {
            throw new NoSuchException("There's no author this ID = " + id);
        }
        jmsTemplate.convertAndSend("objectQueue", author);
        return author;
    }
}