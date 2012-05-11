/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.Point;

/**
 *
 * @author Igor-Note
 */
public class PontosCefalometricos {

    private Point ponto;
    private String nome;

    public PontosCefalometricos(Point ponto, String nome) {
        this.ponto = ponto;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Point getPonto() {
        return ponto;
    }

    public void setPonto(Point ponto) {
        this.ponto = ponto;
    }

}
