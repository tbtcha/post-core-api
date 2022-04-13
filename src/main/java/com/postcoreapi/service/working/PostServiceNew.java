package com.postcoreapi.service.working;

import com.postcoreapi.model.PostRequest;
import com.postcoreapi.model.PostResponse;
import com.postcoreapi.repository.PostEntity;
import com.postcoreapi.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceNew implements PostServiceImplNew{

    @Autowired
    PostRepo postRepo;

    @Override
    public PostResponse createPost(PostRequest postRequest) {
        postRequest.setPostId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);
        postEntity = postRepo.save(postEntity);
        return modelMapper.map(postEntity, PostResponse.class);
    }

    @Override
    public PostResponse updatePost(PostRequest postRequest) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);
        PostEntity dbEntity = postRepo.getPostEntityByPostId(postRequest.getPostId());
        postEntity.setPostId(dbEntity.getPostId());
        postEntity = postRepo.save(postEntity);
        return modelMapper.map(postEntity, PostResponse.class);
    }

    @Override
    public List<PostResponse> getAllPosts() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return postRepo.getPostEntitiesBy().stream().map(post -> modelMapper.map(post, PostResponse.class)).collect(Collectors.toList());
    }

    @Override
    public PostResponse getPostById(String postId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PostEntity postEntity = postRepo.getPostEntityByPostId(postId);
        return modelMapper.map(postEntity, PostResponse.class);
    }

    @Override
    public void deletePostById(String postId) {
    postRepo.deleteByPostId(postId);
    }
}
