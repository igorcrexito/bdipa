/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Banco.Conexao;

/**
 *
 * @author Igor-Note
 */
public class QuestionarioDAO {

    private ConexaoBD conexao;

    public QuestionarioDAO(ConexaoBD conexao) {
        this.conexao = conexao;
    }

      public void inserirQuestionario(int experienciaTracados, int experienciaSofts, int avaliacao, String nomeCompleto, String sugestoesCriticas, String formacao) {

        String SQL_String = "INSERT INTO questionario (Id, nome, formacao, experienciaArea, experienciaSofts, avaliacao, sugestoescriticas)"
                + " VALUES ('"+0+"', '" +nomeCompleto+ "', '" +formacao+ "', '" +experienciaTracados+ "', '" +experienciaSofts
                + "', '" +avaliacao+ "', '" +sugestoesCriticas+ "')";

        conexao.execute(SQL_String);
    }
}
