/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Carona;
import entidades.Pontos;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public interface CaronaDaoIF {
    public void inserir(Carona c)throws SQLException;
    public void inserirPonto(Pontos p) throws SQLException;
    public List<Carona> pesquisarCarona(String Origem, String Destino) throws SQLException;
    public List<Carona> listarCarona() throws SQLException;
}
