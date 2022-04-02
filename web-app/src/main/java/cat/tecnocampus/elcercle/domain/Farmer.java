package cat.tecnocampus.elcercle.domain;

import java.util.List;

public class Farmer {
    private String id;
    private String name;
    private String address;
    private String email;
    private String dni;
    private List<Product> product;
    private List<OrganicLot> received_organic_lots;

    public void deliver_lot(OrganicLot organic_lot){
        this.received_organic_lots.add(organic_lot);
    }
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public List<OrganicLot> getReceived_organic_lots() {
        return received_organic_lots;
    }

    public void setReceived_organic_lots(List<OrganicLot> received_organic_lots) {
        this.received_organic_lots = received_organic_lots;
    }
}
