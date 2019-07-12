package org.tgieralt.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String email;
    private String creditCardNumber;
    private String passHash;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rent> rentList = new ArrayList<>();

    public User() {
    }

    public User(String email, String creditCardNumber, String passHash) {
        this.email = email;
        this.creditCardNumber = creditCardNumber;
        this.passHash = passHash;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    public List<Rent> getRentList() {
        return rentList;
    }

    public void addRent(Rent rent) {
        this.rentList.add(rent);
        rent.setUser(this);
    }

    public void removeRent(Rent rent) {
        this.rentList.remove(rent);
        rent.setUser(null);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }
}
