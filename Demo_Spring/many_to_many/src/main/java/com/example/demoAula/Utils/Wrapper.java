package com.example.demoAula.Utils;

import com.example.demoAula.model.Empresa;
import com.example.demoAula.model.Pessoa;

public class Wrapper {
    private Empresa empresa;
    private Pessoa pessoa;

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
