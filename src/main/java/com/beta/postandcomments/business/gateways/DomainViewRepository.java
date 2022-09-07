package com.beta.postandcomments.business.gateways;


import com.beta.postandcomments.business.gateways.model.CommentViewModel;
import com.beta.postandcomments.business.gateways.model.PostViewModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DomainViewRepository {
    Mono<PostViewModel> findByAggregateId(String aggregateId);
    Flux<PostViewModel> findAllPosts();
    Mono<PostViewModel> saveNewPost(PostViewModel post);
    Mono<PostViewModel> addCommentToPost(CommentViewModel comment);
}
