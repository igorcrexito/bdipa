/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author odontoradiosis
 */
public class Usuario {

    private String rg;
    private String instituicao;
    private String nome;
    private String email;
    private int nivelAcesso;

    public Usuario(String rg, String instituicao, String nome, String email, int nivelAcesso) {
        this.rg = rg;
        this.instituicao = instituicao;
        this.nome = nome;
        this.email = email;
        this.nivelAcesso = nivelAcesso;
    }

    public Usuario () {
        this.rg = null;
        this.instituicao = null;
        this.nome = null;
        this.email = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }



}
