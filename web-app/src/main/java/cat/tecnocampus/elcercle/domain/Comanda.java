package cat.tecnocampus.elcercle.domain;

import cat.tecnocampus.elcercle.application.dto.ComandaDTO;

import java.util.Date;
import java.util.UUID;

public class Comanda{

    private String id;
    private String idSuscripcio;
    private String idUsuari;
    private int quantitat;
    private int esOberta;
    private int esEnviada;
    private Date dataEntrega;

    public Comanda(String idSuscripcio, String idMembre, int quantitat){
        this.id = UUID.randomUUID().toString();
        this.idSuscripcio = idSuscripcio;
        this.idUsuari = idMembre;
        this.quantitat = quantitat;
        this.esOberta = 1; //TODO
        this.esEnviada = 0;
    }

    public Comanda(ComandaDTO comandaDTO){
        this.id = comandaDTO.getId();
        this.idSuscripcio = comandaDTO.getIDSUBSCRIPCIO();
        this.idUsuari = comandaDTO.getIdUsuari();
        this.quantitat = comandaDTO.getQuantitat();
        this.esOberta = comandaDTO.getEsOberta();
        this.esEnviada = comandaDTO.getEsEnviada();
        this.dataEntrega = comandaDTO.getDataEntrega();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSuscripcio() {
        return idSuscripcio;
    }

    public void setIdSuscripcio(String idSuscripcio) {
        this.idSuscripcio = idSuscripcio;
    }

    public String getIdUsuari() {
        return idUsuari;
    }

    public void setIdMembre(String idUsuari) {
        this.idUsuari = idUsuari;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public int isEsOberta() {
        return esOberta;
    }

    public void setEsOberta(int esOberta) {
        this.esOberta = esOberta;
    }
    
    public int isEsEnviada() {
        return esEnviada;
    }

    public void setEsEnviada(int esEnviada) {
        this.esEnviada = esEnviada;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}