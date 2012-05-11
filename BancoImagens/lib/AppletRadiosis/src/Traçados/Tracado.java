/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Traçados;

import gui.PontosCefalometricos;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Igor-Note
 */
public interface Tracado {

    public void realizarTracado(Graphics g);
    public ArrayList<PontosCefalometricos> carregaPontos();
    public void setListaPontos(ArrayList<PontosCefalometricos> pontos);
    public void calcularMedidas();
    public ArrayList<Medidas> getListaMedidas();


}
