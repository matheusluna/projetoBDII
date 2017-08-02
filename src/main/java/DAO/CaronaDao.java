/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexao.ClasseConexao;
import conexao.ConnectionFactory;
import entidades.Carona;
import entidades.Pontos;
import interfaces.CaronaDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Reginaldo
 */
public class CaronaDao implements CaronaDaoIF {
    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;
    
    public CaronaDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }

    @Override
    public void inserir(Carona c) throws SQLException {
        try{ 
        conexao.abrir();
        String SQL = "insert into carona(idUsuario, origem, destino, horasaida, data, ajudadecusto) values (?,?,?,?,?,?)";
        pstm = con.prepareStatement(SQL);
        pstm.setInt(1, c.getIdUsuario());
        pstm.setString(2, c.getOrigem());
        pstm.setString(3, c.getDestino());
        pstm.setTime(4, c.getHora());
        pstm.setDate(5, (java.sql.Date) c.getData());
        pstm.setFloat(6, c.getAjudaDeCusto());
        
        pstm.executeUpdate();
        }catch(SQLException e){
               System.out.println(e);
        }
           finally {
                conexao.liberar();
        }
    }
    
    public void inserirPonto(Pontos p) throws SQLException {
        try{ 
        conexao.abrir();
        String SQL = "insert into pontos_adicionais(idCarona, ponto) values (?,?)";
        pstm = con.prepareStatement(SQL);
        pstm.setInt(1, p.getIdCarona());
        pstm.setString(2, p.getPonto());
        
        pstm.executeUpdate();
        }catch(SQLException e){
               System.out.println(e);
        }
           finally {
                conexao.liberar();
        }
    }

   
    @Override
    public List<Carona> pesquisarCarona(String Origem, String Destino) throws SQLException {
         List<Carona> caronas = new ArrayList<Carona>();
        try {
            conexao.abrir();
            
            String SQL = "";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();            
            
            while(result.next()){
                Carona carona = new Carona();
                carona.setIdUsuario(result.getInt("idusuario"));
                carona.setOrigem(result.getString("origem"));
                carona.setDestino(result.getString("destino"));
                carona.setHora(result.getTime("hora"));
                carona.setData(result.getDate("data"));
                carona.setAjudaDeCusto(result.getFloat("ajudadecusto"));
                
                caronas.add(carona);
            }
            return caronas;
            
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    } 
    
    public List<Carona> listarCarona() throws SQLException {
        List<Carona> caronas = new ArrayList<Carona>();
        try {
            conexao.abrir();
            
            String sql = "SELECT * FROM carona";
            
            pstm = con.prepareStatement(sql);
            
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                Carona carona = new Carona();
                carona.setIdUsuario(result.getInt("idUsuario"));
                carona.setOrigem(result.getString("origem"));
                carona.setDestino(result.getString("destino"));
                carona.setHora(result.getTime("hora"));
                carona.setData(result.getDate("data"));
                
                caronas.add(carona);
            }
            return caronas;
        } catch(Exception E) { 
            JOptionPane.showMessageDialog(null, E);
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
}
