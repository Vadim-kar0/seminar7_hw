package ru.gb.seminar7_hw.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cakes")
@AllArgsConstructor
@NoArgsConstructor
public class Cake {

    @Id
    private String name;

    @Column(nullable = false)
    private int weight;

    @Column(nullable = false)
    private int calorific;

    @Column(nullable = false)
    private double price;

}
