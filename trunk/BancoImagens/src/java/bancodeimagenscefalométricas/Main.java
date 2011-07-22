/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bancodeimagenscefalométricas;

import Banco.Conexao.ConexaoBD;
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

    /**
     * @param args the command line arguments
     */
//CLASSE DE TESTE ==> TESTAR MÉTODOS DE UTILIZAÇÃO DO BANCO
    public static void main(String[] args) throws SQLException {

        //CONECTANDO AO BANCO DE DADOS
        UsuarioDAO userDao = new UsuarioDAO(ConexaoBD.getConexaoBD());
        PacienteDAO pacDao = new PacienteDAO(ConexaoBD.getConexaoBD());


        ////////////////////////////////////////////////////////
        // TESTE PARA RESGATAR USUARIO COM BASE NO RG
        /*Usuario usuario;
        usuario = userDao.getUsuarioRG("5");
        System.out.println("RG: "+ usuario.getRg());
        System.out.println("nome: "+ usuario.getNome());
        System.out.println("instituição: "+ usuario.getInstituicao());
        System.out.println("Email: "+ usuario.getEmail());
        System.out.println("Nível Acesso: "+ usuario.getNivelAcesso());*/




        ////////////////////////////////////////////////////////
        // TESTE PARA INSERIR PACIENTE NO BANCO DE DADOS
        /*pacDao.inserirPaciente(3, 1, 12, "www.aqui.com");*/




        ////////////////////////////////////////////////////////
        // TESTE PARA INSERIR PACIENTE NO BANCO DE DADOS
        //userDao.inserirUsuario("5", "Usuario Qualquer", "UNEB", "qualquer@gmail.com", 0);

        //userDao.alteraNomeByRg("Paulo", "111");
        pacDao.alteraIdadeById(25, "1");
        

        ///////////////////////////////////////////////////////////////////////
        // TESTE PARA RESGATAR PACIENTE NO BANCO COM BASE NO ID
        /*Paciente pac;
        pac = pacDao.getPacienteFromId(1);
        System.out.println("sexo: "+ pac.getSexo());
        System.out.println("idade: "+ pac.getIdade());
        System.out.println("url da imagem: "+ pac.getUrlImagem());*/





        //userDao.excluirUsuario("5");
        
    }
}
