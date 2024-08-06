package com.soundwave.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soundwave.app.model.Reactions;
import com.soundwave.app.repository.ReactionsRepository;

@Service
public class ReactionsService {

    @Autowired
    private ReactionsRepository reactionsRepository;

    public List<Reactions> getAllReactions() {
        return reactionsRepository.findAll();
    }

    public Optional<Reactions> getReactionById(Long id) {
        return reactionsRepository.findById(id);
    }

    public Reactions createReaction(Reactions reaction) {
        return reactionsRepository.save(reaction);
    }

    public Reactions updateReaction(Long id, Reactions reactionDetails) {
        return reactionsRepository.findById(id)
                .map(reaction -> {
                    reaction.setPostId(reactionDetails.getPostId());
                    reaction.setUserId(reactionDetails.getUserId());
                    reaction.setType(reactionDetails.getType());
                    return reactionsRepository.save(reaction);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Reaction not found with id " + id));
    }

    public void deleteReaction(Long id) {
        reactionsRepository.deleteById(id);
    }
}
