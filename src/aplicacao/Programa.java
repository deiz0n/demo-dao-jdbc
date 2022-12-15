package aplicacao;

import dao.DaoFactory;
import dao.VendedorDao;
import entidades.Departamento;
import entidades.Vendedor;

public class Programa {

    public static void main(String[] args) {

        VendedorDao vendedorDao = DaoFactory.criarVendedorDao();

        System.out.println("=== Teste 1: Vendedor buscarPorId ===");
        Vendedor vendedor = vendedorDao.buscarPorId(3);

        System.out.println(vendedor);

    }

}
