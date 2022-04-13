package com.postcoreapi.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "post_core")
public class PostEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;
    @Column(name = "post_id", nullable = false, unique = true)
    private String postId;
    @Column(name = "client_id", nullable = false)
    private String clientId;
    @Column(name = "post_recipient_id", nullable = false)
    private String postRecipientId;
    @Column(name = "post_item", nullable = false)
    private String postItem;
    @Column(name = "status", nullable = false)
    private String status;
}
