package com.kiyoshi87.kaiki.Repository;

import com.kiyoshi87.kaiki.Entity.Message;
import com.kiyoshi87.kaiki.Entity.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;


import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @BeforeEach
    void setUp() {
        messageRepository.deleteAll();
    }

    @Test
    @DisplayName("Validate whether message is getting saved in the db and we can retrieve it")
    void testSaveMessage() {

        Question question = Question.builder().question("What is your name?").build();

        Message message = Message.builder()
                .question(question)
                .message("My name is John.")
                .IP("127.0.0.1")
                .timeStamp(System.currentTimeMillis())
                .build();

        Message savedMessage = messageRepository.save(message);

        Optional<Message> retrievedMessage = messageRepository.findById(savedMessage.getId());
        assertThat(retrievedMessage).isPresent();
        assertThat(retrievedMessage.get().getQuestion()).isEqualTo(question);
        assertThat(retrievedMessage.get().getMessage()).isEqualTo("My name is John.");
        assertThat(retrievedMessage.get().getIP()).isEqualTo("127.0.0.1");
    }


    @Test
    @DisplayName("Validate whether the response from a non-existent question returns empty list")
    void testGetMessagesByNonExistentQuestion() {
        List<Message> messages = messageRepository.findByQuestionQuestion("Non-existent question");
        assertThat(messages).isEmpty();
    }


    @Test
    @DisplayName("Validate whether we can retrieve test messages by question")
    void testGetMessagesByQuestion() {
        Question question = Question.builder()
                .question("What is your name?").build();
        Message message1 = Message.builder()
                .question(question)
                .message("My name is John.")
                .IP("127.0.0.1")
                .timeStamp(System.currentTimeMillis())
                .build();
        Message message2 = Message.builder()
                .question(question)
                .message("I am Doe.")
                .IP("127.0.0.2")
                .timeStamp(System.currentTimeMillis())
                .build();
        messageRepository.save(message1);
        messageRepository.save(message2);

        List<Message> messages = messageRepository.findByQuestionQuestion("What is your name?");

        assertEquals(2, messages.size());
        assertThat(messages).extracting("message").contains("My name is John.", "I am Doe.");
    }

}
