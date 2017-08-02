/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexao.ClasseConexao;
import conexao.ConnectionFactory;
import entidades.Usuario;
import interfaces.UsuarioDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Reginaldo
 */
public class UsuarioDao implements UsuarioDaoIF{
    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;
    
    public UsuarioDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
  
    @Override
    public void inserir(Usuario usuario) throws SQLException {

       try{ 
        conexao.abrir();
        String SQL = "insert into usuario(nome, email, datadenascimento, senha, sexo, telefone) values (?,?,?,?,?,?)";
        pstm = con.prepareStatement(SQL);
        pstm.setString(1, usuario.getNome());
        pstm.setString(2, usuario.getEmail());
        pstm.setDate(3, (java.sql.Date) usuario.getDataNascimento());
        pstm.setString(4, usuario.getSenha());
        pstm.setString(5, usuario.getSexo());
        pstm.setString(6, usuario.getTelefone());
        pstm.executeUpdate();
        }catch(SQLException e){
               JOptionPane.showMessageDialog(null, e);
        }
           finally {
                conexao.liberar();
        }
    }
    
    @Override
    public Usuario getUsuario(String email) throws SQLException {
        try {
            conexao.abrir();
            String sql = "SELECT * FROM usuario WHERE email=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, email);
            ResultSet result = pstm.executeQuery();
            
            Usuario usuario = new Usuario();
            if (result.next()) {
                usuario.setId(result.getInt("idusuario"));
                usuario.setEmail(result.getString("email"));
                usuario.setNome(result.getString("nome"));
                usuario.setSenha(result.getString("senha"));
                usuario.setSexo(result.getString("sexo"));
                usuario.setTelefone(result.getString("telefone"));
                usuario.setDataNascimento(result.getDate("datadenascimento"));
                return usuario;
            }
              } catch(Exception E) { 
                    JOptionPane.showMessageDialog(null, E);
               } finally {
            conexao.liberar();
        }
        return null;    
    }
    
    public boolean logar(String email, String senha) throws SQLException {

        try {
            conexao.abrir();
       
            String SQL = "SELECT * FROM usuario WHERE email = ?";
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, email);
            
            ResultSet result = pstm.executeQuery();
            
            Usuario usuario = new Usuario();
            
            while(result.next()){
                usuario.setId(result.getInt("idusuario"));
                usuario.setEmail(result.getString("email"));
                usuario.setNome(result.getString("nome"));
                usuario.setSenha(result.getString("senha"));
                usuario.setSexo(result.getString("sexo"));
                usuario.setTelefone(result.getString("telefone"));
                usuario.setDataNascimento(result.getDate("datadenascimento"));
                
            }
            
            if (usuario.getEmail()!= null && usuario.getSenha() != null){
                if (usuario.getEmail().equalsIgnoreCase(email) 
                        && usuario.getSenha().equalsIgnoreCase(senha)){
                    return true;
                }
                else 
                    return false;
            }
            else
                return false;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return false;
    }
    
}
