package com.kiyoshi87.kaiki.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageRequest {

    private String questionId;
    private String message;

}
