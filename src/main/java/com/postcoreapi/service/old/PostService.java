package com.postcoreapi.service.old;

import com.postcoreapi.model.PostModel;

import java.util.List;

public interface PostService {
    void createPost(PostModel postModel);
    List<PostModel> getAllPosts();
    PostModel getPostById(String postId);
    void updatePostById(String postId, PostModel model);
    void deletePostById(String postId);
}
