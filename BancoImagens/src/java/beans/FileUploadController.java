/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
/**
 *
 * @author Igor-Note
 */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "fileUploadController")
@SessionScoped
public class FileUploadController {

        public void processFileUpload(FileUploadEvent event) throws IOException {
            try {
                UploadedFile arq = event.getFile();
                InputStream in = new BufferedInputStream(arq.getInputstream());
                File file = new File("/imagensPaciente/" + arq.getFileName());

                FileOutputStream fout = new FileOutputStream(file);

                while (in.available() != 0) {
                    fout.write(in.read());
                }
                fout.close();
                FacesMessage msg = new FacesMessage("O Arquivo ", file.getName()
                        + " salvo.");
                FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
}

