package fabricas;

import interfaces.CaronaDaoIF;
import interfaces.UsuarioDaoIF;

public interface DaoFactoryIF {
    
    public UsuarioDaoIF criaUsuarioDao();
    
    public CaronaDaoIF criaCaronaDao();
}
