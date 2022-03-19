package com.example.demoAula.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "empresas")
    private List<Pessoa> pessoas = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void addPessoa(Pessoa p){
        pessoas.add(p);
    }

    public void removePessoa(Pessoa p){
        pessoas.remove(p);
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pessoas=" + pessoas +
                '}';
    }
}
