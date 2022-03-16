package com.example.demo.repository;

import com.example.demo.model.Empresa;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
}
