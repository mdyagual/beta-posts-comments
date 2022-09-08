package com.beta.postandcomments.application.handlers;



import co.com.sofka.domain.generic.DomainEvent;
import com.beta.postandcomments.application.adapters.bus.Notification;
import com.beta.postandcomments.business.usecases.UpdateViewUseCase;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class QueueHandler implements Consumer<String> {
    private final Gson gson = new Gson();
    private final UpdateViewUseCase useCase;

    public QueueHandler(UpdateViewUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void accept(String received) {
        //Finish the implementation of this Method
        var notification = gson.fromJson(received, Notification.class);
        var type = notification.getType().replace("alphapostsandcomments","betapostsandcomments");
        try{
            var event= (DomainEvent) gson.fromJson(notification.getBody(),Class.forName(type));
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
    }
}
