package dao;


import entidades.Departamento;
import entidades.Vendedor;

import java.util.List;

public interface VendedorDao {

    void inserir(Vendedor vendedor);
    void atualizar(Vendedor vendedor);
    void deletarPorId(Integer id);
    Vendedor buscarPorId(Integer id);
    List<Vendedor> buscarTodos();
    List<Vendedor> buscarPorDeparta(Departamento departamento);

}
