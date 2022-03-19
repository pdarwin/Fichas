package com.example.demoAula.repository;

import com.example.demoAula.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}
