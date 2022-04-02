package cat.tecnocampus.elcercle.application.daosInterface;

import cat.tecnocampus.elcercle.application.dto.MembreDTO;
import cat.tecnocampus.elcercle.application.dto.AdministradorDTO;
import cat.tecnocampus.elcercle.application.dto.SubscripcioDTO;
import cat.tecnocampus.elcercle.application.dto.ComandaDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IUsuariDAO {

    public MembreDTO getMembre(String id);

    public AdministradorDTO getAdministrador(String id);

    public List<MembreDTO> getMembres();

    public List<AdministradorDTO> getAdministradors();

    public MembreDTO addMembre(MembreDTO membre);

    public AdministradorDTO addAdministrador(AdministradorDTO administrador);

    public void ferSubscripcio(String idMembre, String idProducte, int quantitat);

    public void ferComanda(String idSubscripcio);

    public void cancelarSubscripcio(String idSubscripcio);

    public List<SubscripcioDTO> consultarSubscripcions(String correu);

    public List<SubscripcioDTO> consultarSubscripcionsActives(String idMembre);

    public List<SubscripcioDTO> consultarSubscripcionsInactives(String idMembre);

    public List<SubscripcioDTO> consultarSubscripcionsActives();

    public List<SubscripcioDTO> consultarSubscripcionsDeProducte(String idProducte);

    public List<SubscripcioDTO> consultarSubscripcionsActivesDeProducte(String idProducte);

    public SubscripcioDTO consultarSubscripcio(String idSubscripció);

    public String consultarEmail(String idUsuari);

    public void modificarSubscripcio(String idSubscripcio, int quantitat);

    public void modificarComanda(String idComanda, int quantitat);

    public List<ComandaDTO> consultarComandes(String idMembre);

    public List<ComandaDTO> consultarComandesObertes(String idMembre);

    public List<ComandaDTO> consultarComandesTancades(String idMembre);

    public List<ComandaDTO> consultarComandesEnviades(String idMembre);

    public List<ComandaDTO> consultarComandes();

    public List<ComandaDTO> consultarComandesObertes();

    public List<ComandaDTO> consultarComandesTancades();

    public List<ComandaDTO> consultarComandesEnviades();

    public void obrirComanda(String idComanda);

    public void tancarComanda(String idComanda);

    public void enviarComanda(String idComanda);

    public ComandaDTO consultarComanda(String idComanda);

    public String getNomProducteDeSubscripcio(String idSubscripcio);

    public String getNomProducteDeComanda(String idComanda);

    public float getPreuProducteDeSubscripcio(String idSubscripcio);

    public float getPreuProducteDeComanda(String idComanda);

    public String getImatgeProducteDeSubscripcio(String idSubscripcio);

    public String getImatgeProducteDeComanda(String idComanda);

    public String getIdProducteDeComanda(String idComanda);

    public String getIdSubscripcio(String idMembre, String idProducte);

    public int getQuantitatSubscripcio(String idSubscripcio);

    public String getIdUsuari(String correu);

    public String getRol(String idUsuariQueEstaModificant);
}
