package com.example.rest.demo.services;

import com.example.rest.demo.model.Fruit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    List<Fruit> list;

    public FruitServiceImpl() {
        list = new ArrayList<>();
        list.add(new Fruit(1,"Mango",25));
        list.add(new Fruit(2,"Watermelon",50));
        list.add(new Fruit(3,"Litchi",100));
    }

    @Override
    public List<Fruit> getFruits() {
        return list;
    }

    @Override
    public Fruit getFruit(int id) {
        Fruit fruit = null;

        for(Fruit f: list) {
            if(f.getId() == id) {
                fruit = f;
                break;
            }
        }
        return fruit;
    }

    @Override
    public Fruit addFruit(Fruit fruit) {
        list.add(fruit);
        return fruit;
    }

    @Override
    public Fruit deleteFruit(int id) {
        Fruit fruit = null;
        int i = 0;

        for(Fruit f: list) {
            if(f.getId() == id) {
                fruit = f;
                list.remove(i);
                break;
            } else {
                i++;
            }
        }
        return fruit;
    }

    @Override
    public Fruit updateFruit(int id, Fruit fruit) {
        int i = 0;

        for(Fruit f: list) {
            if(f.getId() == id) {
                list.set(i, fruit);
            } else {
                i++;
            }
        }
        return fruit;
    }
}
