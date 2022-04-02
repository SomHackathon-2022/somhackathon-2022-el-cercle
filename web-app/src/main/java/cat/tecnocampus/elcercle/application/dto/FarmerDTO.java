package cat.tecnocampus.elcercle.application.dto;

import java.util.List;

public class FarmerDTO {
    private String id;
    private String name;
    private String address;
    private String email;
    private String dni;
    private List<ProductDTO> product;
    private List<OrganicLotDTO> received_organic_lots;

    public FarmerDTO(){}

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

    public List<ProductDTO> getProduct() {
        return product;
    }

    public void setProduct(List<ProductDTO> product) {
        this.product = product;
    }

    public List<OrganicLotDTO> getReceived_organic_lots() {
        return received_organic_lots;
    }

    public void setReceived_organic_lots(List<OrganicLotDTO> received_organic_lots) {
        this.received_organic_lots = received_organic_lots;
    }
}
