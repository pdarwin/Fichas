package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Empresa {
    private String nome;
    private String morada;
    private int numeroFuncionariosDesdeCriacao;
    private List<Pessoa> listaPessoas;
    private UUID id;

    public Empresa(String nome, String morada) {
        this.nome = nome;
        this.morada = morada;
        this.numeroFuncionariosDesdeCriacao = 0;
        listaPessoas = new ArrayList<>();
        id = UUID.randomUUID();
    }

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

    public UUID getId() {
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
