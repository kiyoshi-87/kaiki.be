package com.kiyoshi87.kaiki.Controller;

import com.kiyoshi87.kaiki.Entity.Message;
import com.kiyoshi87.kaiki.Entity.Question;
import com.kiyoshi87.kaiki.Service.MessageService;
import com.kiyoshi87.kaiki.dto.MessageRequest;
import com.kiyoshi87.kaiki.dto.MessageResponse;
import com.kiyoshi87.kaiki.dto.QuestionResponse;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public ResponseEntity<String> Home() {
        return new ResponseEntity<>("Api is running on port 8080", HttpStatus.OK);
    }

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionResponse>> getQuestions() {
        return new ResponseEntity<>(messageService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("/messages/{questionId}")
    public ResponseEntity<List<MessageResponse>> getMessageBasedOnQuestionId(@PathVariable String questionId) {
        return new ResponseEntity<>(messageService.getMessageByQuestion(questionId), HttpStatus.OK);
    }

    //-----POST MAPPINGS-------//

    @PostMapping("/messages")
    public ResponseEntity<Message> createMessage(@RequestBody MessageRequest messageRequest, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        Message savedMessage = messageService.saveMessage(messageRequest.getQuestionId(), messageRequest.getMessage(), ip);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }

    @PostMapping("/question")
    public ResponseEntity<QuestionResponse> createQuestion(@RequestBody Question question) {
        Question qs = messageService.createQuestion(question);
        QuestionResponse response = new QuestionResponse();
        response.setId(qs.getId().toString());
        response.setQuestion(qs.getQuestion());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //------DELETE MAPPING------//

    @DeleteMapping("/question/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable String questionId) {
        messageService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //------ERROR MAPPING------//

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
