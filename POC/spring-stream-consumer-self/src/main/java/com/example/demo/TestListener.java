package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestListener {

    @StreamListener(TestTopic.INPUT)
    public void receive(String payload) {
        // Logger.info("Received: " + payload);
        throw new RuntimeException("BOOM!");
    }

}