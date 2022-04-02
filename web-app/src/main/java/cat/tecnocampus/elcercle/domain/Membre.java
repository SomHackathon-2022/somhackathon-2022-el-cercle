package cat.tecnocampus.elcercle.domain;

import cat.tecnocampus.elcercle.application.dto.MembreDTO;

import java.util.List;

public class Membre extends Usuari{

    public Membre(MembreDTO membreDTO){
        this.nom = membreDTO.getNom();
        this.cognom1 = membreDTO.getCognom1();
        this.cognom2 = membreDTO.getCognom2();
        this.id = membreDTO.getId();
        this.correu = membreDTO.getCorreu();
        this.adreca = membreDTO.getAdreca();
    }

    public boolean ferSubscripció(String idProducte, int quantitat){

        return false;
    }
    public boolean cancelarSubscripcio(String idSubscripcio) {

        return false;
    }
    public boolean modificarSubscripcio(String idSubscripcio, int quantitat){

        return false;
    }
    public void consultarSubscripcions(){

    }
    public Subscripcio consultarSubscripcio(String idSubscripcio){

        return null;
    }

}

