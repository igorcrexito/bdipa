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
import classes.OperacoesArquivos;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
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
import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.imageio.ImageIO;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Igor-Note
 */
@ManagedBean(name = "pacBean")
@SessionScoped
public class PacienteBean {

    private List<Paciente> pacientes;
    PacienteDAO pacDao = new PacienteDAO(ConexaoBD.getConexaoBD());
    private int idade;
    private String urlImagem;
    private int sexo;
    private int raca;
    private int opcaoImagem;
    private List<SelectItem> colecao;

    public List<SelectItem> getColecao() {
        colecao = new ArrayList<SelectItem>();
        for (int i=0;i<pacientes.size();i++) {
            colecao.add(new SelectItem(pacientes.get(i).getId()));
        }
        return colecao;
    }

    public void setColecao(List<SelectItem> colecao) {
        this.colecao = colecao;
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

    public void popularPacientes() {
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

    public void cadastrar() {

        try {
            pacDao.inserirPaciente(this.idade, this.sexo, this.raca, urlImagem);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void processFileUpload(FileUploadEvent event) throws IOException {
        try {
            //Cria um arquivo UploadFile, para receber o arquivo do evento

            UploadedFile arq = event.getFile();

            InputStream in = new BufferedInputStream(arq.getInputstream());
            File file = new File("C:/Documents and Settings/Igor/Meus documentos/trunk/BancoImagens/web/imagensPaciente/" + arq.getFileName());

            urlImagem = "reduzida"+arq.getFileName();
            //urlImagem = "C:/imagens/" + arq.getFileName();

            FileOutputStream fout = new FileOutputStream(file);

            while (in.available() != 0) {

                fout.write(in.read());

            }
            //cadastrar();
            fout.close();
            scale("C:/Documents and Settings/Igor/Meus documentos/trunk/BancoImagens/web/imagensPaciente/"+arq.getFileName(), 600, 600, "C:/Documents and Settings/Igor/Meus documentos/trunk/BancoImagens/web/imagensPaciente/reduzida" + arq.getFileName());
            scale("C:/Documents and Settings/Igor/Meus documentos/trunk/BancoImagens/web/imagensPaciente/"+arq.getFileName(), 600, 600, "C:/Documents and Settings/Igor/Meus documentos/trunk/BancoImagens/build/web/imagensPaciente/reduzida" + arq.getFileName());

            FacesMessage msg = new FacesMessage("O Arquivo ", file.getName() + " salvo.");

            FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }

    public int getOpcaoImagem() {
        return opcaoImagem;
    }

    public void setOpcaoImagem(int opcaoImagem) {
        this.opcaoImagem = opcaoImagem;
    }

    public PacienteDAO getPacDao() {
        return pacDao;
    }

    public void setPacDao(PacienteDAO pacDao) {
        this.pacDao = pacDao;
    }

    public static void scale(String srcFile, int destWidth, int destHeight,
            String destFile) throws IOException {

        BufferedImage src = ImageIO.read(new File(srcFile));
        BufferedImage dest = new BufferedImage(destWidth, destHeight,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = dest.createGraphics();

        AffineTransform at = AffineTransform.getScaleInstance(
                (double) destWidth / src.getWidth(),
                (double) destHeight / src.getHeight());
        g.drawRenderedImage(src, at);
        ImageIO.write(dest, "JPG", new File(destFile));

    }

    public String downloadFile() {

        this.urlImagem = pacientes.get(opcaoImagem).getUrlImagem();
        OperacoesArquivos.downloadFile(this.urlImagem, "C:/Documents and Settings/Igor/Meus documentos/trunk/BancoImagens/web/imagensPaciente/", "jpg", FacesContext.getCurrentInstance()); //colocar path do servidor
        return "gotoDownload";
    }


}
