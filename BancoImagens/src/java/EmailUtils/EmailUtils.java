/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EmailUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

    public class EmailUtils {

     private static final String HOSTNAME = "smtp.gmail.com";
     private static final String USERNAME = "bdimagenscefalometricas";
     private static final String PASSWORD = "odontoradiosis";
     private static final String EMAILORIGEM = "bdimagenscefalometricas@gmail.com";

     public static Email conectaEmail() throws EmailException {
         Email email = (Email) new SimpleEmail();
         email.setHostName(HOSTNAME);
         email.setSmtpPort(587);

         email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
         email.setTLS(true);
         email.setFrom(EMAILORIGEM);
     return email;
     }

     public static void enviaEmail(Mensagem mensagem) throws EmailException {
         Email email = new SimpleEmail();
         email = conectaEmail();
         email.setSubject(mensagem.getTitulo());
         email.setMsg(mensagem.getMensagem());
         email.addTo("bdimagenscefalometricas@gmail.com");
         email.send();
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "E-mail enviado com sucesso para: " + "bdimagenscefalometricas@gmail.com", "Informação"));
     }
    }  