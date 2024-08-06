package com.soundwave.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.soundwave.app.model.Reactions;
import com.soundwave.app.service.ReactionsService;

@RestController
@RequestMapping("/api/reactions")
public class ReactionsController {

    @Autowired
    private ReactionsService reactionsService;

    @GetMapping
    public List<Reactions> getAllReactions() {
        return reactionsService.getAllReactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reactions> getReactionById(@PathVariable Long id) {
        return reactionsService.getReactionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reactions createReaction(@RequestBody Reactions reaction) {
        return reactionsService.createReaction(reaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reactions> updateReaction(@PathVariable Long id, @RequestBody Reactions reactionDetails) {
        return ResponseEntity.ok(reactionsService.updateReaction(id, reactionDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable Long id) {
        reactionsService.deleteReaction(id);
        return ResponseEntity.noContent().build();
    }
}
