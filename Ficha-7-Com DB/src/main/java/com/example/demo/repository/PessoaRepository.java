package com.example.demo.repository;

import com.example.demo.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}
