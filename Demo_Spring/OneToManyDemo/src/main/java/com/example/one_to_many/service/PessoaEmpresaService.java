package com.example.one_to_many.service;

import com.example.one_to_many.model.Empresa;
import com.example.one_to_many.model.Pessoa;
import com.example.one_to_many.repository.EmpresaRepository;
import com.example.one_to_many.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaEmpresaService {
    private final EmpresaRepository empresaRepository;
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaEmpresaService(EmpresaRepository empresaRepository, PessoaRepository pessoaRepository) {
        this.empresaRepository = empresaRepository;
        this.pessoaRepository = pessoaRepository;
    }


}
