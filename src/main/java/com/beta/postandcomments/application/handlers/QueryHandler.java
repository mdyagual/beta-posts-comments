package com.beta.postandcomments.application.handlers;


import com.beta.postandcomments.business.gateways.model.PostViewModel;
import com.beta.postandcomments.business.usecases.BringAllPostsUseCase;
import com.beta.postandcomments.business.usecases.BringPostById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class QueryHandler {

    //Create a route that allows you to make a Get Http request that brings you all the posts and also a post by its id
    @Bean
    public RouterFunction<ServerResponse> getAllPosts(BringAllPostsUseCase bringAllPostsUseCase) {
        return route(GET("/api/v1/posts/all"),
                request -> ServerResponse
                                .ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(bringAllPostsUseCase.get(), PostViewModel.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getPostById(BringPostById bringPostById){
        return route(GET("/api/v1/posts/{postId}"),
                request -> bringPostById.apply(request.pathVariable("postId"))
                        .flatMap(postViewModel -> ServerResponse
                                .ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(postViewModel)));
    }
}
