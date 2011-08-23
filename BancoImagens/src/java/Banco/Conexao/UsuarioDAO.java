package Banco.Conexao;

import DAO.Paciente;
import DAO.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author odontoradiosis
 */
public class UsuarioDAO {

    private Usuario usuario;
    private ConexaoBD conexao;
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public UsuarioDAO(ConexaoBD conexao) {
        this.conexao = conexao;
    }

    public UsuarioDAO() {
    }

    public Usuario getUsuarioRG(String rg) throws SQLException {

        String SQL_string = "SELECT * FROM usuario WHERE "
                + "RG LIKE '%" + rg + "%'";
        ResultSet rs = conexao.executeSql(SQL_string);
        rs.first();
        String instituicao = rs.getString("instituicao");
        String nome = rs.getString("nome");
        String email = rs.getString("email");
        int nivelAcesso = rs.getInt("nivelAcesso");
        ;
        String justificativa = rs.getString("justificativa");
        String senha = rs.getString("senha");
        String login = rs.getString("login");
        usuario = new Usuario(rg, instituicao, nome, email, nivelAcesso, senha, login, justificativa);
        return usuario;
    }

    public ArrayList<Usuario> getUsuariosFromNome(String nome) throws SQLException {

        String SQL_string = "SELECT * FROM usuario WHERE "
                + "nome LIKE '%" + nome + "%'";
        ResultSet rs = conexao.executeSql(SQL_string);
        while (rs.next()) {
            String rg = rs.getString("RG");
            String instituicao = rs.getString("instituicao");
            String email = rs.getString("email");
            int nivelAcesso = rs.getInt("nivelAcesso");
            String senha = rs.getString("senha");
            String login = rs.getString("login");
            String justificativa = rs.getString("justificativa");
            usuarios.add(new Usuario(rg, instituicao, nome, email, nivelAcesso, senha, login, justificativa));
        }
        return usuarios;
    }

    public void inserirUsuario(String rg, String nome, String instituicao, String email, int nivelAcesso, String senha, String login, String justificativa) {

        String SQL_String = "INSERT INTO usuario (RG, nome, instituicao, email, nivelAcesso, senha, login, justificativa)"
                + " VALUES ('" + rg + "', '" + nome + "', '" + instituicao + "', '" + email + "', '" + nivelAcesso
                + "', '" + senha + "', '" + login + "', '" + justificativa + "')";

        conexao.execute(SQL_String);
    }

    public void excluirUsuario(String rg) throws SQLException {

        String SQL_String = "delete from usuario where rg='" + rg + "'";
        //conexao.executeSql(SQL_String);
        conexao.execute(SQL_String);
    }

    public void alteraNomeByRg(String novoNome, String rg) {

        String SQL_String = "UPDATE usuario SET nome = '" + novoNome + "'WHERE rg = '" + rg + "'";
        conexao.executeSql(SQL_String);
    }

    public Usuario getUsuariosFromLoginSenha(String login, String senha) throws SQLException {

        String SQL_string = "SELECT * FROM usuario WHERE "
                + "login LIKE'%" + login + "'";


        ResultSet rs = conexao.executeSql(SQL_string);
        rs.first();


            System.out.println("Senha login:" + rs.getString("senha"));
            System.out.println("Senha login:" + senha);

            String nome = rs.getString("nome");
            int nivel = rs.getInt("nivelAcesso");
            String instituicao = rs.getString("instituicao");
            String email = rs.getString("email");
            String rg = rs.getString("RG");
            String justificativa = rs.getString("justificativa");

            if (senha.equals(rs.getString("senha"))) {
                return new Usuario(rg, instituicao, nome, email, nivel, senha, login, justificativa);
            } else {
                return null;
            }

    }
}
