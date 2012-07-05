/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import com.sun.media.jai.codec.*;
import java.awt.image.RenderedImage;
import java.io.IOException;
import javax.media.jai.JAI;

/**
 *
 * @author WINDOWS 7
 */
public class TiffUtils {

  public static void TiffToJpg(String tiff, String output)
     throws IOException
  {
        String sourcefilename = tiff;  
        String targetfilename = output;          
        try {  
        FileSeekableStream stream = null;  
        stream = new FileSeekableStream(sourcefilename);  
        ImageDecoder dec = ImageCodec.createImageDecoder("tiff", stream,null);  
        RenderedImage image =   dec.decodeAsRenderedImage(0);  
        JAI.create("filestore",image ,targetfilename,"JPEG");  
        } catch (IOException e) {  
                 e.printStackTrace();  
                 System.exit(0);  
        }  
  }

  public static void main(String[] args) throws Exception {
    TiffUtils.TiffToJpg("C:/Users/WINDOWS 7/Desktop/raiox3.tif",
                        "C:/Users/WINDOWS 7/Desktop/raiox3.jpg");
  }
}
