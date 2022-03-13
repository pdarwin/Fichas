package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PessoaController {
    List<Pessoa> pessoas = new ArrayList<>();

    @PostMapping("/addPessoa")
    public  List<Pessoa> addPessoa(@RequestBody Pessoa pessoa){
        //Tem erro (falta)

        pessoas.add(pessoa);
        return pessoas;
    }

    @GetMapping("/getPessoas")
    public List<Pessoa> getPalavras(){
        return pessoas;
    }

    @DeleteMapping("/deletePessoa/{id}")
    public  String deletePessoa(@PathVariable String id){
        try {
            Integer id_pessoa = Integer.parseInt(id);

            System.out.println(id_pessoa);
            System.out.println();

            for (Pessoa pessoaAux: pessoas) {
                if (pessoaAux.getId() == id_pessoa) {
                    pessoas.remove(pessoaAux);
                    return "Sucesso";
                }
            }
            return "Id não existe";
        }catch (Exception e){
            return "Id invalido";
        }
    }

    @PutMapping("/updatePessoa")
    public String updatePessoa(@RequestBody Pessoa p){
        for (Pessoa pessoaAux: pessoas) {
            if (pessoaAux.getId() == p.getId()) {
                if(p.getIdade() > 0){
                    pessoaAux.setIdade(p.getIdade());
                }

                if (p.getNome()!= null && !p.getNome().isBlank()){
                    pessoaAux.setNome(p.getNome());
                }

                return "Sucesso";
            }
        }

        return "Pessoa não existe";
    }




}
