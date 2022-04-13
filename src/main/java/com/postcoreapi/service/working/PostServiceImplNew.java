package com.postcoreapi.service.working;

import com.postcoreapi.model.PostRequest;
import com.postcoreapi.model.PostResponse;

import java.util.List;

public interface PostServiceImplNew {
    PostResponse createPost(PostRequest postRequest);
    PostResponse updatePost(PostRequest postRequest);
    List<PostResponse> getAllPosts();
    PostResponse getPostById(String postId);
    void deletePostById(String postId);
}
