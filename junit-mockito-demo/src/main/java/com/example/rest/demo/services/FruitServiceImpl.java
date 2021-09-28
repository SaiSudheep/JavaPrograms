package com.example.rest.demo.services;

import com.example.rest.demo.model.Fruit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    private final Dummy dummy;

    public FruitServiceImpl(Dummy dummy) {
        this.dummy = dummy;
    }

    @Override
    public List<Fruit> getFruits() {
        return dummy.getList();
    }
}
