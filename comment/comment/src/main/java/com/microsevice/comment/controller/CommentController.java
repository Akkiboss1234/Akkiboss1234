package com.microsevice.comment.controller;

import com.microsevice.comment.entity.Comment;
import com.microsevice.comment.service.CommentServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentServiceImple commentService;
@PostMapping()
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){
    String commentId = UUID.randomUUID().toString();
    comment.setCommentId(commentId);
        Comment comments = commentService.saveComment(comment);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    @GetMapping("{postId}")
public List<Comment> getAllCommentPostId(@PathVariable String postId){
    List<Comment> comments =commentService.getAllCommentPostId(postId);
    return comments;
}
}
