/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Banco.Conexao.ConexaoBD;
import Banco.Conexao.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String senha;
    private String login;
    private String justificativa;

    public Usuario(String rg, String instituicao, String nome, String email, int nivelAcesso, String senha, String login, String justificativa) {
        this.rg = rg;
        this.instituicao = instituicao;
        this.nome = nome;
        this.email = email;
        this.nivelAcesso = nivelAcesso;
        this.senha = senha;
        this.login = login;
        this.justificativa = justificativa;
    }

    public Usuario () {
        this.rg = null;
        this.instituicao = null;
        this.nome = null;
        this.email = null;
        this.senha = null;
        this.login = null;
        this.justificativa = null;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public void alterato1() {
        UsuarioDAO user = new UsuarioDAO(ConexaoBD.getConexaoBD());
        try {
           user.alteraNivelAcessoByRGto1(this.rg);
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void alterato2() {
        UsuarioDAO user = new UsuarioDAO(ConexaoBD.getConexaoBD());
        try {
           user.alteraNivelAcessoByRGto2(this.rg);
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void alterato0() {
        UsuarioDAO user = new UsuarioDAO(ConexaoBD.getConexaoBD());
        try {
           user.alteraNivelAcessoByRGto0(this.rg);
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
