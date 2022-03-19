package com.example.demoAula.controller;

import com.example.demoAula.model.Empresa;
import com.example.demoAula.service.EmpresaPessoaService;
import com.example.demoAula.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {
    private final EmpresaService empresaService;
    private final EmpresaPessoaService empresaPessoaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService, EmpresaPessoaService empresaPessoaService) {
        this.empresaService = empresaService;
        this.empresaPessoaService = empresaPessoaService;
    }

    @GetMapping("/getEmpresas")
    public ResponseEntity<List<Empresa>> getPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.getEmpresas());
    }


    @PostMapping("/addEmpresa")
    public ResponseEntity<String> addEmpresa(@RequestBody Empresa p){
        if (p==null || p.getName() == null){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insucesso");
        }

        empresaService.addEmpresa(p);
        return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
    }

    @DeleteMapping("/deleteEmpresa")
    public ResponseEntity<String> deleteEmpresa(@RequestBody Empresa p){
        if(empresaPessoaService.removeEmpresa(p)){
            return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("InSucesso");
        }
    }

}
