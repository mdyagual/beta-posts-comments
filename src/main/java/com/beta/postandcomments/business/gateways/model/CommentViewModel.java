package com.beta.postandcomments.business.gateways.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentViewModel {
    private String id;
    private String postId;
    private String author;
    private String content;

}
