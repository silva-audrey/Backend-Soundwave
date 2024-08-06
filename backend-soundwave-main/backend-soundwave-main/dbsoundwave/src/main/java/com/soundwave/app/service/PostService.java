package com.soundwave.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soundwave.app.model.Post;
import com.soundwave.app.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post postDetails) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setContent(postDetails.getContent());
                    post.setUrl(postDetails.getUrl());
                    post.setCreatedAt(postDetails.getCreatedAt());
                    post.setUserId(postDetails.getUserId());
                    return postRepository.save(post);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + id));
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
