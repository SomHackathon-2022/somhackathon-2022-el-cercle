package cat.tecnocampus.elcercle.application.dto;


import java.util.Date;

public class SubscripcioDTO{
    private String id;
    private String idProducte;
    private int quantitat;
    private String idMembre;
    private Date dataInici;
    private Date dataFi;
    private int esActiu;

    public SubscripcioDTO() {}

    public String getId() {
        return id;
    }

    public String getIdProducte() {
        return idProducte;
    }

    public String getIdMembre() {
        return idMembre;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdProducte(String idProducte) {
        this.idProducte = idProducte;
    }

    public void setIdMembre(String idMembre) {
        this.idMembre = idMembre;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public Date getDataInici() {
        return dataInici;
    }

    public void setDataInici(Date dataInici) {
        this.dataInici = dataInici;
    }

    public Date getDataFi() {
        return dataFi;
    }

    public void setDataFi(Date dataFi) {
        this.dataFi = dataFi;
    }

    public int getEsActiu() {
        return esActiu;
    }

    public void setEsActiu(int esActiu) {
        this.esActiu = esActiu;
    }
}