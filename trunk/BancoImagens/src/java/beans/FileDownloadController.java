/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
/**
 *
 * @author PH
 */
@ManagedBean(name = "fileDownload")
@SessionScoped
public class FileDownloadController {
private StreamedContent file;

    public FileDownloadController(String url) {
        InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(url);
        file = new DefaultStreamedContent(stream, "image/jpg", "/imagensPaciente/raiox.jpg");
    }

    public StreamedContent getFile() {
        return file;
    }
}
