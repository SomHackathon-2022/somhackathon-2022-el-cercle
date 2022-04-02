package cat.tecnocampus.elcercle.api;

import cat.tecnocampus.elcercle.application.ProducteController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import cat.tecnocampus.elcercle.application.dto.ProducteDTO;

import java.util.List;


@RestController
public class ProducteRestController {

    private ProducteController producteController;

    public ProducteRestController(ProducteController producteController) {
        this.producteController = producteController;
    }

    @GetMapping("/productes/ultims")
    public List<ProducteDTO> getUltimsProductes() {
        return producteController.getUltimsProductes();
    }

    @GetMapping("/productes/{id}")
    public ProducteDTO getProducte(@PathVariable String id) {
        try{
            return producteController.getProducte(id);
        } catch (Exception e){
            return ProducteDTO.getEmpty();
        }
    }
}