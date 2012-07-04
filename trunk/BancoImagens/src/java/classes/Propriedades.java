/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import Banco.Conexao.ConexaoBD;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Igor-Note
 */
public class Propriedades {

    public static void criarPropriedades(ConexaoBD conexao) {
        Properties properties = new Properties();
        //setando as propriedades(key) e os seus valores(value)
        properties.setProperty("conexao.driver", conexao.getDRIVER_JBDC());
        properties.setProperty("conexao.url", conexao.getURL());
        properties.setProperty("conexao.usuario", conexao.getUsuario());
        properties.setProperty("conexao.senha", conexao.getSenha());
        try {
            FileOutputStream fos = new FileOutputStream("conexao.properties");
            properties.store(fos, "Propriedades de Conexão");
            fos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

    }

    public void carregarPropriedades(ConexaoBD conexao) {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("conexao.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Captura o valor da propriedade, através do nome da propriedade(Key)
        conexao.setUsuario(properties.getProperty("conexao.usuario"));
        conexao.setURL(properties.getProperty("conexao.url"));
        conexao.setDRIVER_JBDC(properties.getProperty("conexao.driver"));
        conexao.setSenha(properties.getProperty("conexao.senha"));

    }

}
