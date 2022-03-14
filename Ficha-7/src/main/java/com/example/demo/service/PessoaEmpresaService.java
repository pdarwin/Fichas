package com.example.demo.service;

import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaEmpresaService {
    private List<Empresa> listaEmpresas;
    private List<Pessoa> listaPessoas;

    public PessoaEmpresaService() {
        listaEmpresas = new ArrayList<>();
        listaPessoas = new ArrayList<>();
    }

    public boolean addEmpresa(Empresa emp){
        if (emp.getMorada() == null || emp.getMorada().isBlank() || emp.getNome()== null || emp.getNome().isBlank()){
            return false;
        }

        listaEmpresas.add(emp);
        return true;
    }

    public List<Empresa> getListaEmpresas(){
        return listaEmpresas;
    }

    public boolean deleteEmpresa(Empresa emp){
        Optional<Empresa> empOptional = getEmpresa(emp);

        if (empOptional.isEmpty()){
            return false;
        }

        Empresa empresaToDelete = empOptional.get();

        for (Pessoa aux: empresaToDelete.getListaPessoas()){
            listaPessoas.remove(aux);
        }

        listaEmpresas.remove(empresaToDelete);

        return true;
    }

    public boolean updateEmpresa(Empresa emp){
        Optional<Empresa> empOptional = getEmpresa(emp);
        if (empOptional.isEmpty()){
            return false;
        }

        Empresa empresaToUpdate = empOptional.get();

        if (emp.getNome()!= null && !emp.getNome().isBlank()){
            empresaToUpdate.setNome(emp.getNome());
        }

        if (emp.getMorada()!= null && !emp.getMorada().isBlank()){
            empresaToUpdate.setMorada(emp.getMorada());
        }

        return true;
    }

    public Optional<Empresa> getEmpresa(Empresa emp){
        if (emp.getId()!= null) {
            for (Empresa aux : listaEmpresas) {
                if (aux.getId().equals(emp.getId())) {
                    return Optional.of(aux);
                }
            }
        }

        return Optional.empty();
    }

    public boolean addPessoaToEmpresa(Pessoa pessoa, Empresa empresa) {
        Optional<Empresa> empresaOptional = getEmpresa(empresa);

        //regular expression
        if (empresaOptional.isEmpty() || pessoa.getNome() == null || pessoa.getNome().isBlank() || pessoa.getEmail()==null || !pessoa.getEmail().matches("^(.+)@(\\S+)$") || pessoa.getIdade() < 1 ){
            return false;
        }

        Empresa empresaAux = empresaOptional.get();
        empresaAux.addPessoa(pessoa);
        pessoa.setEmpresa(empresaAux);

        listaPessoas.add(pessoa);

        return true;
    }

    public Optional<Pessoa> getPessoa(Pessoa pessoa){
        if (pessoa.getId()!=null){
            for (Pessoa aux: listaPessoas){
                if (aux.getId().equals(pessoa.getId())){
                    return Optional.of(aux);
                }
            }
        }
        return Optional.empty();
    }

    public boolean deletePessoa(Pessoa pessoa){
        Optional<Pessoa> pessoaOptional = getPessoa(pessoa);
        if (pessoaOptional.isEmpty()){
            return false;
        }

        Pessoa p = pessoaOptional.get();
        Empresa emp = p.getEmpresa();

        emp.removePessoa(p);
        listaPessoas.remove(p);

        return true;
    }

    public List<Pessoa> getListaPessoas(){
        return listaPessoas;
    }

    public boolean updatePessoa(Pessoa pessoa) {
        Optional<Pessoa> pessoaOptional = getPessoa(pessoa);
        if (pessoaOptional.isEmpty()){
            return false;
        }

        Pessoa pessoaToUpdate = pessoaOptional.get();

        if (pessoa.getNome()!= null && !pessoa.getNome().isBlank()){
            pessoaToUpdate.setNome(pessoa.getNome());
        }

        if (pessoa.getIdade()>0){
            pessoaToUpdate.setIdade(pessoa.getIdade());
        }

        if (pessoa.getEmail()!= null && pessoa.getEmail().matches("^(.+)@(\\S+)$")){
            pessoaToUpdate.setEmail(pessoa.getEmail());
        }

        return true;
    }
}
