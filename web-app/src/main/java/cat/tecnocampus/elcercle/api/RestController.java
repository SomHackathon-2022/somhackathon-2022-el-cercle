package cat.tecnocampus.elcercle.api;

import cat.tecnocampus.elcercle.utilities.Parameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/organic")
    public double getOrganicKilos() {
        return Parameters.restaurant_organic_kilos;
    }

    @PostMapping("/organic/{added_kilos}")
    public void setOrganicKilos(@PathVariable double added_kilos) {
        Parameters.restaurant_organic_kilos += added_kilos;
    }


    @GetMapping("/strawberries")
    public double getStrawberriesKilos() {
        return Parameters.restaurant_generated_strawberries_kilos;
    }

    @PostMapping("/strawberries/{added_kilos}")
    public void setStrawberriesKilos(@PathVariable double added_kilos) {
        Parameters.restaurant_generated_strawberries_kilos += added_kilos;
    }

    @GetMapping("/potatoes")
    public double getPotatoesKilos() {
        return Parameters.restaurant_generated_potatoes_kilos;
    }

    @PostMapping("/potatoes/{added_kilos}")
    public void setPotatoesKilos(@PathVariable double added_kilos) {
        Parameters.restaurant_generated_potatoes_kilos += added_kilos;
    }

    @GetMapping("/oranges")
    public double getOrangesKilos() {
        return Parameters.restaurant_generated_oranges_kilos;
    }

    @PostMapping("/oranges/{added_kilos}")
    public void setOrangesKilos(@PathVariable double added_kilos) {
        Parameters.restaurant_generated_oranges_kilos += added_kilos;
    }

    @GetMapping("/lettuces")
    public double getLettuceKilos() {
        return Parameters.restaurant_generated_lettuce_kilos;
    }

    @PostMapping("/lettuces/{added_kilos}")
    public void setLettuceKilos(@PathVariable double added_kilos) {
        Parameters.restaurant_generated_lettuce_kilos += added_kilos;
    }

}
