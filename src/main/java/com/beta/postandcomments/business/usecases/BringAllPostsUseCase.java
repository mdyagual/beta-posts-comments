package com.beta.postandcomments.business.usecases;



import com.beta.postandcomments.application.adapters.repository.MongoViewRepository;
import com.beta.postandcomments.business.gateways.model.PostViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class BringAllPostsUseCase implements Supplier<Flux<PostViewModel>> {

    //Finish the implementation of this class using the functional interfaces
    private final MongoViewRepository mongoViewRepository;
    @Override
    public Flux<PostViewModel> get() {
        return this.mongoViewRepository.findAllPosts();
    }

}
