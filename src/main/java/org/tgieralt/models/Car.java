package org.tgieralt.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Car {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String producer;
    private String model;
    private LocalDate yearOfProduction;
    private boolean isAvailableForRent;
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Rent rent;

    public Car() {
    }

    public Car(String producer, String model, LocalDate yearOfProduction, boolean isAvailableForRent) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.isAvailableForRent = isAvailableForRent;
    }

    public void setRent(Rent rent) {
        if (rent == null) {
            if (this.rent != null) {
                this.rent.setCar(null);
            }
        } else {
            rent.setCar(this);
        }
        this.rent = rent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(LocalDate yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public boolean isAvailableForRent() {
        return isAvailableForRent;
    }

    public void setAvailableForRent(boolean availableForRent) {
        isAvailableForRent = availableForRent;
    }

    public Rent getRent() {
        return rent;
    }
}
