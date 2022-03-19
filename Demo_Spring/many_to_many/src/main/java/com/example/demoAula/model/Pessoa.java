package com.example.demoAula.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Pessoa")
public class Pessoa {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "Pessoa_Empresa",
            joinColumns = { @JoinColumn(name = "pessoa_id") },
            inverseJoinColumns = { @JoinColumn(name = "empresa_id") }
    )
    List<Empresa> empresas = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void addEmpresa(Empresa emp){
        empresas.add(emp);
    }

    public void removeEmpresa(Empresa emp){
        empresas.remove(emp);
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}