package com.example.demo.utils;

import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;

public class Wrapper {
    private Empresa empresa;
    private Pessoa pessoa;

    public Wrapper(Empresa empresa, Pessoa pessoa) {
        this.empresa = empresa;
        this.pessoa = pessoa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
