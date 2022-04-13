package com.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponse {
    private String postId;
    private String clientId;
    private String postRecipientId;
    private String postItem;
    private String status;
}
