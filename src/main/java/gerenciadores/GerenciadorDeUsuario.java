package gerenciadores;

import converterInformacao.ConverterData;
import entidades.Usuario;
import fabricas.DaoFactory;
import fabricas.DaoFactoryIF;
import interfaces.UsuarioDaoIF;
import java.sql.SQLException;
import java.util.Date;
//import java.util.List;

public class GerenciadorDeUsuario {
    
    public void adicionarUsuario(String nome, String email, Date dataNascimento, String senha, String sexo, String telefone) throws SQLException{
        Usuario novoUsuario = new Usuario();
        ConverterData data = new ConverterData();
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setDataNascimento(dataNascimento);
        novoUsuario.setSenha(senha);
        novoUsuario.setSexo(sexo);
        novoUsuario.setTelefone(telefone);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.inserir(novoUsuario); 
    }
    
    public Usuario pesquisarUsuarioEmail(String email) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.getUsuario(email);
    }
    
    public boolean logar(String email, String senha) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.logar(email, senha);
    }
    
//    public void removerUsuario(String email) throws SQLException{
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
//        usuDao.remover(email);
//    }
//    
//    public void atualizaUsuario(Usuario u) throws SQLException{
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
//        usuDao.atualizar(u);
//    }
//    
//    public List<Usuario> pesquisarUsuario(String nome) throws SQLException{
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
//        return usuDao.pesquisar(nome);
//    }
//    
//    public Usuario getUsuario(int id) throws SQLException {
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        UsuarioDaoIF usuario = fabrica.criaUsuarioDao();
//        return usuario.getUsuario(id);
//    }
//
//    public Usuario getUsuario(String email) throws SQLException {
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        UsuarioDaoIF usuario = fabrica.criaUsuarioDao();
//        return usuario.getUsuario(email);
//    }
//    
//    public void atualizarFotoPerfil(String caminho, int id) throws SQLException {
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        UsuarioDaoIF usuario = fabrica.criaUsuarioDao();
//        usuario.atualizarImagemPerfil(caminho, id);
//    }
//    
    
//    
//    public List<Usuario> listarUsuarios() throws SQLException{
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
//        return usuDao.listar();
//    }
//    
    
//    
//    public boolean verificarExistenciaEmail(String email) throws SQLException {
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        UsuarioDaoIF usuario = fabrica.criaUsuarioDao();
//        return usuario.verificarExistenciaEmail(email);
//    }
//    
//    public String retornaApelidoPeloId(int id){
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        UsuarioDaoIF usuario = fabrica.criaUsuarioDao();
//        return usuario.retornaApelidoPeloId(id);
//    }
    
}
