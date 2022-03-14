package com.example.demo.dto;

import com.example.demo.model.Pessoa;

public class GetPessoaResponse extends SimpleResponse{
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
