package cat.tecnocampus.elcercle.domain;

import cat.tecnocampus.elcercle.application.dto.ProducteDTO;

import java.util.Date;
import java.util.UUID;

public class Producte {
    private String id;
    private String name;
    private double price;
    private String measure_unit;
    private String provider;
    private String vat_type;
    private String category;
    private Date initial_date;
    private String day_of_week;
    private int num_of_periods;
    private String period;
    private String image;

    public Producte(){

    }

    //UNTIL WE CREATE PRODUCTS WITH JSON----------------------------------------------
    public Producte(String name, double price, String measure_unit, String provider, String vat_type, String category,  Date initial_date, String day_of_week, int num_of_periods, String period, String image) {
        this.name = name;
        this.price = price;
        this.measure_unit = measure_unit;
        this.provider = provider;
        this.vat_type = vat_type;
        this.category = category;
        this.initial_date = initial_date;
        this.day_of_week = day_of_week;
        this.num_of_periods = num_of_periods;
        this.period = period;
        this.image = image;

        this.id = UUID.randomUUID().toString();
    }

    public Producte(ProducteDTO producteDTO){
        this.id = producteDTO.getId();
        this.name = producteDTO.getName();
        this.price = producteDTO.getPrice();
        this.measure_unit = producteDTO.getMeasure_unit();
        this.provider = producteDTO.getProvider();
        this.vat_type = producteDTO.getVat_type();
        this.category = producteDTO.getCategory();
        this.initial_date = producteDTO.getInitial_date();
        this.day_of_week = producteDTO.getDay_of_week();
        this.num_of_periods = producteDTO.getNum_of_periods();
        this.period = producteDTO.getPeriod();
        this.image = producteDTO.getImage();
    }

    //--------------------------------------------------------------------------------
    public String getMeasure_unit() {
        return measure_unit;
    }

    public void setMeasure_unit(String measure_unit) {
        this.measure_unit = measure_unit;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getVat_type() {
        return vat_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVat_type(String vat_type) {
        this.vat_type = vat_type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(Date initial_date) {
        this.initial_date = initial_date;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public int getNum_of_periods() {
        return num_of_periods;
    }

    public void setNum_of_periods(int num_of_periods) {
        this.num_of_periods = num_of_periods;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}

