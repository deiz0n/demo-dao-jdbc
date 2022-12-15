package dao;

import dao.impl.VendedorDaoJDBC;

public class DaoFactory {

    public static VendedorDao criarVendedorDao() {
        return new VendedorDaoJDBC();
    }

}
