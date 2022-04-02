package cat.tecnocampus.elcercle.application;
import cat.tecnocampus.elcercle.application.daosInterface.IUsuariDAO;
import cat.tecnocampus.elcercle.application.dto.ComandaDTO;
import cat.tecnocampus.elcercle.application.dto.MembreDTO;
import cat.tecnocampus.elcercle.application.dto.SubscripcioDTO;
import cat.tecnocampus.elcercle.application.email.EmailClosedOrder;
import cat.tecnocampus.elcercle.application.email.EmailCreatedOrder;
import cat.tecnocampus.elcercle.application.email.EmailSentOrder;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ComandaController {
    IUsuariDAO usuari;
    EmailCreatedOrder senderOberta;
    EmailClosedOrder senderTancada;
    EmailSentOrder senderEnviada;

    public ComandaController(IUsuariDAO u, EmailCreatedOrder senderOberta, EmailClosedOrder senderTancada, EmailSentOrder senderEnviada){
        this.usuari = u;
        this.senderOberta = senderOberta;
        this.senderTancada = senderTancada;
        this.senderEnviada = senderEnviada;
    }

    private List<SubscripcioDTO> getSubcsripcionsActives() {
       List<SubscripcioDTO> llista = usuari.consultarSubscripcionsActives();
       return llista;
    }

    private List<ComandaDTO> getComandesObertes(){
        List<ComandaDTO> llista = usuari.consultarComandesObertes();
        return llista;
    }

    private List<ComandaDTO> getComandesTancades(){
        List<ComandaDTO> llista = usuari.consultarComandesTancades();
        return llista;
    }

    public void crearComandes() {
        getSubcsripcionsActives().stream()
            .forEach(subscripcio -> {
                usuari.ferComanda(subscripcio.getId());
                sendEmailOberta(subscripcio);
            });
    }

    public void tancarComandes() {
        getComandesObertes().stream()
            .forEach(comanda -> {
                usuari.tancarComanda(comanda.getId());
                sendEmailTancada(comanda);
            });
    }

    public void enviarComandes() {
        getComandesTancades().stream()
            .forEach(comandaT -> {
                usuari.enviarComanda(comandaT.getId());
                sendEmailEnviada(comandaT);
            });
    }

    private void sendEmailOberta(SubscripcioDTO subscripcio){
        MembreDTO membre = this.usuari.getMembre(subscripcio.getIdMembre());
        String producte = this.usuari.getNomProducteDeSubscripcio(subscripcio.getId());
        this.senderOberta.sendEmail(membre, producte);
    }

    private void sendEmailTancada(ComandaDTO comanda){
        SubscripcioDTO subscripcio = this.usuari.consultarSubscripcio(comanda.getIDSUBSCRIPCIO());
        MembreDTO membre = this.usuari.getMembre(subscripcio.getIdMembre());
        String producte = this.usuari.getNomProducteDeSubscripcio(subscripcio.getId());
        this.senderTancada.sendEmail(membre, producte);
    }

    private void sendEmailEnviada(ComandaDTO comanda){
        SubscripcioDTO subscripcio = this.usuari.consultarSubscripcio(comanda.getIDSUBSCRIPCIO());
        MembreDTO membre = this.usuari.getMembre(subscripcio.getIdMembre());
        String producte = this.usuari.getNomProducteDeSubscripcio(subscripcio.getId());
        this.senderEnviada.sendEmail(membre, producte);
    }

}
