/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eventos;

import gui.*;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 *
 * @author Igor-Note
 */
public class MouseEventos implements MouseMotionListener, MouseListener {

    PainelPrincipal principal;
    ArrayList<PontosCefalometricos> listaPontos = new ArrayList<PontosCefalometricos>();
    private boolean movendo = false;
    private boolean marcando = false;
    PontosCefalometricos pontoEscolhido;

    public void mouseDragged(MouseEvent e) {
        if (movendo) {
            pontoEscolhido.getPonto().setLocation(e.getX(), e.getY());
            principal.repaint();
        }
    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        for (int i=0;i<listaPontos.size();i++) {
            if (Math.abs(listaPontos.get(i).getPonto().getX()-e.getX())<=3 && Math.abs(listaPontos.get(i).getPonto().getY()-e.getY())<=3) {
                pontoEscolhido = listaPontos.get(i);
                movendo = true;
            }
        }

        if (!movendo && marcando==true) {
            listaPontos.add(new PontosCefalometricos(new Point(e.getX(),e.getY()),principal.getPontoEscolhido()));
            principal.setListaPontos(listaPontos);
            marcando = false;
        }
        principal.repaint();
    }

    public void mouseReleased(MouseEvent e) {
        if (movendo)
            movendo = false;

        principal.repaint();
    }

    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
    }

    public PainelPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(PainelPrincipal principal) {
        this.principal = principal;
    }

    public void setMarcando(boolean b) {
        this.marcando = b;
    }

}
