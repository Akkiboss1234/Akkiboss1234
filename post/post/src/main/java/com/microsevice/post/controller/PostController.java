package com.microsevice.post.controller;

import com.microsevice.post.entity.Post;
import com.microsevice.post.payload.PostDto;
import com.microsevice.post.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/posts")

public class PostController {


@Autowired
 private PostServiceImpl postService;

        @PostMapping
        public ResponseEntity<Post> savePost(@RequestBody Post post) {
            String postId = UUID.randomUUID().toString();
            post.setPostId(postId);
            Post newpost = postService.savePost(post);
            return  new ResponseEntity<>(newpost, HttpStatus.CREATED);

        }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable String postId) {
        Post post = postService.getUserById(postId);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
    //http://localhost:8082:/api/posts{postId}/comments
    @GetMapping("/{postId}/comments")
    public ResponseEntity<PostDto> getPostWithComments(@PathVariable String postId){

       PostDto postDto= postService.getPostWithComments(postId);

       return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

        }


