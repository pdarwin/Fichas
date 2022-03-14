package com.example.demoAula.service;

import com.example.demoAula.model.Pessoa;
import com.example.demoAula.repository.pessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

@Service
public class pessoaService {
    private final pessoaRepository pessoaRepo;

    @Autowired
    public pessoaService(pessoaRepository pessoaRepo) {
        this.pessoaRepo = pessoaRepo;
    }

    public boolean addPessoa(Pessoa pessoa){
        if (pessoa.getId() == null){
            pessoaRepo.save(pessoa);
            return true;
        }
        return false;
    }

    public boolean removePessoa(Pessoa pessoa){
        if (pessoa.getId() == null || pessoaRepo.findById(pessoa.getId()).isEmpty()){
            return false;
        }

        Pessoa p = pessoaRepo.findById(pessoa.getId()).get();
        pessoaRepo.delete(p);

        return true;
    }

    public boolean removePessoa2(String id){
        try {
            Long id_long = parseLong(id);

            if (id == null || id_long==NaN || pessoaRepo.findById(id_long).isEmpty()){
                return false;
            }

            Pessoa p = pessoaRepo.findById(id_long).get();
            pessoaRepo.delete(p);

            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean updatePessoa(Pessoa pessoa){
        if (pessoa.getId() == null || pessoaRepo.findById(pessoa.getId()).isEmpty()){
            return false;
        }

        Pessoa p = pessoaRepo.findById(pessoa.getId()).get();

        if (p.getName() != null || !p.getName().isBlank()){
            p.setName(pessoa.getName());
        }

        if (pessoa.getAge()>0){
            p.setAge(pessoa.getAge());
        }

        pessoaRepo.save(p);

        return true;
    }

    public List<Pessoa> getPessoas(){
        List<Pessoa> listaPessoas = new ArrayList<>();

        pessoaRepo.findAll().forEach(listaPessoas::add);

        return listaPessoas;
    }

    public Optional<Pessoa> getPessoa(Long id)
    {
        return pessoaRepo.findById(id);
    }
}
