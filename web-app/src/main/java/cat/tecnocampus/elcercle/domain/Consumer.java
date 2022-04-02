package cat.tecnocampus.elcercle.domain;

import java.util.List;

public class Consumer {
    private String id;
    private String name;
    private String address;
    private String email;
    private String dni;
    private List<OrganicLot> organic_lots;

    public double order_and_get_price(Product product, List<OrganicLot> discounts){
        double discount_amount = 0;
        for (OrganicLot discount: discounts) {
            discount_amount += discount.get_discount();
        }
        double final_price = product.getPrice() - discount_amount;
        if (final_price< 0 )
            return 0;
        return final_price;
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

    public List<OrganicLot> getOrganic_lots() {
        return organic_lots;
    }

    public void setOrganic_lots(List<OrganicLot> organic_lots) {
        this.organic_lots = organic_lots;
    }
}
