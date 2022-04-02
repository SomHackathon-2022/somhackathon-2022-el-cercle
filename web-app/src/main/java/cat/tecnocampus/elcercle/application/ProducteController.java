package cat.tecnocampus.elcercle.application;

import cat.tecnocampus.elcercle.application.daosInterface.IProducteDAO;
import cat.tecnocampus.elcercle.application.dto.ProducteDTO;
import cat.tecnocampus.elcercle.utilities.Parameters;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProducteController {
    private final RestTemplate restTemplate;
    private IProducteDAO producteDAO;

    public ProducteController(IProducteDAO producteDAO, RestTemplate restTemplate) {
        this.producteDAO = producteDAO;
        this.restTemplate = restTemplate;
    }

    public List<ProducteDTO> getUltimsProductes() {
        return this.producteDAO.getProductes();
    }

    public ProducteDTO getProducte(String id) throws Exception{
        return this.producteDAO.getProducte(id);
    }

    public void updatePrices() {

        ProducteDTO[] productesDTO = restTemplate.getForObject(Parameters.REQUEST_URL, ProducteDTO[].class);

        this.producteDAO.updatePreus(productesDTO);
    }

    public static ProducteDTO getProducte(String id, IProducteDAO producteDAO) throws Exception{
        return producteDAO.getProducte(id);
    }
}
