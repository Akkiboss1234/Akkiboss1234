package com.microsevice.comment.service;

import com.microsevice.comment.config.RestTemplateConfig;
import com.microsevice.comment.entity.Comment;
import com.microsevice.comment.payload.Post;
import com.microsevice.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class CommentServiceImple {
   @Autowired
    private CommentRepository commentRepository;
@Autowired
private RestTemplateConfig restTemplate;

   public Comment saveComment(Comment comment) {
       Post post = restTemplate.getRestTemplate().getForObject("Http://localhost:8081/api/posts/" + comment.getPostId(), Post.class);

       if (post != null) {
           Comment savedComment = commentRepository.save(comment);
           return savedComment;
       } else {
           return null;

       }

   }

    public List<Comment> getAllCommentPostId(String postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments;
    }
}
