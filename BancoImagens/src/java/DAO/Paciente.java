/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author odontoradiosis
 */
public class Paciente {
     private int id;
     private int sexo;
     private int idade;
     private String urlImagem;


    public Paciente () {
        this.urlImagem = null;
    }

    public Paciente(int id, int sexo, int idade, String urlImagem) {
        this.id = id;
        this.sexo = sexo;
        this.idade = idade;
        this.urlImagem = urlImagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }


}
