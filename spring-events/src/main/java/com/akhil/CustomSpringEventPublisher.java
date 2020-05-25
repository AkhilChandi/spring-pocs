package com.akhil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomSpringEventPublisher {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void publishAnEvent(String message){
        log.info("Publishing custom message : {}",message);
        CustomSpringEvent springEvent=new CustomSpringEvent(this,message);
        eventPublisher.publishEvent(springEvent);
        log.info("### Event Published ###");
    }
}
