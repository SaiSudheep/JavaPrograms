package com.example.rest.demo.services;

import com.example.rest.demo.model.Fruit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Dummy {
    public final List<Fruit> list = new ArrayList<>();

    public List<Fruit> getList() {
        return list;
    }

    public Dummy() {
        list.add(new Fruit(1,"Mango",25));
        list.add(new Fruit(2,"Watermelon",50));
        list.add(new Fruit(3,"Litchi",100));
    }
}
