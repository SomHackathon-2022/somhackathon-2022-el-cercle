package cat.tecnocampus.elcercle.application.scheduler;

import cat.tecnocampus.elcercle.application.ComandaController;
import cat.tecnocampus.elcercle.application.dto.ComandaDTO;
import cat.tecnocampus.elcercle.utilities.Parameters;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderManagement {

    ComandaController comandaController;

    public OrderManagement(ComandaController comandaController){
        this.comandaController = comandaController;
    }
    @Scheduled(cron = Parameters.createOrder_HOUR+" "+Parameters.createOrder_DATE) //Comades tots els dilluns de les 2h
    public void crearComandas() {
        comandaController.crearComandes();
    }
    @Scheduled(cron = Parameters.closeOrder_HOUR+" "+Parameters.closeOrder_DATE)
    public void tancarComandes() {comandaController.tancarComandes();}
    @Scheduled(cron = Parameters.sendOrder_HOUR+" "+Parameters.sendOrder_DATE)
    public void enviarComandes() {comandaController.enviarComandes();}
}
