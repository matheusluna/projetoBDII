/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadores;

import converterInformacao.ConverterData;
import entidades.Carona;
import entidades.Pontos;
import fabricas.DaoFactory;
import fabricas.DaoFactoryIF;
import interfaces.CaronaDaoIF;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public class GerenciadorDeCaronas{
    
    public void adicionarCarona(int idUsuario, String origem, String destino, Time horaSaida, Date data, Float ajudaDeCusto) throws SQLException{
        Carona novaCarona = new Carona();
        ConverterData d = new ConverterData();
        novaCarona.setIdUsuario(idUsuario);
        novaCarona.setOrigem(origem);
        novaCarona.setDestino(origem);
        novaCarona.setHora(horaSaida);
        novaCarona.setData(data);
        novaCarona.setAjudaDeCusto(ajudaDeCusto);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        CaronaDaoIF carDao = fabrica.criaCaronaDao();
        carDao.inserir(novaCarona); 
    }
    
    public List<Carona> pesquisarCarona(String origem, String destino) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        CaronaDaoIF carDao = fabrica.criaCaronaDao();
        return carDao.pesquisarCarona(origem, destino);
    }
    
    public void adicionarPonto(int idCarona, String ponto) throws SQLException{
        Pontos novoPonto = new Pontos();
        novoPonto.setIdCarona(idCarona);
        novoPonto.setPonto(ponto);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        CaronaDaoIF carDao = fabrica.criaCaronaDao();
        carDao.inserirPonto(novoPonto); 
        
    }
    
    public List<Carona> listarCaronas() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        CaronaDaoIF carDao = fabrica.criaCaronaDao();
        return carDao.listarCarona();
    }
}
