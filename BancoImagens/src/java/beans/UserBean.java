/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Banco.Conexao.ConexaoBD;
import Banco.Conexao.UsuarioDAO;
import DAO.Usuario;
import EmailUtils.EmailUtils;
import EmailUtils.Mensagem;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Igor
 */
@ManagedBean
@SessionScoped

public class UserBean {
    Usuario user;
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
    private boolean naologado = true;
    private boolean logado = false;
    UsuarioDAO userDao = new UsuarioDAO(ConexaoBD.getConexaoBD());;
    private Mensagem mensagem = new Mensagem();


    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public String getFins() {
        return fins;
    }

    public boolean isNaoLogado() {
        return naologado;
    }

    public void setNaoLogado(boolean naologado) {
        this.naologado = naologado;
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

            String mensagemEmail = "Nome: "+ this.nome+ "\n\n"+ "Email: "+ this.email+ "\n\n"+ "RG: "+ this.rg;
            mensagemEmail= mensagemEmail + "\n\n" + "Instituição: "+ this.instituicao+ "\n\n" + "Fins: "+ this.fins;
            mensagem.setMensagem(mensagemEmail);
            mensagem.setTitulo("Mensagem de Requisição para uso do Banco de Imagens");
            EmailUtils.enviaEmail(mensagem);
         } catch (EmailException ex) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! Occoreu um erro ao enviar a mensagem.", "Erro"));
             Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
         }

        try {
            ConexaoBD.getConexaoBD().conecta();
            userDao.inserirUsuario(rg, nome, instituicao, email, nivelAcesso, senha, login, justificativa);

            informacao = "Usuário " + nome + " cadastrado com sucesso";
            this.email = "";
            this.instituicao = "";
            this.login = "";
            this.nome = "";
            this.rg = "";
            this.fins = "";
            ConexaoBD.getConexaoBD().desconecta();

        } catch (Exception ex) {
            informacao = "Usuário não pode ser cadastrado";
        }
    }

    public String deslogar() {

        user = null;
        nome = "";
        rg = "";
        erro = "";
        instituicao = "";
        email = "";
        informacao = "";
        fins = "";
        nivelAcesso = 0;
        senha = "";
        login = "";
        justificativa = "";
        naologado = true;
        logado = false;

        return "home.xhtml";
    }

    public void mostraDados() {

        //UsuarioDAO userDAO = new UsuarioDAO();
        try {
            ConexaoBD.getConexaoBD().conecta();
            user = userDao.getUsuarioRG(this.rg);
            this.nome = user.getNome();
            this.rg = user.getRg();
            this.instituicao = user.getInstituicao();
            informacao = "RG do sacana é: " + this.rg;
            ConexaoBD.getConexaoBD().desconecta();
        } catch (SQLException ex) {
            informacao = "Senha e/ou login errado(s)";
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String logar() {


        try {
            ConexaoBD.getConexaoBD().conecta();
            Usuario user = userDao.getUsuariosFromLoginSenha(login, senha);
            informacao="";
            ConexaoBD.getConexaoBD().desconecta();

            if (user!=null) {
                /*resgatando dados do BD para o Bean*/
                this.email = user.getEmail();
                this.nivelAcesso = user.getNivelAcesso();
                this.nome = user.getNome();
                this.rg = user.getRg();
                this.senha = user.getSenha();
                this.instituicao = user.getInstituicao();
                this.justificativa = user.getJustificativa();
                this.login = user.getLogin();
                naologado = false;
                logado = true;
                if (user.getNivelAcesso()==2) {
                    return "admin.xhtml";
                 } else {
                    return null;
                 }
            } else {
                return null;
            }
        } catch (Exception ex) {
            informacao = "Senha ou login inválido";
            return null;
        }
    }

    public void excluir() {
        try {
            ConexaoBD.getConexaoBD().conecta();
            userDao.excluirUsuario(rg);
            informacao = "Usuario deletado";
            ConexaoBD.getConexaoBD().desconecta();
        } catch (SQLException ex) {
            informacao = "Senha ou login inválido";
        }

    }

     public void isAdmin(){

	if (this.nivelAcesso!=2){
                FacesContext fc = FacesContext.getCurrentInstance();
		ConfigurableNavigationHandler nav
		   = (ConfigurableNavigationHandler)
			fc.getApplication().getNavigationHandler();

		nav.performNavigation("erro");
	}
    }

       public void isCadastrado(){

	if (this.nivelAcesso<1){
                FacesContext fc = FacesContext.getCurrentInstance();
		ConfigurableNavigationHandler nav
		   = (ConfigurableNavigationHandler)
			fc.getApplication().getNavigationHandler();

		nav.performNavigation("erro");
	}
    }
    
    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
