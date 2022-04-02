package cat.tecnocampus.elcercle.persistence;

import cat.tecnocampus.elcercle.application.daosInterface.IUsuariDAO;
import cat.tecnocampus.elcercle.application.dto.AdministradorDTO;
import cat.tecnocampus.elcercle.application.dto.ComandaDTO;
import cat.tecnocampus.elcercle.application.dto.MembreDTO;
import cat.tecnocampus.elcercle.application.dto.SubscripcioDTO;
import cat.tecnocampus.elcercle.application.exception.UsuariNotFoundException;
import cat.tecnocampus.elcercle.domain.Administrador;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.simpleflatmapper.jdbc.spring.ResultSetExtractorImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Repository //@Component
public class UsuariDAO implements IUsuariDAO {
    private JdbcTemplate jdbcTemplate;
    private final String rolAdmin = "ROL_ADMINISTRADOR";
    private final String rolMembre = "ROL_MEMBRE";

    public UsuariDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ResultSetExtractorImpl<MembreDTO> membresRowMapper =
            JdbcTemplateMapperFactory
                    .newInstance()
                    .addKeys("id")
                    .newResultSetExtractor(MembreDTO.class);

    public ResultSetExtractorImpl<AdministradorDTO> administradorsRowMapper =
            JdbcTemplateMapperFactory
                    .newInstance()
                    .addKeys("id")
                    .newResultSetExtractor(AdministradorDTO.class);

    public ResultSetExtractorImpl<SubscripcioDTO> subscripcionsRowMapper =
            JdbcTemplateMapperFactory
                    .newInstance()
                    .addKeys("id")
                    .newResultSetExtractor(SubscripcioDTO.class);

    public ResultSetExtractorImpl<ComandaDTO> comandesRowMapper =
            JdbcTemplateMapperFactory
                    .newInstance()
                    .addKeys("id")
                    .newResultSetExtractor(ComandaDTO.class);

    @Override
    public MembreDTO getMembre(String id) {
        final String queryMembres = "select u.nom, u.cognom1, u.cognom2, u.id, u.correu, u.adreca from ofc_users u join authorities a on a.id like u.id where a.id = ? and a.ROLE = ?";
        try {
            return jdbcTemplate.query(queryMembres, membresRowMapper, id, rolMembre).get(0);
        } catch (EmptyResultDataAccessException e) {
            throw new UsuariNotFoundException(id);
        }
    }

    @Override
    public AdministradorDTO getAdministrador(String id) {
        final String queryAdministradors = "select u.nom, u.cognom1, u.cognom2, u.id, u.correu, u.adreca from ofc_users u join authorities a on a.id like u.id where a.id = ? and a.ROLE = ?";
        try {
            return jdbcTemplate.query(queryAdministradors, administradorsRowMapper, id, rolAdmin).get(0);
        } catch (EmptyResultDataAccessException e) {
            throw new UsuariNotFoundException(id);
        }
    }

    @Override
    public List<MembreDTO> getMembres() {
        final String queryMembres = "select u.nom, u.cognom1, u.cognom2, u.id, u.correu, u.adreca from ofc_users u join authorities a on a.id like u.id where a.ROLE = ?";
        return jdbcTemplate.query(queryMembres, membresRowMapper, rolMembre);
    }

    @Override
    public List<AdministradorDTO> getAdministradors() {
        final String queryAdministradors = "select u.nom, u.cognom1, u.cognom2, u.id, u.correu, u.adreca from ofc_users u join authorities a on a.id like u.id where a.ROLE = ?";
        return jdbcTemplate.query(queryAdministradors, administradorsRowMapper, rolAdmin);
    }

    @Override
    public MembreDTO addMembre(MembreDTO membre) {
        final String insertMembre = "INSERT INTO ofc_users (nom, cognom1, cognom2, id, correu, adreca) VALUES (?, ?, ?, ?, ?, ?)";
        final String insertMembreAuthority = "INSERT INTO authorities (id, username, role) VALUES (?, ?, ?)";

        jdbcTemplate.update(insertMembre, membre.getNom(), membre.getCognom1(), membre.getCognom2(), membre.getId(), membre.getCorreu(), membre.getAdreca());
        jdbcTemplate.update(insertMembreAuthority, membre.getId(),membre.getCorreu(),rolMembre);

        return this.getMembre(membre.getId());
    }

