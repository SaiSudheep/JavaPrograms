package com.example.rest.demo.controller;

import com.example.rest.demo.model.Fruit;
import com.example.rest.demo.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping("/home")
    public String home() {
        return "Welcome!";
    }

    @GetMapping("/fruits")
    public List<Fruit> getFruits() {
        return this.fruitService.getFruits();
    }
}
