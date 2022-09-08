package com.beta.postandcomments.domain.commands;

import co.com.sofka.domain.generic.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreatePostCommand extends Command {
    private String postId;
    private String author;
    private String title;

}
