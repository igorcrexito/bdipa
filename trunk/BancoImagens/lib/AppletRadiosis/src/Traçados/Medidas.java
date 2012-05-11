/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Traçados;

/**
 *
 * @author Igor-Note
 */
public class Medidas {

    private float valor;
    private String nome;

    public Medidas (float valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
