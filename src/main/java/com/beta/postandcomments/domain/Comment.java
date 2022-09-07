package com.beta.postandcomments.domain;


import co.com.sofka.domain.generic.Entity;
import com.beta.postandcomments.domain.values.Author;
import com.beta.postandcomments.domain.values.CommentId;
import com.beta.postandcomments.domain.values.Content;

public class Comment extends Entity<CommentId> {

    private Author author;
    private Content content;


    public Comment(CommentId entityId, Author author, Content content) {
        super(entityId);
        this.author = author;
        this.content = content;
    }

    public Author author() {
        return author;
    }

    public Content content() {
        return content;
    }
}
