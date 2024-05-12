package ru.gb.seminar7_hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.seminar7_hw.model.Cake;


@Repository
public interface CakesRepository extends JpaRepository<Cake, String> {

}
