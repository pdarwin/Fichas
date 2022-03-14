package com.example.demoAula.dto;

import com.example.demoAula.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class SimpleResponsePessoas extends SimpleResponse{
    List<Pessoa> pessoas;

    public SimpleResponsePessoas() {
        this.pessoas = new ArrayList<>();
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
