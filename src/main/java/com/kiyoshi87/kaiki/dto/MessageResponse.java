package com.kiyoshi87.kaiki.dto;

import com.kiyoshi87.kaiki.Entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageResponse {

    private String id;

    private Question question;

    private String message;

}
