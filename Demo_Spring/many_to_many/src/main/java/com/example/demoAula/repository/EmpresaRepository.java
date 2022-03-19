package com.example.demoAula.repository;

import com.example.demoAula.model.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
}
