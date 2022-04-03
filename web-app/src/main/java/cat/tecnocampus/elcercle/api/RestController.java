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
}
