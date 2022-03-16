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
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final PessoaRepository pessoaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository, PessoaRepository pessoaRepository) {
        this.empresaRepository = empresaRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public List<Empresa> getEmpresas(){
        List<Empresa> listaEmpresas = new ArrayList<>();

        empresaRepository.findAll().forEach(listaEmpresas::add);

        return listaEmpresas;
    }

    public List<Empresa> addEmpresa(Empresa empresa){
        empresaRepository.save(empresa);

        return getEmpresas();
    }

    public List<Empresa> removeEmpresa(Empresa empresa){
        Optional<Empresa> empresaOpcional = empresaRepository.findById(empresa.getId());

        if (empresaOpcional.isPresent()){
            for (Pessoa p: empresaOpcional.get().getListaPessoas()) {
                p.setEmpresa(null);
                pessoaRepository.save(p);
            }


            empresaRepository.delete(empresaOpcional.get());
        }

        return getEmpresas();
    }
}
