package io.bunsan.gangahunter.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Ganga {

    public static final String FORMAT_DATE = "dd/MM/yy";

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

    public String getId() {
        return id;
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

    public String getDueDateFormatted() {
        // Formatear fecha
        DateFormat format = new SimpleDateFormat(FORMAT_DATE);
        String formattedDate = format.format(dueDate);

        return formattedDate;
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
