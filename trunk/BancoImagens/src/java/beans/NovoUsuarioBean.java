/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import Banco.Conexao.ConexaoBD;
import Banco.Conexao.UsuarioDAO;
import DAO.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Igor-Note
 */
@ManagedBean (name="novoUserBean")
@SessionScoped

public class NovoUsuarioBean {

    private List<Usuario> usuarios;
    private UsuarioDAO userDao;

    public NovoUsuarioBean () {
        usuarios = new ArrayList<Usuario>();
          
        
    }

    public void altera() {

    }

    public List<Usuario> getUsuarios() {
          ConexaoBD.getConexaoBD().conecta();
            userDao = new UsuarioDAO(ConexaoBD.getConexaoBD());
        try {
            usuarios = userDao.getUsuarios();
        } catch (SQLException ex) {
            Logger.getLogger(NovoUsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
            ConexaoBD.getConexaoBD().desconecta();
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