    @Override
    public AdministradorDTO addAdministrador(AdministradorDTO administrador) {
        final String insertAdministrador = "INSERT INTO ofc_administradors (nom, cognom1, cognom2, id, correu, adreca) VALUES (?, ?, ?, ?, ?, ?)";
        final String insertAdministradorAuthority = "INSERT INTO authorities (id, username, role) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertAdministrador, administrador.getNom(), administrador.getCognom1(), administrador.getCognom2(), administrador.getId(), administrador.getCorreu(), administrador.getAdreca());
        jdbcTemplate.update(insertAdministradorAuthority, administrador.getId(), administrador.getCorreu(),rolAdmin);

        return this.getAdministrador(administrador.getId());
    }

    @Override
    public void ferSubscripcio(String idUsuari, String idProducte, int quantitat) {
        final String insertSubscripcio = "INSERT INTO ofc_subscripcions (id, idproducte, quantitat, idUsuari, datainici, datafi, esactiu) VALUES (?, ?, ?, ?, SYSDATE, ?, ?)";
        jdbcTemplate.update(insertSubscripcio, UUID.randomUUID().toString(), idProducte, quantitat, idUsuari, null, 1);
    }

    @Override
    public void ferComanda(String idSubscripcio) {
        SubscripcioDTO subscripcioDTO = this.consultarSubscripcio(idSubscripcio);

        final String insertComanda = "INSERT INTO ofc_comandes (id, idsubscripcio, idUsuari, quantitat, esoberta, esenviada, dataentrega) VALUES (?, ?, ?, ?, ?, ?, SYSDATE + 10)";
        jdbcTemplate.update(insertComanda, UUID.randomUUID().toString(), idSubscripcio, subscripcioDTO.getIdMembre(), subscripcioDTO.getQuantitat(), false, false);
    }

    @Override
    public void cancelarSubscripcio(String idSubscripcio) {
        final String updateSubscripcio = "UPDATE ofc_subscripcions SET datafi = SYSDATE, esactiu = 0 WHERE id LIKE ?";
        jdbcTemplate.update(updateSubscripcio, idSubscripcio);
    }

    @Override
    public void modificarSubscripcio(String idSubscripcio, int quantitat) {
        final String updateSubscripcio = "UPDATE ofc_subscripcions SET quantitat = ? WHERE id LIKE ?";
        jdbcTemplate.update(updateSubscripcio, quantitat, idSubscripcio);
    }

    @Override
    public List<SubscripcioDTO> consultarSubscripcions(String correu) {
        final String querySubscripcions = "select s.id as id, s.idproducte as idProducte, s.quantitat as quantitat, s.idUsuari as idMembre, s.datainici as datainici, s.datafi as datafi, s.esactiu as esactiu " +
                "from ofc_subscripcions s " +
                "join ofc_users u on s.idUsuari LIKE u.id " +
                "where u.correu LIKE ?;";

        List<SubscripcioDTO> result;
        result = jdbcTemplate.query(querySubscripcions, subscripcionsRowMapper, correu);
        return result;
    }

    @Override
    public List<SubscripcioDTO> consultarSubscripcionsActives(String correu) {
        final String querySubscripcions = "select s.id as id, s.idproducte as idProducte, s.quantitat as quantitat, s.idUsuari as idMembre, s.datainici as datainici, s.datafi as datafi, s.esactiu as esactiu " +
                "from ofc_subscripcions s " +
                "join ofc_users u on s.idUsuari LIKE u.id " +
                "where u.correu LIKE ?;";

        List<SubscripcioDTO> result;
        result = jdbcTemplate.query(querySubscripcions, subscripcionsRowMapper, correu);
        return result;
    }

    @Override
    public List<SubscripcioDTO> consultarSubscripcionsInactives(String correu) {
        final String querySubscripcions = "select s.id as id, s.idproducte as idProducte, s.quantitat as quantitat, s.idUsuari as idMembre, s.datainici as datainici, s.datafi as datafi, s.esactiu as esactiu " +
                "from ofc_subscripcions s " +
                "join ofc_users u on s.idUsuari LIKE u.id " +
                "where u.correu LIKE ?;";

        List<SubscripcioDTO> result;
        result = jdbcTemplate.query(querySubscripcions, subscripcionsRowMapper, correu);
        return result;
    }

