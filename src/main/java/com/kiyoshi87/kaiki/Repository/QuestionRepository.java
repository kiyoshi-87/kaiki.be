package com.kiyoshi87.kaiki.Repository;

import com.kiyoshi87.kaiki.Entity.Question;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, ObjectId> {

}
