package interfaces;

import entidades.Carona;
import entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDaoIF {
    
    public void inserir(Usuario u)throws SQLException;
    
    public Usuario getUsuario(String email) throws SQLException;
    
    public boolean logar(String email, String senha)throws SQLException; 
    
}
