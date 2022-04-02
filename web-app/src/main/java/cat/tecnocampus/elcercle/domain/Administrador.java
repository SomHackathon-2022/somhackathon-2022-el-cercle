package cat.tecnocampus.elcercle.domain;

import cat.tecnocampus.elcercle.application.dto.AdministradorDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Administrador extends Usuari{

    public Administrador(AdministradorDTO administradorDTO){
        this.nom = administradorDTO.getNom();
        this.cognom1 = administradorDTO.getCognom1();
        this.cognom2 = administradorDTO.getCognom2();
        this.id = administradorDTO.getId();
        this.correu = administradorDTO.getCorreu();
        this.adreca = administradorDTO.getAdreca();
    }

    @Override
    public void consultarSubscripcions() {

    }

}