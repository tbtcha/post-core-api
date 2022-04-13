package com.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostModel {
private String postId;
    @NotNull
private String clientId;
    @NotNull
private String postRecipientId;
@NotNull
private String postItem;
private String status;
}
