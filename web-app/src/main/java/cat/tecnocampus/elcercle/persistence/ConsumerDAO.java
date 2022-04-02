package cat.tecnocampus.elcercle.persistence;

import cat.tecnocampus.elcercle.application.dto.ConsumerDTO;
import cat.tecnocampus.elcercle.application.exception.UsuariNotFoundException;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.simpleflatmapper.jdbc.spring.ResultSetExtractorImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumerDAO {
    private JdbcTemplate jdbcTemplate;
    public ResultSetExtractorImpl<ConsumerDTO> consumersRowMapper =
            JdbcTemplateMapperFactory
                    .newInstance()
                    .addKeys("id")
                    .newResultSetExtractor(ConsumerDTO.class);


    public ConsumerDTO get_consumer(String id) {
        final String queryMembres = "select u.nom, u.cognom1, u.cognom2, u.id, u.correu, u.adreca from ofc_users u join authorities a on a.id like u.id where a.id = ? and a.ROLE = ?";
        try {
            return jdbcTemplate.query(queryMembres, consumersRowMapper, id).get(0);
        } catch (EmptyResultDataAccessException e) {
            throw new UsuariNotFoundException(id);
        }
    }
}
