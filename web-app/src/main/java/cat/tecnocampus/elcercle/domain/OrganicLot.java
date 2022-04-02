package cat.tecnocampus.elcercle.domain;

import cat.tecnocampus.elcercle.utilities.OrganicState;
import cat.tecnocampus.elcercle.utilities.Parameters;

import java.util.Date;
import java.util.List;

public class OrganicLot {
    private String id;
    private float quilograms;
    private Date deliver_date;
    private Date done_date;
    private OrganicState state;
    private List<Product> generated_products;

    public double get_discount(){
        return this.quilograms * Parameters.ORGANIC_PRICE_KILO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getQuilograms() {
        return quilograms;
    }

    public void setQuilograms(float quilograms) {
        this.quilograms = quilograms;
    }

    public Date getDeliver_date() {
        return deliver_date;
    }

    public void setDeliver_date(Date deliver_date) {
        this.deliver_date = deliver_date;
    }

    public Date getDone_date() {
        return done_date;
    }

    public void setDone_date(Date done_date) {
        this.done_date = done_date;
    }

    public OrganicState getState() {
        return state;
    }

    public void setState(OrganicState state) {
        this.state = state;
    }

    public List<Product> getGenerated_products() {
        return generated_products;
    }

    public void setGenerated_products(List<Product> generated_products) {
        this.generated_products = generated_products;
    }
}
