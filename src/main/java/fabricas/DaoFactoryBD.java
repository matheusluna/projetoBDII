package fabricas;

import DAO.CaronaDao;
import DAO.UsuarioDao;
import interfaces.CaronaDaoIF;
import interfaces.UsuarioDaoIF;

public class DaoFactoryBD implements DaoFactoryIF{
    
    private DaoFactoryBD instance;

    @Override
    public UsuarioDaoIF criaUsuarioDao() {
        return new UsuarioDao();
    }
    
    public CaronaDaoIF criaCaronaDao() {
        return new CaronaDao();
    }

  
}
