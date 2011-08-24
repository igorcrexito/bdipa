/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.ArrayList;

/**
 *
 * @author Igor
 */
public class Pagina {

    private String nome;
    private ArrayList<String> conteudo;

    public Pagina(String nome, ArrayList<String> conteudo) {
        this.nome = nome;
        this.conteudo = conteudo;
    }

    public ArrayList<String> getConteudo() {
        return conteudo;
    }

    public void setConteudo(ArrayList<String> conteudo) {
        this.conteudo = conteudo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
