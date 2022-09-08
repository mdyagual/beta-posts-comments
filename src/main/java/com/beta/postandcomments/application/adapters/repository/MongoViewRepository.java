package com.beta.postandcomments.application.adapters.repository;


import com.beta.postandcomments.business.gateways.DomainViewRepository;
import com.beta.postandcomments.business.gateways.model.CommentViewModel;
import com.beta.postandcomments.business.gateways.model.PostViewModel;
import com.google.gson.Gson;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MongoViewRepository implements DomainViewRepository {
    private final ReactiveMongoTemplate template;

    private final Gson gson = new Gson();

    public MongoViewRepository(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @Override
    public Mono<PostViewModel> findByAggregateId(String aggregateId) {
        /**Make the implementation, using the template, to find a post by its aggregateId*/
        return this.template.findById(aggregateId, PostViewModel.class,"postId");


    }

    @Override
    public Mono<PostViewModel> findByPostId(String postId){
        return this.template.findById(postId, PostViewModel.class,"views");
    }

    @Override
    public Flux<PostViewModel> findAllPosts() {
        /**make the implementation, using the template, of the method find all posts that are stored in the db*/
        return this.template.findAll(PostViewModel.class);
    }

    @Override
    public Mono<PostViewModel> saveNewPost(PostViewModel post) {
        /** make the implementation, using the template, to save a post*/
        return this.template.save(post);
    }

    @Override
    public Mono<PostViewModel> addCommentToPost(CommentViewModel comment) {
        /** make the implementation, using the template, to find the post in the database that you want to add the comment to,
         * then add the comment to the list of comments and using the Update class update the existing post
         * with the new list of comments*/
        Update update = new Update();
        return this.template.findById(comment.getPostId(), PostViewModel.class)
                .flatMap(postViewModel -> {
                    var comments = postViewModel.getComments();
                    comments.add(comment);
                    update.set("comments",comments);
                    return this.template
                            .findAndModify(
                                    new Query(Criteria.where("aggregateId").is(comment.getPostId())),
                                    update,
                                    PostViewModel.class);

                });
    }
}
