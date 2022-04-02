package cat.tecnocampus.elcercle.application.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MembreDTO {

    @NotNull(message = "Nom no pot ser nul")
    @NotBlank(message = "Nom no pot ser buit")
    private String nom;

    @NotNull(message = "Cognom no pot ser nul")
    @NotBlank(message = "Cognom no pot ser buit")
    private String cognom1;

    @NotNull(message = "Cognom no pot ser nul")
    @NotBlank(message = "Cognom no pot ser buit")
    private String cognom2;

    private String id;

    @Pattern(regexp = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\\b",
            message = "Email must look like an email")
    @NotNull(message = "Correu no pot ser nul")
    @NotBlank(message = "Correu no pot ser buit")
    private String correu;

    @NotNull(message = "Adreça no pot ser nul")
    @NotBlank(message = "Adreça no pot ser buit")
    private String adreca;

    public MembreDTO() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }
}
