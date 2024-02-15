package com.microsevice.post.repository;

import com.microsevice.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post,String> {
}
