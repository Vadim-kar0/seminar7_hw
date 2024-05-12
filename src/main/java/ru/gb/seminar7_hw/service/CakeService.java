package ru.gb.seminar7_hw.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.seminar7_hw.model.Cake;
import ru.gb.seminar7_hw.repository.CakesRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CakeService {

    private final CakesRepository repository;


    public List<Cake> getAllCakes() {
        return repository.findAll();
    }


    public Cake getCakeByName(String name) {
        return repository.findById(name).orElse(null);
    }

    public Cake createCake(Cake cake) {
        return repository.save(cake);
    }

    public void sellCake(String name) {
        repository.deleteById(name);
    }
}
