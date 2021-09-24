package com.example.Fruits.service;

import com.example.Fruits.domain.Fruit;
import com.example.Fruits.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    @Autowired
    private FruitRepository repo;

    public List<Fruit> listAll() {
        return repo.findAll();
    }

    public void save(Fruit f) {
        repo.save(f);
    }

    public Fruit get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
