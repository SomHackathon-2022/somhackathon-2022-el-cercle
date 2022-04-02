package cat.tecnocampus.elcercle.application.email;

import cat.tecnocampus.elcercle.application.dto.MembreDTO;
import cat.tecnocampus.elcercle.utilities.Parameters;
import org.springframework.stereotype.Component;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

@Component
public abstract class EmailSender {

    protected Properties properties = System.getProperties();
    protected Session session;

    protected abstract void createMime();

    protected void setProperties() {
        this.properties.put("mail.smtp.host", Parameters.emailHost);
        this.properties.put("mail.smtp.port", "465");
        this.properties.put("mail.smtp.ssl.enable", "true");
        this.properties.put("mail.smtp.auth", "true");
    }
    protected void setKafamanSession(){
        this.session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(Parameters.emailKafaman, Parameters.passwordKafaman);

            }

        });
        session.setDebug(true);
    }

}
