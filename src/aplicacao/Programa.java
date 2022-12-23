package aplicacao;

import dao.DaoFactory;
import dao.VendedorDao;
import entidades.Departamento;
import entidades.Vendedor;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VendedorDao vendedorDao = DaoFactory.criarVendedorDao();

        System.out.println("=== Teste 1: Vendedor buscarPorId ===");
        Vendedor vendedor = vendedorDao.buscarPorId(3);
        System.out.println(vendedor);

        System.out.println("");
        System.out.println("=== Teste 2: Vendedor buscarPorDepartamento ===");

        Departamento departamento = new Departamento(2, null);

        List<Vendedor> list = vendedorDao.buscarPorDeparta(departamento);
        list.forEach(System.out::println);

        System.out.println("");
        System.out.println("=== Teste 4: Vendedor insert ===");

        Vendedor vendedor1 = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
        vendedorDao.inserir(vendedor1);
        System.out.println("Inserido! Novo ID = " + vendedor1.getId());

        System.out.println("");
        System.out.println("=== Teste 5: atualizar vendedor ===");
        vendedor = vendedorDao.buscarPorId(1);
        vendedor.setNome("Marta Waine");
        vendedorDao.atualizar(vendedor);
        System.out.println("Atualização completa");

        System.out.println("=== Teste 6: deletar vendedor ===");
        System.out.print("Digite o id do vendedor que deseja deletar: ");
        int n = sc.nextInt();
        vendedorDao.deletarPorId(n);
        System.out.println("Delete concluido");

        sc.close();

    }

}
