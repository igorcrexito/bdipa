/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import java.io.InputStream;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
/**
 *
 * @author PH
 */
public class FileDownloadController {
private StreamedContent file;

    public FileDownloadController(String url) {
        InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(url);
        file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
    }

    public StreamedContent getFile() {
        return file;
    }
}
