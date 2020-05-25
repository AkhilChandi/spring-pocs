package com.akhil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventResource {

    @Autowired
    private CustomSpringEventPublisher eventPublisher;

    @GetMapping
    public String sayHello(){
        eventPublisher.publishAnEvent("Hello World!....");
        return "Hello World!...";
    }

}
