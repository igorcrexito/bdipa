/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processamento;

import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.Histogram;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.RenderedOp;

/**
 *
 * @author Igor
 */
public class HistogramaLimiar {


   public static int[] getHistogram(PlanarImage image) {

        int numBits = image.getColorModel().getPixelSize();
        int numCanais = image.getColorModel().getNumComponents();
        int numBitsPorPixel = numBits / numCanais;
        double pixelComponent = Math.pow(2, numBitsPorPixel);

        int[] bins = { (int) pixelComponent };
        double[] low = { 0.0D };
        double[] high = { pixelComponent };

        ParameterBlock pb = new ParameterBlock();
        pb.addSource(image);
        pb.add(null);
        pb.add(1);
        pb.add(1);
        pb.add(bins);
        pb.add(low);
        pb.add(high);

        RenderedOp op = JAI.create("histogram", pb, null);
        Histogram histogram = (Histogram) op.getProperty("histogram");

        // captura conteudo do histograma
        int[] local_array = new int[histogram.getNumBins(0)];
        for ( int i = 0; i < histogram.getNumBins(0); i++ ) {
            local_array[i] = histogram.getBinSize(0, i);
        }

        return local_array;
    }

    public int limiarOtimo(PlanarImage imagem)
    {

        int [] bitsPorCor = imagem.getColorModel().getComponentSize();
        int [] hist = new int[(int)Math.pow(2,bitsPorCor[0]) - 1];
        hist = getHistogram(imagem);
        int comprimento = imagem.getWidth();
        int largura = imagem.getHeight();
        double quantidadePixels = comprimento * largura;
        double mediaTotal = 0;
        double W0,W1,media0,media1;
        double variQuad = 0;
        double maxVariQuad = 0;
        int limiarOtimo =0;

        for(int i = 0;i<hist.length;i++)
        {
            mediaTotal = mediaTotal + i*(hist[i]);
        }

        mediaTotal = mediaTotal /quantidadePixels;

        for(int limiar =1; limiar < hist.length - 1;limiar++)
        {
            W0 = W1 = media0 = media1 = 0;

            for(int i = 0;i< limiar;i++)
            {
                W0 = W0 + hist[i];
            }

            W0 = W0 / quantidadePixels;

            for(int j = limiar;j< hist.length;j++)
            {
               W1 = W1 + hist[j];
            }

            W1 = W1 / quantidadePixels;

            for(int i = 0;i< limiar;i++)
            {
               media0 = media0 +(i*(hist[i]));
            }

            media0 = media0 / quantidadePixels / W0;

            for(int j = limiar;j< hist.length;j++)
            {
               media1 = media1 +(j*(hist[j]));
            }

            media1 = media1 / quantidadePixels / W1;

            variQuad = W0*(Math.pow((media0 - mediaTotal),2)) +
                       W1*(Math.pow((media1 - mediaTotal),2));

            if(variQuad > maxVariQuad)
            {
                limiarOtimo = limiar;
                maxVariQuad = variQuad;
            }

        }

        return limiarOtimo;

    }

}
