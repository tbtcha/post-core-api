package com.postcoreapi.controller;

import com.postcoreapi.model.PostModel;
import com.postcoreapi.model.PostRequest;
import com.postcoreapi.model.PostResponse;
import com.postcoreapi.service.working.PostServiceImplNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostServiceImplNew postService;

    @Autowired
    Environment env;

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@Valid @RequestBody PostRequest postRequest){
        return new ResponseEntity<PostResponse>(postService.createPost(postRequest), HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<String> healthCheck(){
        String status = String.format("post-core-api is working at port: (%d)", env.getProperty("server.port"));
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostResponse> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostResponse getPostById(@PathVariable String postId){
        return postService.getPostById(postId);
    }

    @PutMapping
    public ResponseEntity<PostResponse> updatePost(@Valid @RequestBody PostRequest postRequest) {
        return new ResponseEntity<PostResponse>(postService.updatePost(postRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
    }
}
