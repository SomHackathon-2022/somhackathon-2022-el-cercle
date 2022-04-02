package cat.tecnocampus.elcercle.application.dto;

import cat.tecnocampus.elcercle.domain.Comanda;

import java.util.Date;

public class ComandaDTO {
    private String id;
    private String IDSUBSCRIPCIO;
    private String idUsuari;
    private int quantitat;
    private int esOberta;
    private int esEnviada;
    private Date dataEntrega;

    public ComandaDTO() {}

    public ComandaDTO(Comanda com){
        this.id = com.getId();
        this.IDSUBSCRIPCIO = com.getIdSuscripcio();
        this.idUsuari = com.getIdUsuari();
        this.quantitat = com.getQuantitat();
        this.esOberta = com.isEsOberta();
        this.esEnviada = com.isEsEnviada();
    }
    /*public ComandaDTO(String idSuscripcio, String idMembre, int quantitat){
        this.id = UUID.randomUUID().toString();
        this.idSuscripcio = idSuscripcio;
        this.idMembre = idMembre;
        this.quantitat = quantitat;
        this.esOberta = 1;
        this.esEnviada = 0;
    }*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIDSUBSCRIPCIO() {
        return IDSUBSCRIPCIO;
    }

    public void setIDSUBSCRIPCIO(String IDSUBSCRIPCIO) {
        this.IDSUBSCRIPCIO = IDSUBSCRIPCIO;
    }

    public String getIdUsuari() {
        return idUsuari;
    }

    public void setIdMembre(String idMembre) {
        this.idUsuari = idMembre;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public int getEsOberta() {
        return esOberta;
    }

    public void setEsOberta(int esOberta) {
        this.esOberta = esOberta;
    }

    public int getEsEnviada() {
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
