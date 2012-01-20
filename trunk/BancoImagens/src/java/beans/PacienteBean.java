/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import Banco.Conexao.ConexaoBD;
import Banco.Conexao.PacienteDAO;
import Banco.Conexao.UsuarioDAO;
import DAO.Paciente;
import DAO.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Igor-Note
 */
@ManagedBean (name="pacBean")
@SessionScoped

public class PacienteBean {

    private List<Paciente> pacientes;
    PacienteDAO pacDao = new PacienteDAO(ConexaoBD.getConexaoBD());

    public PacienteBean () {
        popularPacientes();
    }

    private void popularPacientes() {
        try {
            this.pacientes = pacDao.getTodosPacientesLista();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

}
