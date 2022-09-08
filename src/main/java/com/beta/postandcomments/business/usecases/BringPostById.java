package com.beta.postandcomments.business.usecases;




import com.beta.postandcomments.application.adapters.repository.MongoViewRepository;
import com.beta.postandcomments.business.gateways.model.PostViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class BringPostById implements Function<String, Mono<PostViewModel>> {
    // finish the implementation of this class using the functional interfaces
    private final MongoViewRepository mongoViewRepository;
    @Override
    public Mono<PostViewModel> apply(String postId) {
        return this.mongoViewRepository.findByPostId(postId);
    }

}
