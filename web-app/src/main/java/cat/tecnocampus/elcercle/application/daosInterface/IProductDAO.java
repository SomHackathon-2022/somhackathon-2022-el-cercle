package cat.tecnocampus.elcercle.application.daosInterface;

import cat.tecnocampus.elcercle.application.dto.ProductDTO;

import java.util.List;

public interface IProductDAO {
    ProductDTO getProducte(String id) throws Exception;
    List<ProductDTO> getProductes();

    void updatePreus(ProductDTO[] productesDTO);
}
