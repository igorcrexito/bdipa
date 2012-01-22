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
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Igor-Note
 */
@ManagedBean(name = "novoPacBean")
@SessionScoped
public class NovoPacienteBean {

    private List<Paciente> pacientes;
    private PacienteDAO pacDao = new PacienteDAO(ConexaoBD.getConexaoBD());
    private String urlImagem;
    private int idade;
    private int sexo;
    private int raca;

    public NovoPacienteBean() {
        pacientes = new ArrayList<Paciente>();
        try {
            pacientes = pacDao.getTodosPacientesLista();
        } catch (SQLException ex) {
            Logger.getLogger(NovoPacienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void altera() {
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void cadastro() {
        // teste = " " + email + "-" + instituicao + "-" + nome + "-" + rg + "-" + logar + "-" + password + "-" + nivelAcesso;

        try {
            pacDao.inserirPaciente(idade, sexo, raca, urlImagem);


        } catch (Exception ex) {
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getRaca() {
        return raca;
    }

    public void setRaca(int raca) {
        this.raca = raca;
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

    public void processFileUpload(FileUploadEvent event) throws IOException {
        try {
//Cria um arquivo UploadFile, para receber o arquivo do evento
            UploadedFile arq = event.getFile();
            InputStream in = new BufferedInputStream(arq.getInputstream());
//copiar para pasta do projeto
            File file = new File("C:/" + arq.getFileName());
//O método file.getAbsolutePath() fornece o caminho do arquivo criado

//Pode ser usado para ligar algum objeto do banco ao arquivo enviado
            urlImagem = file.getAbsolutePath();
            FileOutputStream fout = new FileOutputStream(file);
            while (in.available() != 0) {
                fout.write(in.read());
            }
            fout.close();
            FacesMessage msg = new FacesMessage("O Arquivo ", file.getName() + " salvo.");
            FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
