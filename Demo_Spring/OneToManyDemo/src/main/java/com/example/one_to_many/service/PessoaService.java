package com.example.one_to_many.service;

import com.example.one_to_many.model.Empresa;
import com.example.one_to_many.model.Pessoa;
import com.example.one_to_many.repository.EmpresaRepository;
import com.example.one_to_many.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final EmpresaRepository empresaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, EmpresaRepository empresaRepository) {
        this.pessoaRepository = pessoaRepository;
        this.empresaRepository = empresaRepository;
    }

    public List<Pessoa> getPessoas(){
        List<Pessoa> listaPessoas = new ArrayList<>();

        pessoaRepository.findAll().forEach(listaPessoas::add);

        return listaPessoas;
    }

    public List<Pessoa> addPessoa(Pessoa pessoa){
        pessoaRepository.save(pessoa);

        return getPessoas();
    }

    public List<Pessoa> removePessoa(Pessoa pessoa){
        Optional<Pessoa> pessoaOpcional = pessoaRepository.findById(pessoa.getId());

        if (pessoaOpcional.isPresent()){
            pessoaRepository.delete(pessoaOpcional.get());
        }

        return getPessoas();
    }

    public String addPessoaToEmpresa(String empresaId, String pessoaId){
        Optional<Empresa> opcionalEmpresa = empresaRepository.findById(Long.parseLong(empresaId));
        Optional<Pessoa> opcionalPessoa = pessoaRepository.findById(Long.parseLong(pessoaId));

        if (opcionalEmpresa.isPresent() && opcionalPessoa.isPresent()){
            Empresa empAux = opcionalEmpresa.get();
            Pessoa pesAux = opcionalPessoa.get();

            empAux.addPessoa(pesAux);
            pesAux.setEmpresa(empAux);

            empresaRepository.save(empAux);
            pessoaRepository.save(pesAux);

            return "Sucesso";
        }
        return "InSucesso";
    }
}
