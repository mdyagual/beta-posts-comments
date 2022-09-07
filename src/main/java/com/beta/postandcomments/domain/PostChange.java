package com.beta.postandcomments.domain;

import co.com.sofka.domain.generic.EventChange;
import com.beta.postandcomments.domain.events.CommentAdded;
import com.beta.postandcomments.domain.events.PostCreated;
import com.beta.postandcomments.domain.values.Author;
import com.beta.postandcomments.domain.values.CommentId;
import com.beta.postandcomments.domain.values.Content;
import com.beta.postandcomments.domain.values.Title;

import java.util.ArrayList;

public class PostChange extends EventChange {

    public PostChange(Post post){
        apply((PostCreated event)-> {
            post.title = new Title(event.getTitle());
            post.author = new Author(event.getAuthor());
            post.comments = new ArrayList<>();
        });

        apply((CommentAdded event)-> {
            Comment comment = new Comment(CommentId.of(event.getId()), new Author(event.getAuthor()), new Content(event.getContent()));
            post.comments.add(comment);
        });
    }
}
