/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processamento;

import java.awt.image.BufferedImage;
import javax.media.jai.JAI;
import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;

/**
 *
 * @author Igor
 */
public class OperadorBordas {

    PlanarImage image;

    
    public void setImage(PlanarImage image) {
        this.image = image;
    }

    public PlanarImage detectaBordas (){
        this.image = JAI.create("gradientmagnitude", this.image,KernelJAI.GRADIENT_MASK_SOBEL_HORIZONTAL,KernelJAI.GRADIENT_MASK_SOBEL_VERTICAL);
        return image;
    }
    
}
