/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.FileDownloadController;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author odontoradiosis
 */
public class Paciente {

    private int id;
    private int sexo;
    private int idade;
    private String urlImagem;
    private int raca;
    private String racareal;
    private String sexoreal;
    private FileDownloadController imagem = new FileDownloadController(urlImagem);

    public String getRacareal() {
//        switch (raca) {
//            case 0:
//                racareal = "Amarela";
//            case 1:
//                racareal = "Branca";
//            case 2:
//                racareal = "Parda";
//            case 3:
//                racareal = "Negra";
//             default:
//                racareal = "Não informado";
//        }
        if (raca == 0) {
            racareal = "Amarela";
        } else {
            if (raca == 1) {
                racareal = "Branca";
            } else {
                if (raca == 2) {
                    racareal = "Parda";
                } else {
                    if (raca == 3) {
                        racareal = "Negra";
                    } else {
                        racareal = "Não informado";
                    }
                }
            }
        }


        return racareal;
    }

    public void setRacareal(String racareal) {
        this.racareal = racareal;
    }

    public String getSexoreal() {
        switch (sexo) {
            case 0:
                sexoreal = "Feminino";
            case 1:
                sexoreal = "Masculino";
            default:
                racareal = "Server Error";
        }

        return sexoreal;
    }

    public void setSexoreal(String sexoreal) {
        this.sexoreal = sexoreal;
    }

    public Paciente() {
        this.urlImagem = null;
    }

    public Paciente(int id, int sexo, int idade, String urlImagem, int raca) {
        this.id = id;
        this.sexo = sexo;
        this.idade = idade;
        this.urlImagem = urlImagem;
        this.raca = raca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {

        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    public int getRaca() {
        return raca;
    }

    public void setRaca(int raca) {
        this.raca = raca;
    }

   public StreamedContent download (){

   return imagem.getFile();
   }

}
