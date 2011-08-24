package Banco.Conexao;

import classes.Pagina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaginaDAO {

  private ConexaoBD conexao;

  public PaginaDAO() {
       conexao = ConexaoBD.getConexaoBD();
  }

   public Pagina getPaginaFromNome (String nome) throws SQLException {

        String SQL_string = "SELECT * FROM paginas WHERE " +
                "NOME LIKE'%" + nome + "%'";

        ResultSet rs= conexao.executeSql(SQL_string);
        rs.first();

        String campo1 = rs.getString("campo1");
        String campo2 = rs.getString("campo2");
        String campo3 = rs.getString("campo3");
        String campo4 = rs.getString("campo4");

        ArrayList<String> conteudo = new ArrayList<String>();
        conteudo.add(campo1);conteudo.add(campo2);conteudo.add(campo3);conteudo.add(campo4);

        return new Pagina(nome,conteudo);
        
    }

    public void updateConteudo(String nome,ArrayList<String> conteudo) {

        String tabela = "paginas";
        String SQL = "UPDATE " + tabela + " SET campo1 = '" + conteudo.get(0) + "' ,campo2 = '" + conteudo.get(1) +"' ,campo3 = '" + conteudo.get(2) +"' ,campo4 = '" + conteudo.get(3) +" 'WHERE nome = '" + nome + "'";

        conexao.execute(SQL);
    }


}
