package com.microsevice.post.service;

import com.microsevice.post.config.RestTemplateConfig;
import com.microsevice.post.entity.Post;
import com.microsevice.post.payload.PostDto;
import com.microsevice.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PostServiceImpl {
    @Autowired
    private PostRepository postRepository;
@Autowired
private RestTemplateConfig restTemplate;
    public Post  savePost(Post post) {
        Post savedpost = postRepository.save(post);
        return savedpost;
    }


    public Post getUserById(String postId) {
        Post  post = postRepository.findById(postId).get();
      return post;
    }

    public PostDto getPostWithComments(String postId) {
        Post post = postRepository.findById(postId).get();
        ArrayList comments = restTemplate.getRestTemplate().getForObject("http://localhost:8082/api/comments/"+ postId, ArrayList.class);


        PostDto postDto= new PostDto();
        postDto.setPostId(post.getPostId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
         postDto.setComments(comments);
        return postDto;
    }
}
