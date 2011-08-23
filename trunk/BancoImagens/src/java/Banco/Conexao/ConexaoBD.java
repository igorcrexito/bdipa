package Banco.Conexao;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**Classe destinada a operações relacionadas ao Banco de Dados
 * "sistema3g"

 * @author Yoka Sistemas

 * @version full

 * @since Release 01 da aplicação

 */
public class ConexaoBD {

    private ResourceBundle config;
    private String DRIVER_JBDC;
    private String URL;
    private String usuario;
    private String senha;
    private Connection conexao;
    public Statement statement;
    public ResultSet resultSet;
    public PreparedStatement preparedeStatement;
    static private ConexaoBD referencia = null;//referência única para a conexão

    private ConexaoBD() {//construtor privado, pois ninguem poderá dar um new na classe

        this.DRIVER_JBDC = "com.mysql.jdbc.Driver";
        this.URL = "jdbc:mysql://localhost/pa_uefs";
        this.usuario = "root";
        this.senha = "admin";
        conecta();

    }

    /**
     * Retorna a Instância da Conexão com o Banco 3G.
     * @param void
     * @return conexao3G Instância do Objeto
     */
    static public ConexaoBD getConexaoBD() {

        if (referencia == null) {

            referencia = new ConexaoBD();
        }

        return referencia;
    }

    public boolean conecta() {
        boolean result = true;

        try {
            Class.forName(DRIVER_JBDC);
            conexao = DriverManager.getConnection(URL, usuario, senha);
            //JOptionPane.showMessageDialog(null,"Conectou");
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver não localizado: " + Driver);
            result = false;
        } catch (SQLException fonte) {
            JOptionPane.showMessageDialog(null, "Deu erro na conexão com a fonte de dados" + fonte);
            result = false;
        }
        return result;
    }

    /**Método para encerramento de conexão com o Banco de Dados
     *
     * @author Yoka Sistemas

     */
    public void desconecta() {
        boolean result = true;

        try {
            conexao.close();
            //JOptionPane.showMessageDialog(null,"Banco fechado");
        } catch (SQLException fechar) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar o banco de dados: " + fechar);
            result = false;
        }
    }

    /**Método para executar comandos SQL
     *
     * @author Yoka Sistemas

     * @return Resultset - Um conjunto de resultados SQL é um conjunto de linhas de um banco de dados

     */
    public ResultSet executeSql(String sql) {
        ResultSet rs = null;

        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sql);


        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    /**Método para executar comandos SQL
     *
     * @author Yoka Sistemas

     */
    public void execute(String sql) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.execute(sql);
            //statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
