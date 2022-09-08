package com.beta.postandcomments.business.usecases;


import co.com.sofka.domain.generic.DomainEvent;
import com.beta.postandcomments.business.gateways.EventBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class UpdateViewUseCase implements Consumer<DomainEvent> {

    //Complete the implementation of this class

    private final EventBus bus;
    private final ViewUpdater updater;


    @Override
    public void accept(DomainEvent domainEvent) {
        bus.publish(domainEvent);
        updater.applyEvent(domainEvent);
    }
}
