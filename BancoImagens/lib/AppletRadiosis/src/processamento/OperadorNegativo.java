/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processamento;

import java.awt.image.BufferedImage;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

/**
 *
 * @author Igor
 */
public class OperadorNegativo {

    public static PlanarImage aplicaNegativo (PlanarImage img) {
        img = JAI.create("invert", img);

        return img;
    }

}
