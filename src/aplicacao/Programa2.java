package aplicacao;

import dao.DaoFactory;
import dao.DepartamentoDao;
import dao.VendedorDao;
import entidades.Departamento;

import java.util.List;
import java.util.Scanner;

public class Programa2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartamentoDao depDao = DaoFactory.criarDepartamentoDao();

        Departamento dep = new Departamento(6, "Games");
        depDao.inserir(dep);
        System.out.println("--- TESTE 1: INSERÇÃO DE DEPARTAMENTO ---");
        System.out.println();

        System.out.println("--- TESTE 2: DELETE BY ID ---");
        System.out.print("Insira o id para deletar um departamento: ");
        int x = sc.nextInt();
        depDao.deletarPorId(x);
        System.out.println("O delete foi realizado com sucesso");

        System.out.println("--- TESTE 3: BUSCAR POR ID ---");
        Departamento seach = depDao.buscarPorId(4);
        System.out.println(seach);
        System.out.println();

        System.out.println("--- TESTE 4: UPDATE DE DADOS ---");
        seach = depDao.buscarPorId(1);
        seach.setnome("PC Gamer");
        depDao.atualizar(seach);
        System.out.println("A atualização foi concluída com sucesso");
        System.out.println();

        System.out.println("--- TESTE 5: BUSCAR TODOS ---");
        List<Departamento> list = depDao.buscarTodos();
        list.forEach(System.out::println);

        sc.close();

    }

}
