package beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Banco.Conexao.ConexaoBD;
import Banco.Conexao.ConteudoDAO;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Rafael
 */
@ManagedBean
@ApplicationScoped
public class pagesBean {

    private String campo1,campo2,campo3,TituloTextoCampo1;
    ConteudoDAO conteudoDAO = new ConteudoDAO(ConexaoBD.getConexaoBD());

    public String getCampo1() {
        try {
         
          campo1= conteudoDAO.getConteudoRefencia("1").getTexto();

        } catch (Exception ex) {
           
            //Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return campo1;
    }
    public String getTituloTextoCampo1(){
     try {

          TituloTextoCampo1= conteudoDAO.getConteudoRefencia("1").getTituloTexto();

        } catch (Exception ex) {

            //Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return TituloTextoCampo1;

    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {


        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public String getCampo3() {
        return campo3;
    }

    public void setCampo3(String campo3) {
        this.campo3 = campo3;
    }

    /** Creates a new instance of pagesBean */

    public pagesBean() {

    }


}
