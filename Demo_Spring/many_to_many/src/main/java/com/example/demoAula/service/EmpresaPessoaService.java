package com.example.demoAula.service;

import com.example.demoAula.model.Empresa;
import com.example.demoAula.model.Pessoa;
import com.example.demoAula.repository.EmpresaRepository;
import com.example.demoAula.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaPessoaService {
    private final PessoaRepository pessoas;
    private final EmpresaRepository empresas;

    @Autowired
    public EmpresaPessoaService(PessoaRepository pessoas, EmpresaRepository empresas) {
        this.pessoas = pessoas;
        this.empresas = empresas;
    }

    public boolean combinePessoaEmpresa(Empresa emp, Pessoa p){
        Optional<Empresa> empresaOptional = empresas.findById(emp.getId());
        Optional<Pessoa> pessoaOptional = pessoas.findById(p.getId());

        if (empresaOptional.isEmpty() || pessoaOptional.isEmpty()){
            return false;
        }

        Pessoa pessoaToAdd = pessoaOptional.get();
        Empresa empresaToAdd = empresaOptional.get();

        pessoaToAdd.addEmpresa(empresaToAdd);
        empresaToAdd.addPessoa(pessoaToAdd);

        pessoas.save(pessoaToAdd);
        empresas.save(empresaToAdd);

        return true;
    }


    public boolean removeEmpresa(Empresa p) {
        Optional<Empresa> empresaOptional = empresas.findById(p.getId());

        if (empresaOptional.isPresent()){
            Empresa empresaToRemove = empresaOptional.get();

            System.out.println(empresaToRemove);
            System.out.println("\\\\\\\\\\\\\\\\\\");
            System.out.println(p.getPessoas());

            for(Pessoa pessoaEmpresa: empresaToRemove.getPessoas()){
                System.out.println(pessoaEmpresa);
                pessoaEmpresa.removeEmpresa(empresaToRemove);
                pessoas.save(pessoaEmpresa);
            }

            empresas.delete(empresaToRemove);
            return true;
        }
        return false;
    }

    public boolean removePessoa(Pessoa p) {
        Optional<Pessoa> pessoaOptional = pessoas.findById(p.getId());

        if (pessoaOptional.isPresent()){
            Pessoa pessoaToRemove = pessoaOptional.get();
            for(Empresa empresaPessoa: p.getEmpresas()){
                empresaPessoa.removePessoa(pessoaToRemove);
                empresas.save(empresaPessoa);
            }

            pessoas.delete(pessoaToRemove);
            return true;
        }
        return false;
    }

}
