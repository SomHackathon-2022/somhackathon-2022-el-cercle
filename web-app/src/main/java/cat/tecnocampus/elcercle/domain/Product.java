package cat.tecnocampus.elcercle.domain;

import java.util.Date;

public class Product {
    private String id;
    private String name;
    private double quilograms;
    private Date deliver_date;
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuilograms() {
        return quilograms;
    }

    public void setQuilograms(double quilograms) {
        this.quilograms = quilograms;
    }

    public Date getDeliver_date() {
        return deliver_date;
    }

    public void setDeliver_date(Date deliver_date) {
        this.deliver_date = deliver_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
