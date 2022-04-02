package cat.tecnocampus.elcercle.application;
import cat.tecnocampus.elcercle.application.dto.ComandaDTO;
import cat.tecnocampus.elcercle.application.dto.MembreDTO;
import cat.tecnocampus.elcercle.application.dto.SubscripcioDTO;
import cat.tecnocampus.elcercle.application.daosInterface.IUsuariDAO;
import cat.tecnocampus.elcercle.application.exception.ActionNonPermitedException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Component
public class MembreController{
    IUsuariDAO usuariDAO;

    public MembreController(IUsuariDAO usuariDAO){this.usuariDAO = usuariDAO;}

    public MembreDTO getMembre(String id){
        return usuariDAO.getMembre(id);

    }
    public List<MembreDTO> getMembres(){
        return usuariDAO.getMembres();
    }

    public MembreDTO addMembre(MembreDTO membre){
        return usuariDAO.addMembre(membre);
    }

    public void ferSubscripcio(String idProducte, int quantitat, String correu){
        String idUsuari = usuariDAO.getIdUsuari(correu);
        usuariDAO.ferSubscripcio(idUsuari, idProducte, quantitat);
    }
    public void cancelarSubscripcio(String idSubscripcio){
        usuariDAO.cancelarSubscripcio(idSubscripcio);
    }
    public void modificarSubscripcio(String idSubscripcio, int quantitat, String idUsuariQueEstaModificant){
        usuariDAO.modificarSubscripcio(idSubscripcio, quantitat);
    }

    public List<SubscripcioDTO> consultarSubscripcions(String correu){
        return usuariDAO.consultarSubscripcions(correu);
    }

    public List<SubscripcioDTO> consultarSubscripcionsActives(String correu){
        return usuariDAO.consultarSubscripcionsActives(correu);
    }

    public List<SubscripcioDTO> consultarSubscripcionsActives(){
        return usuariDAO.consultarSubscripcionsActives();
    }

    public List<SubscripcioDTO> consultarSubscripcionsInactives(String correu){
        return usuariDAO.consultarSubscripcionsInactives(correu);
    }

    public ComandaDTO consultarComanda(String idComanda) { return usuariDAO.consultarComanda(idComanda);}
    public List<ComandaDTO> consultarComandes(String correu){
        return usuariDAO.consultarComandes(correu);
    }

    public void modificarComanda (String idComanda, int quantitat, String idUsuariQueEstaModificant){
        if(usuariDAO.consultarComanda(idComanda).getEsOberta() == 1)
            usuariDAO.modificarComanda(idComanda, quantitat);
        else if(usuariDAO.consultarComanda(idComanda).getEsOberta() == 0){
            if(usuariDAO.getRol(idUsuariQueEstaModificant) == "ROL_ADMINTRADOR")
                usuariDAO.modificarComanda(idComanda, quantitat);
            else
                throw new ActionNonPermitedException();
        }
        else if(usuariDAO.consultarComanda(idComanda).getEsEnviada() == 1){
            throw new ActionNonPermitedException();
        }



    }

    /*public List<SubscripcioDTO> consultarSubscripcions();
    public SubscripcioDTO consultarSubscripcio(String idSubscripcio);
    public List<ComandaDTO> consultarComandes();
    public List<ComandaDTO> consultarComandesObertes();
    public ComandaDTO consultarComanda(String idComanda);

    public void modificarComanda(String idComanda, int quantitat);*/


    public String getNomProducteDeSubscripcio(String idSubscripcio) {
        return usuariDAO.getNomProducteDeSubscripcio(idSubscripcio);
    }

    public String getNomProducteDeComanda(String idComanda) {
        return usuariDAO.getNomProducteDeComanda(idComanda);
    }

    public float getPreuProducteDeSubscripcio(String idSubscripcio) {
        return usuariDAO.getPreuProducteDeSubscripcio(idSubscripcio);
    }

    public float getPreuProducteDeComanda(String idComanda) {
        return usuariDAO.getPreuProducteDeComanda(idComanda);
    }

    public String getImatgeProducteDeSubscripcio(String idSubscripcio) {
        return usuariDAO.getImatgeProducteDeSubscripcio(idSubscripcio);
    }

    public String getImatgeProducteDeComanda(String idComanda) {
        return usuariDAO.getImatgeProducteDeComanda(idComanda);
    }

    public String getIdProducteDeComanda(String idComanda) {
        return usuariDAO.getIdProducteDeComanda(idComanda);
    }

    public String getIdSubscripcio(String correu, String idProducte){
        return usuariDAO.getIdSubscripcio(correu, idProducte);
    }

    public int getQuantitatSubscripcio(String idSubscripcio){
        return usuariDAO.getQuantitatSubscripcio(idSubscripcio);
    }

    public String getIdUsuari(String correu) {
        return usuariDAO.getIdUsuari(correu);
    }
}