package dao;

import dao.impl.DepartamentoDaoJDBC;
import dao.impl.VendedorDaoJDBC;
import db.DB;

public class DaoFactory {

    public static VendedorDao criarVendedorDao() {
        return new VendedorDaoJDBC(DB.getConnection());
    }

    public static DepartamentoDao criarDepartamentoDao() {
        return new DepartamentoDaoJDBC(DB.getConnection());
    }

}
