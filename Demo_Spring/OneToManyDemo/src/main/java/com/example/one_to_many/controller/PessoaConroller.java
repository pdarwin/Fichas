package com.example.one_to_many.controller;

import com.example.one_to_many.model.Pessoa;
import com.example.one_to_many.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaConroller {
    private final PessoaService pessoaService;

    @Autowired
    public PessoaConroller(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/getPessoas")
    public List<Pessoa> getPessoas(){
        return pessoaService.getPessoas();
    }

    @PostMapping("/addPessoa")
    public List<Pessoa> addPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.addPessoa(pessoa);
    }

    @PostMapping("/addPessoa/{id_pessoa}/Empresa/{empresa_id}")
    public String addPessoaToEmpresa(@PathVariable String id_pessoa, @PathVariable String empresa_id){
        return pessoaService.addPessoaToEmpresa(empresa_id, id_pessoa);
    }

    @DeleteMapping("/removePessoa")
    public List<Pessoa> removePessoa(@RequestBody Pessoa pessoa){
        return pessoaService.removePessoa(pessoa);
    }
}
