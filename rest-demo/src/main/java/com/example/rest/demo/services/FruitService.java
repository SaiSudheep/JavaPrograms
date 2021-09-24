package com.example.rest.demo.services;

import com.example.rest.demo.model.Fruit;

import java.util.List;

public interface FruitService {

    public List<Fruit> getFruits();

    public Fruit getFruit(int id);

    public Fruit addFruit(Fruit fruit);

    public Fruit deleteFruit(int id);

    public Fruit updateFruit(int id, Fruit fruit);
}
