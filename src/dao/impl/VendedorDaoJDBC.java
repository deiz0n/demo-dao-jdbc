package dao.impl;

import dao.VendedorDao;
import db.DB;
import db.DbException;
import entidades.Departamento;
import entidades.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendedorDaoJDBC implements VendedorDao {

    private Connection conn;

    public VendedorDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Vendedor vendedor) {

    }

    @Override
    public void atualizar(Vendedor vendedor) {

    }

    @Override
    public void deletarPorId(Integer id) {

    }

    @Override
    public Vendedor buscarPorId(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE seller.Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Departamento departamento = instanciarDepartamento(rs);

                Vendedor vendedor = instaciarVendedor(rs, departamento);
                return vendedor;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Vendedor instaciarVendedor(ResultSet rs, Departamento departamento) throws SQLException {
        Vendedor vendedor = new Vendedor();
        vendedor.setId(rs.getInt("Id"));
        vendedor.setNome(rs.getString("Name"));
        vendedor.setEmail(rs.getString("Email"));
        vendedor.setSalarioBase(rs.getDouble("BaseSalary"));
        vendedor.setDataAniversario(rs.getDate("BirthDate"));
        vendedor.setDepartamento(departamento);
        return vendedor;
    }

    private Departamento instanciarDepartamento(ResultSet rs) throws SQLException {
        Departamento departamento = new Departamento();
        departamento.setId(rs.getInt("DepartmentId"));
        departamento.setnome(rs.getString("DepName"));
        return departamento;
    }

    @Override
    public List<Vendedor> buscarTodos() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "ORDER BY Name");


            rs = st.executeQuery();

            List<Vendedor> list = new ArrayList<>();
            Map<Integer, Departamento> map = new HashMap<>();

            while (rs.next()) {

                Departamento dep = map.get(rs.getInt("DepartmentId"));

                if (dep == null) {
                    dep = instanciarDepartamento(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                dep = instanciarDepartamento(rs);
                Vendedor vendedor = instaciarVendedor(rs, dep);
                list.add(vendedor);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Vendedor> buscarPorDeparta(Departamento departamento) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE DepartmentId = ? "
                    + "ORDER BY Name");

            st.setInt(1, departamento.getId());
            rs = st.executeQuery();

            List<Vendedor> list = new ArrayList<>();
            Map<Integer, Departamento> map = new HashMap<>();

            while (rs.next()) {

                Departamento dep = map.get(rs.getInt("DepartmentId"));

                if (dep == null) {
                    dep = instanciarDepartamento(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                dep = instanciarDepartamento(rs);
                Vendedor vendedor = instaciarVendedor(rs, dep);
                list.add(vendedor);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
