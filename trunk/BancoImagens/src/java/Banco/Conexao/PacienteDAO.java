/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Banco.Conexao;

import DAO.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author odontoradiosis
 */
public class PacienteDAO {
    
   private Paciente paciente;
   private ConexaoBD conexao;

    public PacienteDAO(ConexaoBD conexao) {
        this.conexao = conexao;
    }

    public Paciente getPacienteFromId(int id) throws SQLException {

        String SQL_string = "SELECT * FROM pacientes WHERE " +
                "Id LIKE '%" + id + "%'";

        ResultSet rs= conexao.executeSql(SQL_string);
        rs.first();

        int sexo = rs.getInt("sexo");
        int idade = rs.getInt("idade");
        String urlImagem = rs.getString("urlImagem");

        paciente = new Paciente(id,sexo,idade,urlImagem);

        return paciente;
    }


    public void inserirPaciente(int id, int sexo, int idade, String urlImagem) {

        String SQL_String = "INSERT INTO pacientes (id, sexo, idade, urlImagem)" +
                " VALUES ('" + id + "', '" + sexo + "', '" + idade + "', '" + urlImagem+"')";

         conexao.execute(SQL_String);
    }


    public void excluirPaciente(int id) throws SQLException{

        String SQL_String = "delete from pacientes where id='" + id + "'";
        conexao.executeSql(SQL_String);
    }


      public void alteraIdadeById (int idadeNova, String id) {

        String SQL_String = "UPDATE pacientes SET idade = '" + idadeNova + "'WHERE id = '" + id + "'";
        conexao.executeSql(SQL_String);

    }

}
