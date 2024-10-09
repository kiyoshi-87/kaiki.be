package com.kiyoshi87.kaiki.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("Messages")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    @MongoId
    private ObjectId id;

    private Question question;
    private String message;
    private String IP;
    private long timeStamp;

}
