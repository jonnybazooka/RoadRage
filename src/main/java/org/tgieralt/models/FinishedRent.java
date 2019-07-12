package org.tgieralt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class FinishedRent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String producer;
    private String model;
    private String customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private String comments;

    public FinishedRent() {
    }

    public FinishedRent(String producer, String model, String customer, LocalDate startDate, LocalDate endDate, String comments) {
        this.producer = producer;
        this.model = model;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.comments = comments;
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
