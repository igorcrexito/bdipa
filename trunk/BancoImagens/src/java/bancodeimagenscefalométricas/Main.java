/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodeimagenscefalométricas;

import Banco.Conexao.ConexaoBD;
import Banco.Conexao.PaginaDAO;
import Banco.Conexao.PacienteDAO;
import Banco.Conexao.UsuarioDAO;
import DAO.Paciente;
import DAO.Usuario;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author odontoradiosis
 */
public class Main {

    static UsuarioDAO userDao = new UsuarioDAO(ConexaoBD.getConexaoBD());
    static PacienteDAO pacDao = new PacienteDAO(ConexaoBD.getConexaoBD());
    static PaginaDAO conteudoDao = new PaginaDAO();

    //CLASSE DE TESTE ==> TESTAR MÉTODOS DE UTILIZAÇÃO DO BANCO
    public static void main(String[] args) throws SQLException {

        ////////////////////////////////////////////////////////////////////////
        // TESTE PARA INSERIR PACIENTE NO BANCO DE DADOS
       // pacDao.inserirPaciente(3, 2, 01, "www.teste.com");



        ////////////////////////////////////////////////////////////////////////
        //TESTE PARA EXCLUIR PACIENTE DO BANCO DE DADOS
        /*pacDao.excluirPaciente(1);*/



        ////////////////////////////////////////////////////////////////////////
        //TESTE PARA INSERIR USUARIO NO BANCO DE DADOS
        //userDao.inserirUsuario("123", "Joao Pedroh", "Unifachs", "joao@unifacs.comh", 0, "12345", "ri", "hd");



        ////////////////////////////////////////////////////////////////////////
        //TESTE PARA EXCLUIR USUARIO DO BANCO DE DADOS
        /*userDao.excluirUsuario("uh");*/



        ////////////////////////////////////////////////////////////////////////
        //TESTE PARA INSERIR CONTEUDO NO BANCO DE DADOS
        /*conteudoDao.inserirConteudo("conteudo01", "Raio-x", "O raio-x é muito importante", "home");*/



        ////////////////////////////////////////////////////////////////////////
        //TESTE PARA EXCLUIR CONTEUDO DO BANCO DE DADOS
        /*conteudoDao.excluirConteudo("sgsgsg");*/



        ////////////////////////////////////////////////////////////////////////
        //TESTE PARA RESGATAR USUARIO PELO LOGIN DO BANCO DE DADOS
        Usuario user = userDao.getUsuariosFromLoginSenha("m", "12345");
        System.out.println("nome: "+ user.getNome());
        System.out.println("rg: " + user.getRg());



        ////////////////////////////////////////////////////////////////////////
        // TESTE PARA RESGATAR PACIENTE NO BANCO COM BASE NO ID
        /*Paciente pac;
        pac = pacDao.getPacienteFromId(1);
        System.out.println("sexo: "+ pac.getSexo());
        System.out.println("idade: "+ pac.getIdade());
        System.out.println("url da imagem: "+ pac.getUrlImagem());*/
        //userDao.excluirUsuario("c");
        ////////////////////////////////////////////////////////////////////////
        // TESTE PARA
        //userDao.alteraNomeByRg("Paulo", "111");
        // pacDao.alteraIdadeById(25, "1");



                ////////////////////////////////////////////////////////
        // TESTE PARA RESGATAR USUARIO COM BASE NO RG
        /*Usuario usuario;
        usuario = userDao.getUsuarioRG("12");
        System.out.println("RG: "+ usuario.getRg());
        System.out.println("nome: "+ usuario.getNome());
        System.out.println("instituição: "+ usuario.getInstituicao());
        System.out.println("Email: "+ usuario.getEmail());
        System.out.println("Nível Acesso: "+ usuario.getNivelAcesso());*/
    }
}
