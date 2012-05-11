/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package estruturas.eventos;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Igor-Note
 */
public class EstruturaAnatomica {

    private ArrayList<Point> pontosEstrutura;
    private String nome;
    private boolean visivel = false;

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Point> getPontosEstrutura() {
        return pontosEstrutura;
    }

    public void setPontosEstrutura(ArrayList<Point> pontosEstrutura) {
        this.pontosEstrutura = pontosEstrutura;
    }
    
    public EstruturaAnatomica(String nome, ArrayList<Point> pontosEstrutura) {
        this.nome = nome;
        this.pontosEstrutura = pontosEstrutura;
    }

}
