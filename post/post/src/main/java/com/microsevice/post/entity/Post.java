package com.microsevice.post.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="post")
public class Post {
    @Id
    private String postId;
    private String title;
    private String description;
    private String content;
}
