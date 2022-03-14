package com.example.demo.controller;

import com.example.demo.dto.GetEmpresaResponse;
import com.example.demo.dto.SimpleResponse;
import com.example.demo.model.Empresa;
import com.example.demo.service.PessoaEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpresaController {
    private final PessoaEmpresaService pessoaEmpresaService;

    @Autowired
    public EmpresaController(PessoaEmpresaService pessoaEmpresaService) {
        this.pessoaEmpresaService = pessoaEmpresaService;
    }

    @GetMapping("/getAllEmpresas")
    public List<Empresa> getAllEmpresas(){
        return pessoaEmpresaService.getListaEmpresas();
    }

    @PostMapping("/addEmpresa")
    public ResponseEntity<SimpleResponse> addEmpresa(@RequestBody Empresa empresa){
        SimpleResponse sr = new SimpleResponse();
        if (pessoaEmpresaService.addEmpresa(empresa)){
            sr.setSucess("Sucesso ao inserir a empresa");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(sr);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
    }

    @DeleteMapping("/deleteEmpresa")
    public ResponseEntity<SimpleResponse> deleteEmpresa(@RequestBody Empresa empresa){
        SimpleResponse sr = new SimpleResponse();

        if (pessoaEmpresaService.deleteEmpresa(empresa)){
            sr.setSucess("Sucesso ao remover a empresa");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(sr);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
    }

    @PutMapping("/updateEmpresa")
    public ResponseEntity<SimpleResponse> updateEmpresa(@RequestBody Empresa empresa){
        SimpleResponse sr = new SimpleResponse();

        if (pessoaEmpresaService.updateEmpresa(empresa)){
            sr.setSucess("Sucesso ao atualizar a empresa");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(sr);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
    }

    @GetMapping("/geEmpresaById")
    public ResponseEntity<SimpleResponse> getEmpresa(@RequestBody Empresa empresa){
        GetEmpresaResponse ger = new GetEmpresaResponse();

        Optional<Empresa> empresaOptional = pessoaEmpresaService.getEmpresa(empresa);

        if (empresaOptional.isEmpty()){
            ger.setMessage("Empresa não encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ger);
        }else{
            ger.setEmpresa(empresaOptional.get());
            ger.setSucess("Empresa Encontrada");
            return ResponseEntity.status(HttpStatus.OK).body(ger);
        }
    }

}
