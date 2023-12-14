package org.spring.cloud.playground.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public interface Controller {

    @GetMapping("/dateTime")
    void printDateTime();

    @GetMapping("/date")
    void printDate();

    @GetMapping("/time")
    void printTime();

    @GetMapping("/produce/{name}/{message}")
    void produceMessage(@PathVariable String name,
                        @PathVariable String message);

}
