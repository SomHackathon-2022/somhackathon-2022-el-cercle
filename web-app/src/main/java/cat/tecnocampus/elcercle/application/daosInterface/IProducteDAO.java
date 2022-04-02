package cat.tecnocampus.elcercle.application.daosInterface;

import cat.tecnocampus.elcercle.application.dto.ProducteDTO;

import java.util.List;

public interface IProducteDAO {
    ProducteDTO getProducte(String id) throws Exception;
    List<ProducteDTO> getProductes();

    void updatePreus(ProducteDTO[] productesDTO);
}
