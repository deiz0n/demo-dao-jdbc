package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1l;

    private Integer id;
    private String nome;
    private String email;
    private Date dataAniversario;
    private Double salarioBase;

    private Departamento Vendedor;

    public Vendedor(Integer id, String nome, String email, Date dataAniversario, Double salarioBase, Departamento Vendedor) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataAniversario = dataAniversario;
        this.salarioBase = salarioBase;
        this.Vendedor = Vendedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getVendedor() {
        return Vendedor;
    }

    public void setVendedor(Departamento Vendedor) {
        this.Vendedor = Vendedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return id.equals(vendedor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataAniversario=" + dataAniversario +
                ", salarioBase=" + salarioBase +
                ", Vendedor=" + Vendedor +
                '}';
    }
}
