/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Banco.Conexao.ConexaoBD;
import Banco.Conexao.ConteudoDAO;
import Banco.Conexao.PacienteDAO;
import Banco.Conexao.UsuarioDAO;
import DAO.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author 
 */
@ManagedBean
@ApplicationScoped
public class conteudoBean {

    String referencia;
    String titulo;
    String texto;
    String paginaLocalizado;
    ConteudoDAO conteudo = new ConteudoDAO(ConexaoBD.getConexaoBD());

    public String getPaginaLocalizado() {
        return paginaLocalizado;
    }

    public void setPaginaLocalizado(String paginaLocalizado) {
        this.paginaLocalizado = paginaLocalizado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void carregaTexto() {
        try {
            this.texto = conteudo.getConteudoRefencia(referencia).getTexto();
        } catch (Exception ex) {
            Logger.getLogger(conteudoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarTexto() {
        try {
            System.out.println(referencia);
             System.out.println(titulo);
              System.out.println(texto);
               System.out.println(paginaLocalizado);
           conteudo.inserirConteudo(referencia, titulo, texto, paginaLocalizado);
        }
        catch(Exception ex){
            
        }

    }

}
