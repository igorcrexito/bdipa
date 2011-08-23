/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Banco.Conexao.ConexaoBD;
import Banco.Conexao.PacienteDAO;
import Banco.Conexao.UsuarioDAO;
import DAO.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Nalminha
 */
@ManagedBean
@SessionScoped
public class UserBean {

    private String nome = "";
    private String rg = "";
    private String erro = "";
    private String instituicao = "";
    private String email = "";
    private String informacao = "";
    private String fins = "";
    private int nivelAcesso = 0;
    private String senha = "";
    private String login = "";
    private String justificativa = "";
    UsuarioDAO userDao = new UsuarioDAO(ConexaoBD.getConexaoBD());

    public String getFins() {
        return fins;
    }

    public void setFins(String fins) {
        this.fins = fins;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public void cadastro() {
        // teste = " " + email + "-" + instituicao + "-" + nome + "-" + rg + "-" + logar + "-" + password + "-" + nivelAcesso;
        try {
            userDao.inserirUsuario(rg, nome, instituicao, email, nivelAcesso, senha, login, justificativa);
            informacao = "Usuário " + nome + " cadastrado com sucesso";
            this.email = "";
            this.instituicao = "";
            this.login = "";
            this.nome = "";
            this.rg = "";
            this.fins = "";


        } catch (Exception ex) {
            informacao = "Usuário não pode ser cadastrado";
        }
    }

    public void mostraDados() {

        //UsuarioDAO userDAO = new UsuarioDAO();
        try {
            Usuario user = userDao.getUsuarioRG(this.rg);
            this.nome = user.getNome();
            this.rg = user.getRg();
            this.instituicao = user.getInstituicao();
            informacao = "RG do sacana é: " + this.rg;
        } catch (SQLException ex) {
            informacao = "Senha e/ou login errado(s)";
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void logar() {


        try {
            Usuario user = userDao.getUsuariosFromLoginSenha(login, senha);

            informacao = user.getNome() + " Seja Bem Vindo";

        } catch (Exception ex) {
            informacao = "Senha ou login inválido";
            //Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }


        this.senha = "";
        this.rg = "";

    }

    public void excluir() {
        try {
            userDao.excluirUsuario(rg);
            informacao = "Usuario deletado";
        } catch (SQLException ex) {
            informacao = "Senha ou login inválido";
        }

    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
