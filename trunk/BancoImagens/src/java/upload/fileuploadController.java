/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upload;

import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Igor-Note
 */
@ManagedBean(name = "fileUploadController")
@SessionScoped
public class FileUploadController {

    private String dosyaisim;

    public void processFileUpload(FileUploadEvent event) throws AbortProcessingException {
        System.out.println("Uploaded: " + event.getFile().getFileName());
        UploadedFile file = event.getFile();
        byte[] readData = file.getContents();
        dosyaisim = file.getFileName();
        imgSave(readData, dosyaisim);
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void imgSave(byte[] readData, String dosyaisim) {
        try {
            FileOutputStream fos = new FileOutputStream("C:/" + dosyaisim);
            fos.write(readData);
            fos.flush();
            fos.close();
        } catch (Exception ex) {
            Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
