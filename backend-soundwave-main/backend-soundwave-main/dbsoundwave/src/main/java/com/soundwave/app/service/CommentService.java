package com.soundwave.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soundwave.app.model.Comment;
import com.soundwave.app.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment commentDetails) {
        return commentRepository.findById(id)
                .map(comment -> {
                    comment.setContent(commentDetails.getContent());
                    comment.setUserId(commentDetails.getUserId());
                    return commentRepository.save(comment);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + id));
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
