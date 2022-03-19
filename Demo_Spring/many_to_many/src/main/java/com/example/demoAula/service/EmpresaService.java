package com.example.demoAula.service;

import com.example.demoAula.model.Empresa;
import com.example.demoAula.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    private final EmpresaRepository empresas;

    @Autowired
    public EmpresaService(EmpresaRepository empresas) {
        this.empresas = empresas;
    }

    public void addEmpresa(Empresa e){
        empresas.save(e);
    }

    public List<Empresa> getEmpresas(){
        List<Empresa> listaEmpresas = new ArrayList<>();

        empresas.findAll().forEach(listaEmpresas::add);

        return listaEmpresas;
    }
}