    @Override
    public List<SubscripcioDTO> consultarSubscripcionsActives() {
        final String querySubscripcions = "select s.id as id, s.idproducte as idProducte, s.quantitat as quantitat, s.idUsuari as idMembre, s.datainici as datainici, s.datafi as datafi, s.esactiu as esactiu " +
                "from ofc_subscripcions s " +
                "where s.esactiu LIKE 1;";
        List<SubscripcioDTO> result;
        result = jdbcTemplate.query(querySubscripcions, subscripcionsRowMapper);
        return result;
    }

    @Override
    public SubscripcioDTO consultarSubscripcio(String idSubscripcio) {
        final String querySubscripcions = "select s.id as id, s.idproducte as idProducte, s.quantitat as quantitat, s.idUsuari as idMembre, s.datainici as datainici, s.datafi as datafi, s.esactiu as esactiu " +
                "from ofc_subscripcions s " +
                "where s.id LIKE ?;";

        SubscripcioDTO result;
        result = jdbcTemplate.query(querySubscripcions, subscripcionsRowMapper, idSubscripcio).get(0);
        return result;
    }

    @Override
    public List<SubscripcioDTO> consultarSubscripcionsDeProducte(String idProducte) {
        final String querySubscripcions = "select s.id as id, s.idproducte as idProducte, s.quantitat as quantitat, s.idUsuari as idMembre, s.datainici as datainici, s.datafi as datafi, s.esactiu as esactiu " +
                "from ofc_subscripcions s " +
                "where s.idProducte LIKE ?;";

        List<SubscripcioDTO> result;
        result = jdbcTemplate.query(querySubscripcions, subscripcionsRowMapper, idProducte);
        return result;
    }

    @Override
    public List<SubscripcioDTO> consultarSubscripcionsActivesDeProducte(String idProducte) {
        final String querySubscripcions = "select s.id as id, s.idproducte as idProducte, s.quantitat as quantitat, s.idUsuari as idMembre, s.datainici as datainici, s.datafi as datafi, s.esactiu as esactiu " +
                "from ofc_subscripcions s " +
                "where s.idProducte LIKE ? and s.esactiu LIKE 1;";

        List<SubscripcioDTO> result;
        result = jdbcTemplate.query(querySubscripcions, subscripcionsRowMapper, idProducte);
        return result;
    }

    @Override
    public List<ComandaDTO> consultarComandes(String correu) {
        final String queryComandes = "select c.id as id, c.idsubscripcio as idSubscripcio, c.idUsuari as idMembre, c.quantitat as quantitat, c.esoberta as esOberta, c.esenviada as esEnviada, c.dataentrega as dataEntrega " +
                "from ofc_comandes c " +
                "join ofc_subscripcions s on c.idSubscripcio LIKE s.id " +
                "join ofc_users u on s.idUsuari LIKE u.id " +
                "where u.correu LIKE ?;";

        List<ComandaDTO> result;
        result = jdbcTemplate.query(queryComandes, comandesRowMapper, correu);
        return result;
    }

    @Override
    public List<ComandaDTO> consultarComandes() {
        final String queryComandes = "select c.id as id, c.idsubscripcio as idSubscripcio, c.idUsuari as idMembre, c.quantitat as quantitat, c.esoberta as esOberta, c.esenviada as esEnviada, c.dataentrega as dataEntrega " +
                "from ofc_comandes c " +
                "join ofc_subscripcions s on c.idSubscripcio LIKE s.id " +
                "join ofc_users u on s.idUsuari LIKE u.id ";

        List<ComandaDTO> result;
        result = jdbcTemplate.query(queryComandes, comandesRowMapper);
        return result;
    }

    @Override
    public List<ComandaDTO> consultarComandesObertes(String idMembre) {
        final String queryComandes = "select c.id as id, c.idsubscripcio as idSubscripcio, c.idUsuari as idMembre, c.quantitat as quantitat, c.esoberta as esOberta, c.esenviada as esEnviada, c.dataentrega as dataEntrega " +
                "from ofc_comandes c " +
                "where c.idmembre LIKE ? " +
                "and c.esOberta LIKE 1;";

        List<ComandaDTO> result;
        result = jdbcTemplate.query(queryComandes, comandesRowMapper, idMembre);
        return result;
    }

