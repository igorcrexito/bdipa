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
import classes.Propriedades;
import classes.TiffUtils;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    boolean filtroflag = false;
    private List<Paciente> pacientes;
    PacienteDAO pacDao = new PacienteDAO(ConexaoBD.getConexaoBD());
    private int idade;
    private String urlImagem;
    private int sexo;
    private int raca;
    private int opcaoImagem;
    private List<SelectItem> colecao;
    private int filtroidadeinicial = 0;
    private int filtroidadefinal = 0;
    private int filtroraca = 4;
    private int filtrosexo = 2;
    boolean flagidade = false;
    boolean flagsexo = false;
    boolean flagraca = false;
    boolean isTiff = false;

    public List<SelectItem> getColecao() {
        colecao = new ArrayList<SelectItem>();
        for (int i = 0; i < pacientes.size(); i++) {
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
        if (!filtroflag) {
            try {
                this.pacientes = pacDao.getTodosPacientesLista();
            } catch (SQLException ex) {
                Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String filtrar() {

        flagidade = false;
        flagraca = false;
        flagsexo = false;

        if (this.filtroidadefinal != 0 && this.filtroidadeinicial < this.filtroidadefinal) {
            flagidade = true;
        }
        if (this.filtroraca != 4) {
            flagraca = true;
        }
        if (this.filtrosexo != 2) {
            flagsexo = true;
        }

        ArrayList<Paciente> pacfiltrados = new ArrayList<Paciente>();
        try {
            this.pacientes = pacDao.getTodosPacientesLista();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < pacientes.size(); i++) {
            if (flagidade == true && flagraca == false && flagsexo == false) {
                if ((pacientes.get(i).getIdade() >= this.filtroidadeinicial && pacientes.get(i).getIdade() <= this.filtroidadefinal)) {
                    pacfiltrados.add(pacientes.get(i));
                }
            }

            if (flagidade == false && flagraca == true && flagsexo == false) {
                if (pacientes.get(i).getRaca() == this.filtroraca) {
                    pacfiltrados.add(pacientes.get(i));
                }
            }

            if (flagidade == false && flagraca == false && flagsexo == true) {
                if (pacientes.get(i).getSexo() == this.filtrosexo) {
                    pacfiltrados.add(pacientes.get(i));
                }
            }

            if (flagidade == true && flagraca == true && flagsexo == false) {
                if ((pacientes.get(i).getIdade() >= this.filtroidadeinicial && pacientes.get(i).getIdade() <= this.filtroidadefinal)) {
                    if (pacientes.get(i).getRaca() == this.filtroraca) {
                        pacfiltrados.add(pacientes.get(i));
                    }
                }
            }

            if (flagidade == true && flagraca == false && flagsexo == true) {
                if ((pacientes.get(i).getIdade() >= this.filtroidadeinicial && pacientes.get(i).getIdade() <= this.filtroidadefinal)) {
                    if (pacientes.get(i).getSexo() == this.filtrosexo) {
                        pacfiltrados.add(pacientes.get(i));
                    }
                }
            }

            if (flagidade == false && flagraca == true && flagsexo == true) {
                if (pacientes.get(i).getRaca() == this.filtroraca) {
                    if (pacientes.get(i).getSexo() == this.filtrosexo) {
                        pacfiltrados.add(pacientes.get(i));
                    }
                }
            }


            if (flagidade == true && flagraca == true && flagsexo == true) {
                if ((pacientes.get(i).getIdade() >= this.filtroidadeinicial && pacientes.get(i).getIdade() <= this.filtroidadefinal)) {
                    if (pacientes.get(i).getRaca() == this.filtroraca) {
                        if (pacientes.get(i).getSexo() == this.filtrosexo) {
                            pacfiltrados.add(pacientes.get(i));
                        }
                    }
                }
            }



        }

        pacientes = pacfiltrados;
        filtroflag = true;
        return "galeria.xhtml";
    }

    public String resetar() {

        filtroflag = false;
        flagidade = false;
        flagsexo = false;
        flagraca = false;
        this.filtroidadefinal = 0;
        this.filtroidadefinal = 0;
        this.filtroraca = 4;
        this.filtrosexo = 2;
        return "galeria.xhtml";
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

            URL urlArquivo = getClass().getClassLoader().getResource("resources");
            String url = urlArquivo.getPath().replaceAll("%20", " ");

            InputStream in = new BufferedInputStream(arq.getInputstream());
            File file = new File(url + arq.getFileName());

            urlImagem = "reduzida" + arq.getFileName();

            FileOutputStream fout = new FileOutputStream(file);

            while (in.available() != 0) {

                fout.write(in.read());

            }
            //cadastrar();
            fout.close();

            String caminho = Propriedades.retornaCaminho();

            scale(url + arq.getFileName(), 600, 600, caminho + arq.getFileName());

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

    public void scale(String srcFile, int destWidth, int destHeight,
       String destFile) throws IOException {

        String caminho = Propriedades.retornaCaminho();
        if (srcFile.contains(".tif")) {
            isTiff = true;
            String vec[] = urlImagem.split(".tif");
            String vec2[] = vec[0].split("reduzida");

            TiffUtils.TiffToJpg(srcFile, caminho + vec2[1] + ".jpg");

            BufferedImage src = ImageIO.read(new File(caminho + vec2[1] + ".jpg"));
            BufferedImage dest = new BufferedImage(destWidth, destHeight,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = dest.createGraphics();

            AffineTransform at = AffineTransform.getScaleInstance(
                    (double) destWidth / src.getWidth(),
                    (double) destHeight / src.getHeight());
            g.drawRenderedImage(src, at);
            ImageIO.write(dest, "JPG", new File(caminho + vec2[1] + ".jpg"));

        } else {
            isTiff = false;
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

    }

    public String downloadFile() {

        for (int i = 0; i < pacientes.size(); i++) {
            if (this.opcaoImagem == pacientes.get(i).getId()) {
                this.urlImagem = pacientes.get(i).getUrlImagem();
                this.urlImagem = urlImagem.substring(8);
                break;
            }
        }
        URL urlArquivo = getClass().getClassLoader().getResource("resources");
        String url = urlArquivo.getPath().replaceAll("%20", " ");
        //url = "/C:/Documents and Settings/Igor-Note/Desktop/trunk/BancoImagens/build/web/WEB-INF/classes/imagensPaciente/";
        System.out.println(url);
        OperacoesArquivos.downloadFile(this.urlImagem, url, "jpg", FacesContext.getCurrentInstance()); //colocar path do servidor
        return "gotoDownload";
    }

    public int getFiltroidadefinal() {
        return filtroidadefinal;
    }

    public void setFiltroidadefinal(int filtroidadefinal) {
        this.filtroidadefinal = filtroidadefinal;
    }

    public int getFiltroidadeinicial() {
        return filtroidadeinicial;
    }

    public void setFiltroidadeinicial(int filtroidadeinicial) {
        this.filtroidadeinicial = filtroidadeinicial;
    }

    public int getFiltroraca() {
        return filtroraca;
    }

    public void setFiltroraca(int filtroraca) {
        this.filtroraca = filtroraca;
    }

    public int getFiltrosexo() {
        return filtrosexo;
    }

    public void setFiltrosexo(int filtrosexo) {
        this.filtrosexo = filtrosexo;
    }
}
