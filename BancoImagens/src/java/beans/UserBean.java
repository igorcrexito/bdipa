/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

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

    private String nome;
    private String password;
    private String rg;
    private String erro="";
    private String instituicao;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void mostraDados() {
        UsuarioDAO userDAO = new UsuarioDAO();
        
        try {
            Usuario user = userDAO.getUsuariosFromLoginSenha(this.rg,this.password);
            this.nome = user.getNome(); 
            this.rg = user.getRg();
            this.instituicao = user.getInstituicao();
            System.out.println("RG do sacana é: "+ this.rg);
        } catch (SQLException ex) {
            erro = "Senha e/ou login errado(s)";
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
   
   
}
