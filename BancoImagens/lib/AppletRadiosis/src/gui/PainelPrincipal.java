/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;


/**
 *
 * @author Igor
 */


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author beto
 */
public class PainelPrincipal extends JPanel
{
    private BufferedImage image;


    public PainelPrincipal(BufferedImage image)
    {
        super();
        setImage(image);
    }

     public PainelPrincipal()
    {
        super();

    }

    @Override
    public void setSize(int width, int height) 
    {    
       
        super.setSize(width, height);
    }


    public void setImage(BufferedImage image)
    {
        this.image = image;
        setSize(image.getWidth(), image.getHeight());
        repaint();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
