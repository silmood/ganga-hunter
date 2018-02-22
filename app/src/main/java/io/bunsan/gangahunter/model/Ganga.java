package io.bunsan.gangahunter.model;


import java.util.Date;
import java.util.UUID;

public class Ganga {

    private String id;
    private String name;
    private Date dueDate;
    private String place;
    private Float price;

    public Ganga() {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.price = 0F;
        this.dueDate = new Date();
        this.place = "";
    }

    public Ganga(String name, Float price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.dueDate = new Date();
        this.place = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
