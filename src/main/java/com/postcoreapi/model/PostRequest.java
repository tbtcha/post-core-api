package com.postcoreapi.model;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostRequest {
    private String postId;
    @NotNull
    private String clientId;
    @NotNull
    private String postRecipientId;
    @NotNull
    private String postItem;
    private String status;
}
