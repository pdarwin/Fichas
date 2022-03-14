package com.example.demo.service;

import com.example.demo.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePessoa {
    List<Pessoa> pessoas = new ArrayList<>();


    public List<Pessoa> addPessoa(Pessoa pessoa){
        System.out.println(pessoa);
        pessoas.add(pessoa);
        return pessoas;
    }


    public  String deletePessoa(String id){
        try {
            Long id_pessoa = Long.parseLong(id);

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

    public Boolean updatePessoa(Pessoa p){
        for (Pessoa pessoaAux: pessoas) {
            if (pessoaAux.getId() == p.getId()) {
                if(p.getIdade() > 0){
                    pessoaAux.setIdade(p.getIdade());
                }

                if (p.getNome()!= null && p.getNome().isBlank()){
                    pessoaAux.setNome(p.getNome());
                }

                return true;
            }
        }

        return false;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}
