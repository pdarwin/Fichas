package com.example.one_to_many.controller;

import com.example.one_to_many.model.Empresa;
import com.example.one_to_many.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {
    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/getEmpresas")
    public List<Empresa> getEmpresas(){
        return empresaService.getEmpresas();
    }

    @PostMapping("/addEmpresa")
    public List<Empresa> addEmpresa(@RequestBody Empresa empresa){
        return empresaService.addEmpresa(empresa);
    }

    @DeleteMapping("/removeEmpresa")
    public List<Empresa> removeEmpresa(@RequestBody Empresa empresa){
        return empresaService.removeEmpresa(empresa);
    }


}
