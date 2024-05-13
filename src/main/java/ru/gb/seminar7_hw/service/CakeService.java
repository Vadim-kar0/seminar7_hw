package ru.gb.seminar7_hw.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.seminar7_hw.aspect.TrackUserAction;
import ru.gb.seminar7_hw.model.Cake;
import ru.gb.seminar7_hw.repository.CakesRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CakeService {

    private final CakesRepository repository;

    @TrackUserAction
    public List<Cake> getAllCakes() {
        return repository.findAll();
    }

    @TrackUserAction
    public Cake getCakeByName(String name) {
        return repository.findById(name).orElse(null);
    }

    @TrackUserAction
    public Cake createCake(Cake cake) {
        return repository.save(cake);
    }

    @TrackUserAction
    public void sellCake(String name) {
        repository.deleteById(name);
    }
}
