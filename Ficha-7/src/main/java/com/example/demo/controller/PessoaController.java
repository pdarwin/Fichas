package com.example.demo.controller;

import com.example.demo.dto.SimpleResponse;
import com.example.demo.dto.GetPessoaResponse;
import com.example.demo.model.Pessoa;
import com.example.demo.service.PessoaEmpresaService;
import com.example.demo.utils.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PessoaController {
    private final PessoaEmpresaService pessoaEmpresaService;

    @Autowired
    public PessoaController(PessoaEmpresaService pessoaEmpresaService) {
        this.pessoaEmpresaService = pessoaEmpresaService;
    }

    @PostMapping("/addPessoa")
    public ResponseEntity<SimpleResponse> addPessoa(@RequestBody Wrapper wrapper){
        SimpleResponse sr = new SimpleResponse();
        if (wrapper.getPessoa()== null && wrapper.getEmpresa()==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
        }

        if(pessoaEmpresaService.addPessoaToEmpresa(wrapper.getPessoa(), wrapper.getEmpresa())){
            sr.setSucess("Pessoa adicionada a empresa");
            return ResponseEntity.status(HttpStatus.OK).body(sr);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
        }

    }

    @GetMapping("/getPessoas")
    public List<Pessoa> getPessoas(){
        return pessoaEmpresaService.getListaPessoas();
    }

    @DeleteMapping("/deletePessoa")
    public  ResponseEntity<SimpleResponse> deletePessoa(@RequestBody Pessoa pessoa){
        SimpleResponse sr = new SimpleResponse();


        if(pessoaEmpresaService.deletePessoa(pessoa)){
            sr.setSucess("Pessoa removida com sucesso");
            return ResponseEntity.status(HttpStatus.OK).body(sr);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
        }
    }

    @GetMapping("/getPessoa")
    public ResponseEntity<GetPessoaResponse> getPessoaById (@RequestBody Pessoa pessoa){
        GetPessoaResponse sr = new GetPessoaResponse();

        Optional<Pessoa> pessoaOptional = pessoaEmpresaService.getPessoa(pessoa);

        if (pessoaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
        }else{
            sr.setSucess("Pessoa encontrada com sucesso");
            sr.setPessoa(pessoaOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(sr);
        }
    }

    @PutMapping("/updatePessoa")
    public ResponseEntity<SimpleResponse> updatePessoa (@RequestBody Pessoa pessoa){
        SimpleResponse sr = new SimpleResponse();

        if (pessoaEmpresaService.updatePessoa(pessoa)){
            sr.setSucess("Pessoa atualizada com sucesso");
            return ResponseEntity.status(HttpStatus.OK).body(sr);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
        }
    }
}
