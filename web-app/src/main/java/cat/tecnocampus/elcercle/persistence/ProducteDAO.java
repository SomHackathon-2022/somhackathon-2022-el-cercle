package cat.tecnocampus.elcercle.persistence;

import cat.tecnocampus.elcercle.application.daosInterface.IProducteDAO;
import cat.tecnocampus.elcercle.application.dto.ProducteDTO;
import cat.tecnocampus.elcercle.application.exception.ProducteNotFoundException;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.simpleflatmapper.jdbc.spring.ResultSetExtractorImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProducteDAO implements IProducteDAO {

    private JdbcTemplate jdbcTemplate;
    public ProducteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ResultSetExtractorImpl<ProducteDTO> productesRowMapper =
            JdbcTemplateMapperFactory
                    .newInstance()
                    .addKeys("id")
                    .newResultSetExtractor(ProducteDTO.class);

    @Override
    public ProducteDTO getProducte(String id) throws Exception {
        final String queryProducte = "select id, name, price, measure_unit, provider, vat_type, category, initial_date, day_of_week, num_of_periods, period, image from product where id = ?";
        try {
            return jdbcTemplate.query(queryProducte, productesRowMapper, id).get(0);
        } catch (EmptyResultDataAccessException e) {
            throw new ProducteNotFoundException(id);
        }
    }

    @Override
    public List<ProducteDTO> getProductes() {
        final String queryProducte = "select id, name, price, measure_unit, provider, vat_type, category, initial_date, day_of_week, num_of_periods, period, image from product";
        return jdbcTemplate.query(queryProducte, productesRowMapper);
    }

    @Override
    public void updatePreus(ProducteDTO[] productesDTO) {
        for(ProducteDTO producteDTO : productesDTO){
            String queryProducte = "update product set price = trunc(?, 2) where id = ?";
            jdbcTemplate.update(queryProducte, producteDTO.getPrice(), producteDTO.getId());
        }
    }
}

