package com.example.demoAula.controller;

import com.example.demoAula.dto.SimpleResponse;
import com.example.demoAula.dto.SimpleResponsePessoas;
import com.example.demoAula.model.Pessoa;
import com.example.demoAula.service.pessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class pessoaController {

    private final pessoaService pessoa_service;

    @Autowired
    public pessoaController(pessoaService pessoa_service) {
        this.pessoa_service = pessoa_service;
    }

    @GetMapping("/getPessoas")
    public List<Pessoa> getPessoas(){
        return pessoa_service.getPessoas();
    }

    @PostMapping(path = "/addPessoa")
    public ResponseEntity<SimpleResponse> addPessoas(@RequestBody Pessoa p){
        SimpleResponsePessoas sr = new SimpleResponsePessoas();

        if (p.getAge() <= 0){
            sr.setMessage("Idade Tem Que Ser Superior a 0");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sr);
        }

        if (p.getName() == null || p.getName().isBlank()){
            sr.setMessage("Nome Invalido");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sr);
        }

        if (pessoa_service.addPessoa(p)){
            sr.setAsSuccess("Pessoa Inserida Com Sucesso");
            sr.setPessoas(pessoa_service.getPessoas());

        }else{
            sr.setAsError("Erro ao inserir a Pessoa");
        }


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(sr);
    }


    @DeleteMapping("/removePessoa/{id}")
    public SimpleResponse removePessoa2(@PathVariable(name = "Id da Pessoa") String id){
        SimpleResponse sr = new SimpleResponse();

        if (pessoa_service.removePessoa2(id)){
            sr.setAsSuccess("Pessoa Removida Com Sucesso");
        }
        else{
            sr.setAsError("Erro a Remover a Pessoa");
        }

        return sr;
    }

    @DeleteMapping("/removePessoa")
    public SimpleResponse removePessoa(@RequestBody Pessoa p){
        SimpleResponsePessoas sr = new SimpleResponsePessoas();
        sr.setAsSuccess("Sucesso");

        if (pessoa_service.removePessoa(p)){
            sr.setAsSuccess("Pessoa Removida Com Sucesso");
        }
        else{
            sr.setAsError("Erro a Remover a Pessoa");
        }

        return sr;
    }

    @PutMapping("/updatePessoa")
    public SimpleResponse updatePessoa(@RequestBody Pessoa p){
        SimpleResponse sr = new SimpleResponse();

        if (p.getId()==null){
            sr.setAsError("Id invalido");
            return sr;
        }

        if (p.getName() == null || p.getName().isBlank()){
            sr.setAsError("Nome Invalido");
            return sr;
        }

        boolean suc = pessoa_service.updatePessoa(p);

        if (suc){
            sr.setAsSuccess("Pessoa atualizada com sucesso");
        }
        else{
            sr.setAsError("Erro na atualização da pessoa "+ p.getId());
        }
        return sr;

    }
}
