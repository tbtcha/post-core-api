package com.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostModel {
private String postId;
@NonNull
private String clientId;
@NonNull
private String postRecipientId;
@NonNull
private String postItem;
private String status;
}
