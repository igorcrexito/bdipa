/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import Banco.Conexao.ConexaoBD;
import Banco.Conexao.QuestionarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Igor-Note
 */
@ManagedBean(name = "questBean")
@RequestScoped
public class QuestionarioBean {

    private int experienciaTracados;
    private int experienciaSoftware;
    private int avaliacaoApplet;
    private String sugestoesCriticas;
    private String formacaoAcademica;
    private String nomeCompleto;
    QuestionarioDAO questDAO = new QuestionarioDAO(ConexaoBD.getConexaoBD());
    /** Creates a new instance of QuestionarioBean */
    public QuestionarioBean(){

    }

    public int getAvaliacaoApplet() {
        return avaliacaoApplet;
    }

    public void setAvaliacaoApplet(int avaliacaoApplet) {
        this.avaliacaoApplet = avaliacaoApplet;
    }

    public int getExperienciaSoftware() {
        return experienciaSoftware;
    }

    public void setExperienciaSoftware(int experienciaSoftware) {
        this.experienciaSoftware = experienciaSoftware;
    }

    public int getExperienciaTracados() {
        return experienciaTracados;
    }

    public void setExperienciaTracados(int experienciaTracados) {
        this.experienciaTracados = experienciaTracados;
    }

    public String getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public void setFormacaoAcademica(String formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSugestoesCriticas() {
        return sugestoesCriticas;
    }

    public void setSugestoesCriticas(String sugestoesCriticas) {
        this.sugestoesCriticas = sugestoesCriticas;
    }

    public void cadastrarQuestionario() {
        
        questDAO.inserirQuestionario(experienciaTracados, experienciaSoftware, avaliacaoApplet, nomeCompleto, sugestoesCriticas, formacaoAcademica);

        this.experienciaSoftware = 0;
        this.experienciaTracados = 0;
        this.avaliacaoApplet = 0;
        this.formacaoAcademica = "";
        this.nomeCompleto = "";
        this.sugestoesCriticas = "";
    }

}

