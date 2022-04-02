package cat.tecnocampus.elcercle.application.scheduler;

import cat.tecnocampus.elcercle.application.ProducteController;
import cat.tecnocampus.elcercle.utilities.Parameters;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class pricesUpdate {
    private ProducteController producteController;

    public pricesUpdate(ProducteController producteController){ this.producteController = producteController;}

    @Scheduled(cron = Parameters.pricesUpdate_HOUR +" "+Parameters.pricesUpdate_DATE) //Actualització de preus
    public void pricesUpdate(){ producteController.updatePrices();}
}
