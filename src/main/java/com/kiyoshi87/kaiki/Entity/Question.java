package com.kiyoshi87.kaiki.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Questions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    private ObjectId id;

    private String question;

}
