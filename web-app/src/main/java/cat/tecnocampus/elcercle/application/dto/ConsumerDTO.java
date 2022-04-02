package cat.tecnocampus.elcercle.application.dto;

import cat.tecnocampus.elcercle.domain.Consumer;

import java.util.List;

public class ConsumerDTO {
    private String id;
    private String name;
    private String address;
    private String email;
    private String dni;
    private List<OrganicLotDTO> organic_lots;

    public ConsumerDTO(){};

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

    public List<OrganicLotDTO> getOrganic_lots() {
        return organic_lots;
    }

    public void setOrganic_lots(List<OrganicLotDTO> organic_lots) {
        this.organic_lots = organic_lots;
    }
}
