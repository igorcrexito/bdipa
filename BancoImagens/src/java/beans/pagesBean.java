package beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Banco.Conexao.ConexaoBD;
import Banco.Conexao.PaginaDAO;
import classes.Pagina;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Rafael
 */
@ManagedBean(name="pagBean")
@ApplicationScoped

public class pagesBean {

    private ArrayList<String> conteudos = new ArrayList<String>();
    private int referencia;
    private String campoAtual;
    PaginaDAO pagDAO  = new PaginaDAO();
    private String nome;
    public String campo1,campo2,campo3,campo4;

    public pagesBean () {
       conteudos.add(campo1);conteudos.add(campo2);conteudos.add(campo3);conteudos.add(campo4);
    }

    public void carregaTexto() {
        Pagina pag = null;
        try {
            ConexaoBD.getConexaoBD().conecta();
            pag = pagDAO.getPaginaFromNome(nome);
        } catch (SQLException ex) {
            Logger.getLogger(pagesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (pag!=null) {
            this.conteudos = pag.getConteudo();
        }
        campoAtual = conteudos.get(referencia);
        ConexaoBD.getConexaoBD().desconecta();
    }

    public void salvaTexto() {
        ConexaoBD.getConexaoBD().conecta();
        this.conteudos.set(referencia, campoAtual);
        pagDAO.updateConteudo(nome, conteudos);
        ConexaoBD.getConexaoBD().desconecta();
    }
   
    public void acionaHome() {
        nome = "home";
        Pagina pag=null;
        try {
            ConexaoBD.getConexaoBD().conecta();
            pag = pagDAO.getPaginaFromNome(nome);
            
        } catch (SQLException ex) {
            Logger.getLogger(pagesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         nome = pag.getNome();
         this.conteudos = pag.getConteudo();
         ConexaoBD.getConexaoBD().desconecta();
    }

     public void acionaPrincipaisAnalises() {
        nome = "principaisanalises";
        Pagina pag=null;
        try {
            ConexaoBD.getConexaoBD().conecta();
            pag = pagDAO.getPaginaFromNome(nome);
            
        } catch (SQLException ex) {
            Logger.getLogger(pagesBean.class.getName()).log(Level.SEVERE, null, ex);
        }

         nome = pag.getNome();
         this.conteudos = pag.getConteudo();
         ConexaoBD.getConexaoBD().desconecta();
    }

     public void acionaPrincipaisTeoricos() {
        nome = "principaisteoricos";
        Pagina pag=null;
        try {
            ConexaoBD.getConexaoBD().conecta();
            pag = pagDAO.getPaginaFromNome(nome);
            ConexaoBD.getConexaoBD().desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(pagesBean.class.getName()).log(Level.SEVERE, null, ex);
        }

         nome = pag.getNome();
         this.conteudos = pag.getConteudo();
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getCampoAtual() {
        return campoAtual;
    }

    public void setCampoAtual(String campoAtual) {
        this.campoAtual = campoAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCampo1() {
        campo1 = this.conteudos.get(0);
        return campo1;
    }

    public String getCampo2() {
        campo2 = this.conteudos.get(1);
        return campo2;
    }

    public String getCampo3() {
        campo3 = this.conteudos.get(2);
        return campo3;
    }

    public String getCampo4() {
        campo4 = this.conteudos.get(3);
        return campo4;
    }

}
