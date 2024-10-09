package com.kiyoshi87.kaiki.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiyoshi87.kaiki.Entity.Message;
import com.kiyoshi87.kaiki.Entity.Question;
import com.kiyoshi87.kaiki.Service.MessageService;
import com.kiyoshi87.kaiki.dto.MessageRequest;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = MessageController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class MessageControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private MessageService messageService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    @DisplayName("For the route: GET /api/questions")
//    public void getQuestionsTest() throws Exception {
//        Question question1 = Question.builder()
//                .id(new ObjectId("1"))
//                .question("What is your name?")
//                .build();
//
//        Question question2 = Question.builder()
//                .id(new ObjectId("2"))
//                .question("What is your favorite color?")
//                .build();
//
//        when(messageService.getAllQuestions()).thenReturn(Arrays.asList(question1, question2));
//
//        mockMvc.perform(get("/api/questions"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].question").value("What is your name?"))
//                .andExpect(jsonPath("$[1].question").value("What is your favorite color?"));
//    }
//
//    @Test
//    @DisplayName("For the route: GET /api/messages/{questionId}")
//    public void getMessageBasedOnQuestionIdTest() throws Exception {
//        Question question = Question.builder()
//                .id(new ObjectId("1"))
//                .question("What is your name?")
//                .build();
//
//        Message message1 = Message.builder()
//                .question(question)
//                .message("I don't have a name, sorry.")
//                .id(new ObjectId("123"))
//                .IP("0.0.0.0")
//                .build();
//
//        Message message2 = Message.builder()
//                .question(question)
//                .message("My name is John Doe.")
//                .id(new ObjectId("124"))
//                .IP("0.0.0.0")
//                .build();
//
//        when(messageService.getMessageByQuestion(question.getId().toString())).thenReturn((Arrays.asList(message1, message2)));
//
//        mockMvc.perform(get("/api/messages/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].message").value(message1.getMessage()))
//                .andExpect(jsonPath("$[1].message").value(message2.getMessage()));
//    }
//
//    @Test
//    @DisplayName("For the route: POST /api/messages")
//    public void createMessageTest() throws Exception {
//        Question question = Question.builder()
//                .id(new ObjectId("1"))
//                .question("What is your name?")
//                .build();
//
//        Message message = Message.builder()
//                .id(new ObjectId("123"))
//                .question(question)
//                .message("My name is John Doe.")
//                .IP("0.0.0.0")
//                .timeStamp(System.currentTimeMillis())
//                .build();
//
//        MessageRequest messageRequest = MessageRequest.builder()
//                .message(message.getMessage())
//                .questionId(question.getId().toString())
//                .build();
//
//        when(messageService.saveMessage(eq(messageRequest.getQuestionId()), eq(messageRequest.getMessage()), anyString()))
//                .thenReturn(message);
//
//        mockMvc.perform(post("/api/messages")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(messageRequest)))
//                        .andExpect(status().isCreated())
//                        .andExpect(jsonPath("$.message").value("My name is John Doe."));
//
//    }
//
//    @Test
//    @DisplayName("For the route: POST /api/question")
//    public void createQuestionTest() throws Exception {
//
//        Question question = Question.builder()
//                .id(new ObjectId("1"))
//                .question("What is your name?")
//                .build();
//
//        when(messageService.createQuestion(question)).thenReturn(question);
//
//        mockMvc.perform(post("/api/question")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(question)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.question").value(question.getQuestion()));
//    }
}