    @Override
    public List<ComandaDTO> consultarComandesTancades(String idUsuari) {
        final String queryComandes = "select c.id as id, c.idsubscripcio as idSubscripcio, c.idUsuari as idMembre, c.quantitat as quantitat, c.esoberta as esOberta, c.esenviada as esEnviada, c.dataentrega as dataEntrega " +
                "from ofc_comandes c " +
                "where c.idUsuari LIKE ? " +
                "and c.esOberta LIKE 0;";

        List<ComandaDTO> result;
        result = jdbcTemplate.query(queryComandes, comandesRowMapper, idUsuari);
        return result;
    }

    @Override
    public List<ComandaDTO> consultarComandesEnviades(String idUsuari) {
        final String queryComandes = "select c.id as id, c.idsubscripcio as idSubscripcio, c.idUsuari as idMembre, c.quantitat as quantitat, c.esoberta as esOberta, c.esenviada as esEnviada, c.dataentrega as dataEntrega " +
                "from ofc_comandes c " +
                "where c.idUsuari LIKE ? " +
                "and c.esEnviada LIKE 1;";

        List<ComandaDTO> result;
        result = jdbcTemplate.query(queryComandes, comandesRowMapper, idUsuari);
        return result;
    }

    @Override
    public List<ComandaDTO> consultarComandesObertes() {
        final String queryComandes = "select c.id as id, c.idsubscripcio as idSubscripcio, c.idUsuari as idMembre, c.quantitat as quantitat, c.esoberta as esOberta, c.esenviada as esEnviada, c.dataentrega as dataEntrega " +
                "from ofc_comandes c " +
                "where c.esOberta LIKE 1;";

        List<ComandaDTO> result;
        result = jdbcTemplate.query(queryComandes, comandesRowMapper);
        return result;
    }

    @Override
    public List<ComandaDTO> consultarComandesTancades() {
        final String queryComandes = "select c.id as id, c.idsubscripcio as idSubscripcio, c.idUsuari as idMembre, c.quantitat as quantitat, c.esoberta as esOberta, c.esenviada as esEnviada, c.dataentrega as dataEntrega " +
                "from ofc_comandes c " +
                "where c.esOberta LIKE 0;";

        List<ComandaDTO> result;
        result = jdbcTemplate.query(queryComandes, comandesRowMapper);
        return result;
    }

    @Override
    public List<ComandaDTO> consultarComandesEnviades() {
        final String queryComandes = "select c.id as id, c.idsubscripcio as idSubscripcio, c.idUsuari as idMembre, c.quantitat as quantitat, c.esoberta as esOberta, c.esenviada as esEnviada, c.dataentrega as dataEntrega " +
                "from ofc_comandes c " +
                "where c.esEnviada LIKE 1;";

        List<ComandaDTO> result;
        result = jdbcTemplate.query(queryComandes, comandesRowMapper);
        return result;
    }

    @Override
    public void obrirComanda(String idComanda) {
        String queryComanda = "update ofc_comandes set esOberta = 1 where id = ?";
        jdbcTemplate.update(queryComanda, comandesRowMapper, idComanda);
    }

    @Override
    public void tancarComanda(String idComanda) {
        String queryComanda = "update ofc_comandes set esOberta = 0 where id = ?";
        jdbcTemplate.update(queryComanda, idComanda);
    }

    @Override
    public void enviarComanda(String idComanda) {
        String queryComanda = "update ofc_comandes set esEnviada = 1 where id = ?";
        jdbcTemplate.update(queryComanda, idComanda);
    }

    @Override
    public ComandaDTO consultarComanda(String idComanda) {
        final String queryComandes = "select c.id as id, c.idsubscripcio as idSubscripcio, c.idUsuari as idMembre, c.quantitat as quantitat, c.esoberta as esOberta, c.esenviada as esEnviada, c.dataentrega as dataEntrega " +
                "from ofc_comandes c " +
                "where c.id LIKE ?";

        ComandaDTO result;
        result = jdbcTemplate.query(queryComandes, comandesRowMapper, idComanda).get(0);
        return result;
    }

    @Override
	public String consultarEmail(String idUsuari){
        final String queryComandes = "select correu " +
                "from ofc_usuaris c " +
                "where c.id LIKE ?";
        return (String) jdbcTemplate.queryForObject(queryComandes, new Object[]{idUsuari}, String.class);
    }

