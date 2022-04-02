package cat.tecnocampus.elcercle.api;

import cat.tecnocampus.elcercle.application.dto.ComandaDTO;
import cat.tecnocampus.elcercle.application.dto.SubscripcioDTO;
import org.springframework.web.bind.annotation.*;
import cat.tecnocampus.elcercle.application.MembreController;
import cat.tecnocampus.elcercle.application.dto.MembreDTO;

import java.util.List;


@RestController
public class MembreRestController {

	private MembreController membreController;

	public MembreRestController(MembreController membreController) {
		this.membreController = membreController;
	}

	@GetMapping("/membres/{idMembre}")
	public MembreDTO getMembre(@PathVariable String idMembre) {
		return membreController.getMembre(idMembre);
	}

	@GetMapping("/membres")
	public List<MembreDTO> getMembres() {
		return membreController.getMembres();
	}

	@GetMapping("/membres/subscripcions/{correu}")
	public List<SubscripcioDTO> consultarSubscripcions(@PathVariable String correu){
		return membreController.consultarSubscripcions(correu);
	}

	@GetMapping("/membres/subscripcions/actives/{correu}")
	public List<SubscripcioDTO> consultarSubscripcionsActives(@PathVariable String correu){
		return membreController.consultarSubscripcionsActives(correu);
	}

	@GetMapping("/membres/subscripcions/actives")
	public List<SubscripcioDTO> consultarSubscripcionsActives(){
		return membreController.consultarSubscripcionsActives();
	}

	@GetMapping("/membres/subscripcions/inactives/{correu}")
	public List<SubscripcioDTO> consultarSubscripcionsInactives(@PathVariable String correu){
		return membreController.consultarSubscripcionsInactives(correu);
	}

	@GetMapping("/membres/productessubscripcions/nom/{idSubscripcio}")
	public String getNomProducteDeSubscripcio(@PathVariable String idSubscripcio){
		return membreController.getNomProducteDeSubscripcio(idSubscripcio);
	}

	@GetMapping("/membres/productescomandes/nom/{idComanda}")
	public String getNomProducteDeComanda(@PathVariable String idComanda){
		return membreController.getNomProducteDeComanda(idComanda);
	}

	@GetMapping("/membres/productessubscripcions/preu/{idSubscripcio}")
	public float getPreuProducteDeSubscripcio(@PathVariable String idSubscripcio){
		return membreController.getPreuProducteDeSubscripcio(idSubscripcio);
	}

	@GetMapping("/membres/productescomandes/preu/{idComanda}")
	public float getPreuProducteDeComanda(@PathVariable String idComanda){
		return membreController.getPreuProducteDeComanda(idComanda);
	}

	@GetMapping("/membres/productessubscripcions/imatge/{idSubscripcio}")
	public String getImatgeProducteDeSubscripcio(@PathVariable String idSubscripcio){
		return membreController.getImatgeProducteDeSubscripcio(idSubscripcio);
	}

	@GetMapping("/membres/productescomandes/imatge/{idComanda}")
	public String getImatgeProducteDeComanda(@PathVariable String idComanda){
		return membreController.getImatgeProducteDeComanda(idComanda);
	}

	@GetMapping("/membres/productescomandes/id/{idComanda}")
	public String getIdProducteDeComanda(@PathVariable String idComanda){
		return membreController.getIdProducteDeComanda(idComanda);
	}

	@GetMapping("/membres/productes/subscripcions/activa/{correu}/{idProducte}")
	public String getIdSubscripcio(@PathVariable String correu, @PathVariable String idProducte){
		return membreController.getIdSubscripcio(correu, idProducte);
	}

	@PostMapping("/membres/subscripcions/nova/{idProducte}/{quantitat}/{correu}")
	public void ferSubscripcio(@PathVariable String idProducte, @PathVariable int quantitat, @PathVariable String correu){
		membreController.ferSubscripcio(idProducte, quantitat, correu);
	}

	@GetMapping("/membres/comandes/{correu}")
	public List<ComandaDTO> consultarComandes(@PathVariable String correu){
		return membreController.consultarComandes(correu);
	}

	@GetMapping("/membres/subscripcions/quantitat/{idSubscripcio}")
	public int getQuantitatSubscripcio(@PathVariable String idSubscripcio){
		return membreController.getQuantitatSubscripcio(idSubscripcio);
	}
	@GetMapping("/membres/comanda/{idComanda}")
	public ComandaDTO consultarComanda(@PathVariable String idComanda){
		return membreController.consultarComanda(idComanda);
	}

	@PutMapping("/membres/comandes/{idComanda}/{quantitat}/{correu}")
	public void modificarComanda (@PathVariable String idComanda, @PathVariable int quantitat, @PathVariable String correu){
		String idUsuariQueEstaModificant = membreController.getIdUsuari(correu);
		membreController.modificarComanda(idComanda, quantitat, idUsuariQueEstaModificant);
	}

	@PutMapping("/membres/subscripcions/cancel/{idSubscripcio}/{correu}")
	public void cancelarSubscripcio (@PathVariable String idSubscripcio, @PathVariable String correu){
		membreController.cancelarSubscripcio(idSubscripcio);
	}

	@PutMapping("/membres/subscripcions/{idSubscripcio}/{quantitat}/{correu}")
	public void modificarSubscripcio (@PathVariable String idSubscripcio, @PathVariable int quantitat, @PathVariable String correu){
		String idUsuariQueEstaModificant = membreController.getIdUsuari(correu);
		membreController.modificarSubscripcio(idSubscripcio, quantitat, idUsuariQueEstaModificant);
	}

}
