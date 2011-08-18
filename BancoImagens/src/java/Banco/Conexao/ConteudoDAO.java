/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco.Conexao;

import DAO.Conteudo;
import DAO.Paciente;
import DAO.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConteudoDAO {

    private ConteudoDAO conteudoDAO;
    private Conteudo conteudo;
    private ConexaoBD conexao;

    public ConteudoDAO(ConexaoBD conexao) {
        this.conexao = conexao;
    }

    public ConteudoDAO() {
    }

     public void inserirConteudo(String referencia, String tituloTexto, String texto, String paginaLocalizado) {

        String SQL_String = "INSERT INTO conteudo (referencia, tituloTexto, texto, paginaLocalizado)"
                + " VALUES ('" + referencia + "', '" + tituloTexto + "', '" + texto + "', '" + paginaLocalizado + "')";

        conexao.execute(SQL_String);
    }

     public Conteudo getConteudoRefencia(String referencia) throws SQLException{

         String SQL_string = "SELECT * FROM conteudo WHERE " +
                "referencia LIKE '%" + referencia + "%'";

        ResultSet rs= conexao.executeSql(SQL_string);
        rs.first();
        String tituloTexto = rs.getString("tituloTexto");
        String texto = rs.getString("texto");
        String paginaLocalizado = rs.getString("paginaLocalizado");

        conteudo = new Conteudo(referencia, tituloTexto, texto, paginaLocalizado);
        System.out.println(conteudo.getTexto());
        return conteudo;

     }

}
