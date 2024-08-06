package com.soundwave.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reactions")
public class Reactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "postId", nullable = false)
    private Long postId;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "type", nullable = false)
    private String type;

    public Reactions() {
    }

    public Reactions(Long id, Long postId, Long userId, String type) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reactions{" +
                "id=" + id +
                ", postId=" + postId +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                '}';
    }
}
