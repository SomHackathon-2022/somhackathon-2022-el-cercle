package cat.tecnocampus.elcercle.application.email;

import cat.tecnocampus.elcercle.application.dto.MembreDTO;
import cat.tecnocampus.elcercle.utilities.Parameters;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class EmailClosedOrder extends EmailSender{
    private MembreDTO membre;
    private String producte;

    public void sendEmail(MembreDTO membre, String producte) {
        setProperties();
        setKafamanSession();
        this.membre = membre;
        this.producte = producte;
        createMime();
    }

    @Override
    protected void createMime() {
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(Parameters.emailKafaman));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.membre.getCorreu()));

            // Set Subject: header field
            message.setSubject("KafamanOFC Comanda");

            // Now set the actual message
            message.setText("Hola "+membre.getNom()+" "+membre.getCognom1()
                    +", la comanda respecte el producte "+this.producte+" ha estat tancada i no es podrà modificar.");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
