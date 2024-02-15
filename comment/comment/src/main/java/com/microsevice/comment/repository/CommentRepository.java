package com.microsevice.comment.repository;

import com.microsevice.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,String> {

    List<Comment> findByPostId(String postID);
}
