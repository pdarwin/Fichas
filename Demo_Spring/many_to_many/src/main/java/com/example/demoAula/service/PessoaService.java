package com.example.demoAula.service;

import com.example.demoAula.model.Pessoa;
import com.example.demoAula.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {
    private final PessoaRepository pessoas;

    @Autowired
    public PessoaService(PessoaRepository pessoas) {
        this.pessoas = pessoas;
    }

    public void addPessoa(Pessoa p){
        pessoas.save(p);
    }

    public List<Pessoa> getPessoas(){
        List<Pessoa> listaPessoas = new ArrayList<>();

        pessoas.findAll().forEach(listaPessoas::add);

        return listaPessoas;
    }
}
