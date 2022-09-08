package com.beta.postandcomments.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;

@Getter

public class CommentAdded extends DomainEvent {

    private String id;
    private String author;
    private String content;


    public CommentAdded(String id, String author, String content) {
        super("com.beta.commentcreated");
        this.id = id;
        this.author = author;
        this.content = content;
    }

}
