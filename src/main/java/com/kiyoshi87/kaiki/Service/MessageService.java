package com.kiyoshi87.kaiki.Service;

import com.kiyoshi87.kaiki.Entity.Message;
import com.kiyoshi87.kaiki.Entity.Question;
import com.kiyoshi87.kaiki.Repository.MessageRepository;
import com.kiyoshi87.kaiki.Repository.QuestionRepository;
import com.kiyoshi87.kaiki.dto.MessageResponse;
import com.kiyoshi87.kaiki.dto.QuestionResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    private final QuestionRepository questionRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, QuestionRepository questionRepository) {
        this.messageRepository = messageRepository;
        this.questionRepository = questionRepository;
    }


    //------ALL SERVICES------//

    public List<QuestionResponse> getAllQuestions() {
        List<QuestionResponse> responses = new ArrayList<>();

        List<Question> questions = questionRepository.findAll();
        for(Question question : questions) {
            QuestionResponse response = new QuestionResponse();
            response.setId(question.getId().toString());
            response.setQuestion(question.getQuestion());
            responses.add(response);
        }
        return responses;
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Message saveMessage(String questionId, String message, String ip) {
        System.out.println("Inside saveMessage service class");
        System.out.println(questionId);
        ObjectId id = new ObjectId(questionId);
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
            System.out.println("Passed the question");
        }
        else {
            throw new IllegalArgumentException("Invalid question ID");
        }
        System.out.println("Passed the question ID");
        Message newMessage = new Message();
        newMessage.setQuestion(question.get());
        newMessage.setMessage(message);
        newMessage.setIP(ip);
        newMessage.setTimeStamp(System.currentTimeMillis());
        return messageRepository.save(newMessage);
    }

    public List<MessageResponse> getMessageByQuestion(String questionId) {
        Question question = questionRepository.findById(new ObjectId(questionId)).orElseThrow(() -> new IllegalArgumentException("Invalid question ID"));
        List<Message> responses = messageRepository.findByQuestionQuestion(question.getQuestion());
        List<MessageResponse> messageResponses = new ArrayList<>();
        for(Message message : responses) {
            MessageResponse response = new MessageResponse();
            response.setQuestion(question);
            response.setId(message.getId().toString());
            response.setMessage(message.getMessage());
            messageResponses.add(response);
        }
        return messageResponses;
    }

    public void deleteQuestion(String questionId) {

        Question question = questionRepository.findById(new ObjectId(questionId)).orElseThrow(() -> new IllegalArgumentException("Invalid question ID"));
        List<Message> messages = messageRepository.findByQuestionQuestion(question.getQuestion());

        messageRepository.deleteAll(messages);

        questionRepository.deleteById(new ObjectId(questionId));

    }
}