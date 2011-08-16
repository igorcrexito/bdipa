/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

public class Conteudo {

    private String referencia;
    private String tituloTexto;
    private String texto;
    private String paginaLocalizado;

    public Conteudo(String referencia, String tituloTexto, String texto, String paginaLocalizado) {
        this.referencia = referencia;
        this.tituloTexto = tituloTexto;
        this.texto = texto;
        this.paginaLocalizado = paginaLocalizado;
    }

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

    public String getTituloTexto() {
        return tituloTexto;
    }

    public void setTituloTexto(String tituloTexto) {
        this.tituloTexto = tituloTexto;
    }
}
