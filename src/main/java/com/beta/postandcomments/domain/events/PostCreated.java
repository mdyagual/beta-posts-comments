package com.beta.postandcomments.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;

@Getter
public class PostCreated extends DomainEvent {
    private String title;
    private String author;

    public PostCreated() {
        super("com.beta.postcreated");
    }

    public PostCreated(String title, String author) {
        super("com.beta.postcreated");
        this.title = title;
        this.author = author;
    }


}
