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

    @GetMapping("/fruits/{id}")
    public Fruit getFruitById(@PathVariable Integer id) {
        return this.fruitService.getFruit(id);
    }

    @PostMapping("/fruits")
    public Fruit addFruit(@RequestBody Fruit fruit) {
        return this.fruitService.addFruit(fruit);
    }

    @DeleteMapping("/fruits/{id}")
    public Fruit deleteFruit(@PathVariable String id) {
        return this.fruitService.deleteFruit(Integer.parseInt(id));
    }

    @PutMapping("/fruits/{id}")
    public Fruit updateFruit(@PathVariable String id, @RequestBody Fruit fruit) {
        return this.fruitService.updateFruit(Integer.parseInt(id), fruit);
    }
}
