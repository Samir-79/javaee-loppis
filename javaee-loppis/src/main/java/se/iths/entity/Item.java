package se.iths.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NamedQuery(name = "itemEntity.findAll", query="SELECT i FROM Item i")
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Constraint, förhindrar att ett namn med mindre än 2 bokstäver anges
    @NotEmpty
    @Size(min = 2)
    private String name;
    private String category;
    private int quantity;
    private double price;
    private LocalDate createdAt;

    @ManyToOne
    private User user;

    public Item(String name, String category, int quantity, double price) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public Item() {}

    // Denna metod körs innan objektet skrivs till DB




    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@JsonbProperty("HejHejJU20")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //@JsonbTransient
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @PrePersist
    public void getCurrentDate() {
        setCreatedAt(LocalDate.now());
    }

    //For Demo Purpose
    @PostPersist
    public void itemWasPersisted() {
        System.out.println("Item was stored in DB");

    }

}
