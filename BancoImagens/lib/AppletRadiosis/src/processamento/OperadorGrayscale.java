/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processamento;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

/**
 *
 * @author Igor
 */
public class OperadorGrayscale {

   private PlanarImage image;

    public PlanarImage getImage() {
        return image;
    }

    public void setImage(PlanarImage image) {
        this.image = image;
    }

    public PlanarImage convertImageToGrayScale() {

        PlanarImage source= this.image;

        if(source.getSampleModel().getNumBands() != 3)
        {
            return source;
        }
        else
        {
                BufferedImageOp op = new ColorConvertOp(
                ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
                return PlanarImage.wrapRenderedImage(op.filter(image.getAsBufferedImage(), null));
        }

    }

    public boolean isGrayScale(PlanarImage src) {
        return (src.getNumBands() == 1);
    }

       public static BufferedImage imageToBufferedImage(Image im) {
        BufferedImage bi = new BufferedImage
        (im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        return bi;
    }

}
