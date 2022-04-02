package cat.tecnocampus.elcercle.application.dto;


import cat.tecnocampus.elcercle.domain.Producte;

import java.util.Date;
import java.util.UUID;

public class ProducteDTO {
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

    public ProducteDTO(){}

    public ProducteDTO(Producte producte){
        this.id = producte.getId();
        this.name = producte.getName();
        this.price = producte.getPrice();
        this.measure_unit = producte.getMeasure_unit();
        this.provider = producte.getProvider();
        this.vat_type = producte.getVat_type();
        this.category = producte.getCategory();
        this.initial_date = producte.getInitial_date();
        this.day_of_week = producte.getDay_of_week();
        this.num_of_periods = producte.getNum_of_periods();
        this.period = producte.getPeriod();
        this.image = producte.getImage();
    }

    private ProducteDTO(String name, double price, String measure_unit, String provider, String vat_type, String category,  Date initial_date, String day_of_week, int num_of_periods, String period, String image) {
        this.id = UUID.randomUUID().toString();
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
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getMeasure_unit() {
        return measure_unit;
    }

    public String getProvider() {
        return provider;
    }

    public String getVat_type() {
        return vat_type;
    }

    public String getCategory() {
        return category;
    }

    public Date getInitial_date() {
        return initial_date;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public int getNum_of_periods() {
        return num_of_periods;
    }

    public String getPeriod() {
        return period;
    }

    public String getImage() {
        return image;
    }

    public static ProducteDTO getEmpty()
    {
        return new ProducteDTO("N/A name", 0, "N/A measure unit", "N/A provider", "N/A var_type", "N/A category", null, "N/A day", 0, "N/A period", "N/A image");
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMeasure_unit(String measure_unit) {
        this.measure_unit = measure_unit;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setVat_type(String vat_type) {
        this.vat_type = vat_type;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setInitial_date(Date initial_date) {
        this.initial_date = initial_date;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public void setNum_of_periods(int num_of_periods) {
        this.num_of_periods = num_of_periods;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setImage(String image) {
        this.image = image;
    }
}