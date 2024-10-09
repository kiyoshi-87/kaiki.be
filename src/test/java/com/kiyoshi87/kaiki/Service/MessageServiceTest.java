package com.kiyoshi87.kaiki.Service;

import com.kiyoshi87.kaiki.Entity.Message;
import com.kiyoshi87.kaiki.Entity.Question;
import com.kiyoshi87.kaiki.Repository.MessageRepository;


import com.kiyoshi87.kaiki.Repository.QuestionRepository;
import com.kiyoshi87.kaiki.dto.QuestionResponse;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @Mock
    QuestionRepository questionRepository;

    @InjectMocks
    private MessageService messageService;

    @Test
    public void saveMessageTest() {
        //Arrange
//        Question question = Question.builder()
//                .id(new ObjectId("1"))
//                .question("What is your name?")
//                .build();
//        Message message = Message.builder()
//                .id(new ObjectId("123"))
//                .question(question)
//                .IP("0.0.0.0")
//                .message("My name's Josh Peck.")
//                .build();
//
//        when(messageRepository.save(Mockito.any(Message.class))).thenReturn(message);
//        when(questionRepository.findById(question.getId())).thenReturn(Optional.of(question));
//
//        // Act
//        Message savedMessage = messageService.saveMessage(question.getId().toString(), message.getMessage(), message.getIP());
//
//        // Assert
//        Assertions.assertNotNull(savedMessage);
//        assertEquals(message.getIP(), savedMessage.getIP());
//        assertEquals(message.getQuestion().getQuestion(), savedMessage.getQuestion().getQuestion());
//    }
//
//    @Test
//    public void getMessageByQuestionTest() {
//        //Arrange
//        Question question = Question.builder()
//                .id(new ObjectId("1"))
//                .question("What is you name?")
//                .build();
//
//        Message message1 = Message.builder()
//                .id(new ObjectId("123"))
//                .question(question)
//                .message("I am John Doe.")
//                .IP("0.0.0.0")
//                .timeStamp(System.currentTimeMillis())
//                .build();
//
//        Message message2 = Message.builder()
//                .id(new ObjectId("124"))
//                .question(question)
//                .message("I am Geralt of Rivia!")
//                .IP("0.0.0.1")
//                .timeStamp(System.currentTimeMillis())
//                .build();
//
//        when(questionRepository.findById(question.getId())).thenReturn(Optional.of(question));
//        when(messageRepository.findByQuestionQuestion(question.getQuestion())).thenReturn(Arrays.asList(message1, message2));
//
//        //Act
//        List<Message> recievedMessages = messageService.getMessageByQuestion(question.getId().toString());
//
//        //Assert
//        Assertions.assertNotNull(recievedMessages);
//        assertEquals(2, recievedMessages.size());
//        assertEquals(message2.getMessage(), recievedMessages.get(1).getMessage());
//    }
//
//    @Test
//    public void createQuestionTest() {
//
//        //Arrange
//        Question question = Question.builder()
//                .id(new ObjectId("1"))
//                .question("What is your name?")
//                .build();
//
//        when(questionRepository.save(Mockito.any(Question.class))).thenReturn(question);
//
//        //Act
//
//        Question savedQuestion = messageService.createQuestion(question);
//
//        //Assert
//
//        Assertions.assertNotNull(savedQuestion);
//        assertEquals(question.getId(), savedQuestion.getId());
//        assertEquals(question.getQuestion(), savedQuestion.getQuestion());
//    }
//
//    @Test
//    public void getAllQuestionsTest() {
//
//        //Arrange
//
//        Question question1 = Question.builder()
//                .id(new ObjectId("1"))
//                .question("What is your name?")
//                .build();
//
//        Question question2 = Question.builder()
//                .id(new ObjectId("2"))
//                .question("Is this yours?")
//                .build();
//
//        when(questionRepository.findAll()).thenReturn(Arrays.asList(question1, question2));
//
//        //Act
//
//        List<QuestionResponse> receivedQuestions = messageService.getAllQuestions();
//
//        //Assert
//        Assertions.assertNotNull(receivedQuestions);
//        assertEquals(2, receivedQuestions.size());
//        assertEquals(question1.getQuestion(), receivedQuestions.get(0).getQuestion());
//        assertEquals(question2.getQuestion(), receivedQuestions.get(1).getQuestion());

    }
}
