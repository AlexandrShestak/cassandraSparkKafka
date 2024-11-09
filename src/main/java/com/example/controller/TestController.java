package com.example.controller;

import com.example.service.KafkaSenderService;
import com.example.service.SparkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    final SparkService sparkService;
    final KafkaSenderService kafkaSenderService;

    public TestController(SparkService sparkService, KafkaSenderService kafkaSenderService) {
        this.sparkService = sparkService;
        this.kafkaSenderService = kafkaSenderService;
    }

    @GetMapping
    public String retrieveSomeMessage() {
        return "some message";
    }


    @GetMapping("/sparkShowEmployees")
    public void sparkShowEmployees() {
        sparkService.sparkShowEmployees();
    }

    @GetMapping("/sendMessageToKafka")
    public void sendMessageToKafka(@RequestParam String message, @RequestParam String topic) {
        kafkaSenderService.sendMessage(message, topic);
    }



}
