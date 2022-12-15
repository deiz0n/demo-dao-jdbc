package dao;

import dao.impl.VendedorDaoJDBC;
import db.DB;

public class DaoFactory {

    public static VendedorDao criarVendedorDao() {
        return new VendedorDaoJDBC(DB.getConnection());
    }

}
