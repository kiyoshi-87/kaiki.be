package com.kiyoshi87.kaiki.Repository;

import com.kiyoshi87.kaiki.Entity.Message;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, ObjectId> {

    List<Message> findByQuestionQuestion(String question);
}



