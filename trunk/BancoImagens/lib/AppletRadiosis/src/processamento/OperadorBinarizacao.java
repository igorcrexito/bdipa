/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processamento;

import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

/**
 *
 * @author Igor
 */
public class OperadorBinarizacao {

    PlanarImage image;


    public PlanarImage binarizaImagem (int limiar) {
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(image);
        pb.add(1.0*limiar);
        PlanarImage binarizada = JAI.create("binarize", pb);

        return binarizada;
    }

    public PlanarImage getImage() {
        return image;
    }

    public void setImage(PlanarImage image) {
        this.image = image;
    }

}
