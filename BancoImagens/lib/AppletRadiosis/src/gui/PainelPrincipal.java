/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;


/**
 *
 * @author Igor
 */


import Traçados.Tracado;
import estruturas.eventos.EstruturaAnatomica;
import eventos.MouseEventos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.util.ArrayList;
import javax.media.jai.BorderExtender;
import javax.media.jai.Interpolation;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.RenderedOp;
import javax.swing.JPanel;

/**
 *
 * @author beto
 */
public class PainelPrincipal extends JPanel
{
    private PlanarImage image;
    private ArrayList<PontosCefalometricos> listaPontos;
    private String pontoEscolhido;
    private Tracado tracadoEscolhido;
    private boolean tracar=false;
    private ArrayList<EstruturaAnatomica> estruturas;

    public PainelPrincipal(PlanarImage image)
    {
        super();
        setImage(image);
    }

     public PainelPrincipal()
    {
        super();

    }

    public ArrayList<EstruturaAnatomica> getEstruturas() {
        return estruturas;
    }

    public void setEstruturas(ArrayList<EstruturaAnatomica> estruturas) {
        this.estruturas = estruturas;
    }

    public boolean isTracar() {
        return tracar;
    }

    public void setTracar(boolean tracar) {
        this.tracar = tracar;
    }

    @Override
    public void setSize(int width, int height) 
    {    
       
        super.setSize(width, height);
    }


    public void setImage(PlanarImage image)
    {
        
        setSize(830, 1100);
        image = scale((RenderedOp) image,(float)1100/(float)image.getWidth(),(float)830/(float)image.getHeight());
        this.image = image;
        repaint();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(image.getAsBufferedImage(), 0, 0, getWidth(), getHeight(), this);

        g.setColor(Color.yellow);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        if (listaPontos!=null)
            for (int i=0;i<listaPontos.size();i++) {
                PontosCefalometricos ponto = listaPontos.get(i);
                g2.fillOval(ponto.getPonto().x-3, ponto.getPonto().y-3, 6, 6);
                g2.drawString(ponto.getNome(), ponto.getPonto().x, ponto.getPonto().y-10);

                
                if (tracar) {
                    tracadoEscolhido.setListaPontos(listaPontos);
                    tracadoEscolhido.realizarTracado(g2);
                }
            }

        for (int i=0;i<estruturas.size();i++) {
            if (estruturas.get(i).isVisivel()) {
                for (int j=0;j<estruturas.get(i).getPontosEstrutura().size();j++) {
                    g.fillOval(estruturas.get(i).getPontosEstrutura().get(j).x, estruturas.get(i).getPontosEstrutura().get(j).y, 6, 6);
                    if (j>=1) {
                        g.drawLine(estruturas.get(i).getPontosEstrutura().get(j-1).x+3, estruturas.get(i).getPontosEstrutura().get(j-1).y+3, estruturas.get(i).getPontosEstrutura().get(j).x+3, estruturas.get(i).getPontosEstrutura().get(j).y+3);
                    }
                }
            }
        }

    }

    public ArrayList<PontosCefalometricos> getListaPontos() {
        return listaPontos;
    }

    public void setListaPontos(ArrayList<PontosCefalometricos> listaPontos) {
        this.listaPontos = listaPontos;
    }

    public String getPontoEscolhido() {
        return pontoEscolhido;
    }

    public void setPontoEscolhido(String pontoEscolhido) {
        this.pontoEscolhido = pontoEscolhido;
    }

    public Tracado getTracadoEscolhido() {
        return tracadoEscolhido;
    }

    public void setTracadoEscolhido(Tracado tracadoEscolhido) {
        this.tracadoEscolhido = tracadoEscolhido;
    }

   private static RenderedOp scale(RenderedOp image, float scaleH, float scaleV) {
        ParameterBlock scaleParams = new ParameterBlock();
        scaleParams.addSource(image);
        scaleParams.add(scaleH).add(scaleV).add(0.0f).add(0.0f);
        scaleParams.add(Interpolation.getInstance(Interpolation.INTERP_BICUBIC_2));

        RenderingHints scalingHints = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        scalingHints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        scalingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        scalingHints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        scalingHints.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        scalingHints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        scalingHints.put(JAI.KEY_BORDER_EXTENDER, BorderExtender.createInstance(BorderExtender.BORDER_COPY));

        return JAI.create("scale", scaleParams, scalingHints);
 }

}

