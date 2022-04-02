package cat.tecnocampus.elcercle.domain;

import cat.tecnocampus.elcercle.application.ProducteController;
import cat.tecnocampus.elcercle.application.daosInterface.IProducteDAO;
import cat.tecnocampus.elcercle.application.dto.SubscripcioDTO;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import static java.time.temporal.ChronoUnit.SECONDS;

public class Subscripcio {
    private String id;
    private String idProducte;
    private int quantitat;
    private String idMembre;
    private Date dataInici;
    private Date dataFi;
    private int esActiu;

    private IProducteDAO producteDAO;

    public Subscripcio(){

    }

    public Subscripcio(SubscripcioDTO subscripcioDTO, IProducteDAO producteDAO){
        this.id = subscripcioDTO.getId();
        this.idProducte = subscripcioDTO.getIdProducte();
        this.idMembre = subscripcioDTO.getIdMembre();
        this.quantitat = subscripcioDTO.getQuantitat();
        this.dataInici = subscripcioDTO.getDataInici();
        this.dataFi = subscripcioDTO.getDataFi();
        this.esActiu = subscripcioDTO.getEsActiu();

        this.producteDAO = producteDAO;
    }

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

    public boolean tocaGenerarComandaAquestaSetmana(){
        Producte producte = new Producte();
        try{
            producte = new Producte(ProducteController.getProducte(this.idProducte, this.producteDAO));
        } catch(Exception e){}

        long daysToNextOrder = getDaysDifference(this.dataInici) % (getDiesPeriode(producte) * producte.getNum_of_periods());
        // return daysToNextOrder > (producte.getDay_of_week() - currentDate.diaSetmana) && daysToNextOrder < 0;
        return daysToNextOrder < 7;
    }

    private int getDiesPeriode(Producte producte){
        switch (producte.getPeriod()){
            case "Day":
                return 1;
            case "Week":
                return 7;
            case "Month":
                return 30;
            case "Year":
                return 365;
            default:
                return 7;
        }
    }

    private long getDaysDifference(Date origin){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime before = origin.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        return ChronoUnit.DAYS.between(before, now);
    }
}