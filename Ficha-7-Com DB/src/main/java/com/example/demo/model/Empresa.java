package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    private String morada;
    private int numeroFuncionariosDesdeCriacao;

    @OneToMany(mappedBy = "empresa")
    private List<Pessoa> listaPessoas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNumeroFuncionariosAtual() {
        return listaPessoas.size();
    }

    public int getNumeroFuncionariosDesdeCriacao() {
        return numeroFuncionariosDesdeCriacao;
    }

    public void setNumeroFuncionariosDesdeCriacao(int numeroFuncionariosDesdeCriacao) {
        this.numeroFuncionariosDesdeCriacao = numeroFuncionariosDesdeCriacao;
    }

    public List<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public void setListaPessoas(List<Pessoa> listaPessoas) {
        this.listaPessoas = listaPessoas;
    }

    public Long getId() {
        return id;
    }

    public void addPessoa(Pessoa pessoa){
        numeroFuncionariosDesdeCriacao++;
        listaPessoas.add(pessoa);
    }

    public void removePessoa(Pessoa pessoa){
        listaPessoas.remove(pessoa);
    }

}