    @Override
    public void modificarComanda(String idComanda, int quantitat) {
        final String updateComanda = "UPDATE ofc_comandes SET quantitat = ? WHERE id LIKE ? ";
        jdbcTemplate.update(updateComanda, quantitat, idComanda);
    }

    @Override
    public String getNomProducteDeSubscripcio(String idSubscripcio) {
        final String queryNom = "SELECT p.name FROM product p JOIN ofc_subscripcions s ON p.id LIKE s.idproducte WHERE s.id LIKE ?";
        return (String) jdbcTemplate.queryForObject(queryNom, new Object[] {idSubscripcio}, String.class);
    }

    @Override
    public String getNomProducteDeComanda(String idComanda) {
        final String queryNom = "SELECT p.name FROM product p JOIN ofc_subscripcions s ON p.id LIKE s.idproducte JOIN ofc_comandes c ON s.id LIKE c.idSubscripcio WHERE c.id LIKE ?";
        return (String) jdbcTemplate.queryForObject(queryNom, new Object[] {idComanda}, String.class);
    }

    @Override
    public float getPreuProducteDeSubscripcio(String idSubscripcio) {
        final String queryPreu = "SELECT p.price FROM product p JOIN ofc_subscripcions s ON p.id LIKE s.idproducte WHERE s.id LIKE ?";
        return (float) jdbcTemplate.queryForObject(queryPreu, new Object[] {idSubscripcio}, float.class);
    }

    @Override
    public float getPreuProducteDeComanda(String idComanda) {
        final String queryPreu = "SELECT p.price FROM product p JOIN ofc_subscripcions s ON p.id LIKE s.idproducte JOIN ofc_comandes c ON s.id LIKE c.idSubscripcio WHERE c.id LIKE ?";
        return (float) jdbcTemplate.queryForObject(queryPreu, new Object[] {idComanda}, float.class);
    }

    @Override
    public String getImatgeProducteDeSubscripcio(String idSubscripcio) {
        final String queryImatge = "SELECT p.image FROM product p JOIN ofc_subscripcions s ON p.id LIKE s.idproducte WHERE s.id LIKE ?";
        return (String) jdbcTemplate.queryForObject(queryImatge, new Object[] {idSubscripcio}, String.class);
    }

    @Override
    public String getImatgeProducteDeComanda(String idComanda) {
        final String queryImatge = "SELECT p.image FROM product p JOIN ofc_subscripcions s ON p.id LIKE s.idproducte JOIN ofc_comandes c ON s.id LIKE c.idSubscripcio WHERE c.id LIKE ?";
        return (String) jdbcTemplate.queryForObject(queryImatge, new Object[] {idComanda}, String.class);
    }

    @Override
    public String getIdProducteDeComanda(String idComanda) {
        final String queryId = "SELECT s.idproducte FROM  ofc_subscripcions s JOIN ofc_comandes c ON s.id LIKE c.idSubscripcio WHERE c.id LIKE ?";
        return (String) jdbcTemplate.queryForObject(queryId, new Object[] {idComanda}, String.class);
    }

    @Override
    public String getIdSubscripcio(String correu, String idProducte){
        final String queryId = "SELECT s.id FROM ofc_subscripcions s JOIN ofc_users u on s.idUsuari LIKE u.id WHERE s.idProducte LIKE ? AND u.correu LIKE ? AND s.esActiu LIKE 1";
        return (String) jdbcTemplate.queryForObject(queryId, new Object[] {idProducte, correu}, String.class);
    }

    @Override
    public int getQuantitatSubscripcio(String idSubscripcio){
        final String queryQuantitat = "SELECT s.quantitat FROM ofc_subscripcions s WHERE s.id LIKE ?";
        return (int) jdbcTemplate.queryForObject(queryQuantitat, new Object[] {idSubscripcio}, int.class);
    }

    @Override
    public String getIdUsuari(String correu){
        final String queryId = "SELECT u.id FROM ofc_users u WHERE u.correu LIKE ?";
        return (String) jdbcTemplate.queryForObject(queryId, new Object[]{correu}, String.class);
    }

    @Override
    public String getRol(String idUsuariQueEstaModificant) {
        final String queryRol = "SELECT s.role FROM authorities s WHERE s.id LIKE ?";
        return (String) jdbcTemplate.queryForObject(queryRol, new Object[] {idUsuariQueEstaModificant}, String.class);
    }
}
