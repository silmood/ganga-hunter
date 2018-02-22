package io.bunsan.gangahunter;


import java.util.UUID;

public class Ganga {

    private String id;
    private String name;
    private Float price;

    public Ganga() {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.price = 0F;

    }

    public Ganga(String name, Float price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
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
}
