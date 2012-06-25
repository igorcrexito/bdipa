/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Igor-Note
 */
@ManagedBean
@RequestScoped
public class FiltroBean {

    /** Creates a new instance of FiltroBean */
    public FiltroBean() {
    }

    private int idadeinicial;
    private int idadefinal;
    private int raca;
    private int sexo;

    public int getIdadefinal() {
        return idadefinal;
    }

    public void setIdadefinal(int idadefinal) {
        this.idadefinal = idadefinal;
    }

    public int getIdadeinicial() {
        return idadeinicial;
    }

    public void setIdadeinicial(int idadeinicial) {
        this.idadeinicial = idadeinicial;
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

}
