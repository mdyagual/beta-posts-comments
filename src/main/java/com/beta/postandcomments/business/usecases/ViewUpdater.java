package com.beta.postandcomments.business.usecases;


import com.beta.postandcomments.business.gateways.DomainViewRepository;
import com.beta.postandcomments.business.gateways.model.CommentViewModel;
import com.beta.postandcomments.business.gateways.model.PostViewModel;
import com.beta.postandcomments.business.generic.DomainUpdater;
import com.beta.postandcomments.domain.events.CommentAdded;
import com.beta.postandcomments.domain.events.PostCreated;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service

public class ViewUpdater extends DomainUpdater {

    //Complete the implementation of the view update
    private final DomainViewRepository domainViewRepository;

    public ViewUpdater(DomainViewRepository domainViewRepository){
        this.domainViewRepository = domainViewRepository;

        listen((PostCreated event)-> {
            var post = new PostViewModel(event.aggregateRootId(), event.getAuthor(), event.getTitle(), new ArrayList<>());
            domainViewRepository.saveNewPost(post).subscribe();
        });

        listen((CommentAdded event) -> {
            var comment = new CommentViewModel(event.getId(), event.aggregateRootId(), event.getAuthor(), event.getContent());
            domainViewRepository.addCommentToPost(comment).subscribe();
        });
    }


}
