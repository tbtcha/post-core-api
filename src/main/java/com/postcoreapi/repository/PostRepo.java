package com.postcoreapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<PostEntity, Long> {
    PostEntity getPostEntityByPostId(String postId);

    List<PostEntity> getPostEntitiesBy();

    @Transactional
    void deleteByPostId(String postId);
}
