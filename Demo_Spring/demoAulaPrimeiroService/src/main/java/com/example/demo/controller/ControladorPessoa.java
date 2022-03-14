package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.service.ServicePessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ControladorPessoa {
    private final ServicePessoa servicePessoa;

    @Autowired
    public ControladorPessoa(ServicePessoa servicePessoa) {
        this.servicePessoa = servicePessoa;
    }


    @PostMapping("/addPessoa")
    public  List<Pessoa> addPessoa(@RequestBody Pessoa pessoa){
        if (pessoa.getNome() == null || pessoa.getNome().isBlank() || pessoa.getIdade()>0 ){
            return Collections.EMPTY_LIST;
        }

        List<Pessoa> aux =  servicePessoa.addPessoa(pessoa);
        return aux;
    }

    @GetMapping("/getPessoas")
    public List<Pessoa> getPalavras(){
        return servicePessoa.getPessoas();
    }

    @DeleteMapping("/deletePessoa/{id}")
    public  String deletePessoa(@PathVariable String id){
        return servicePessoa.deletePessoa(id);
    }

    @PutMapping("/updatePessoa")
    public String updatePessoa(@RequestBody Pessoa p){
        if (servicePessoa.updatePessoa(p)){
            return "Pessoa updated com sucesso";
        }
        return "Erro a atualizar a pessoa";
    }




}
