package com.example.demoAula.controller;

import com.example.demoAula.Utils.Wrapper;
import com.example.demoAula.model.Pessoa;
import com.example.demoAula.service.EmpresaPessoaService;
import com.example.demoAula.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaController {
    private final PessoaService pessoaService;
    private final EmpresaPessoaService empresaPessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService, EmpresaPessoaService empresaPessoaService) {
        this.pessoaService = pessoaService;
        this.empresaPessoaService = empresaPessoaService;
    }

    @GetMapping("/getPessoas")
    public ResponseEntity<List<Pessoa>> getPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getPessoas());
    }


    @PostMapping("/addPessoa")
    public ResponseEntity<String> addPessoas(@RequestBody Pessoa p){
        pessoaService.addPessoa(p);
        return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
    }

    @DeleteMapping("/deletePessoa")
    public ResponseEntity<String>  deletePessoas(@RequestBody Pessoa p){
        if (empresaPessoaService.removePessoa(p)){
            return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("InSucesso");
        }
    }

    @PostMapping("/addPessoaToEmpresa")
    public ResponseEntity<String>  relatePessoaEmpresa(@RequestBody Wrapper p){
        if (empresaPessoaService.combinePessoaEmpresa(p.getEmpresa(), p.getPessoa())){
            return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("InSucesso");
        }
    }
}
