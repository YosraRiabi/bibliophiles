package com.yosra.bibliophiles.service;

import com.yosra.bibliophiles.Repository.CommentRepository;
import com.yosra.bibliophiles.domain.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
