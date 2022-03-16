package com.example.demo.service;

import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaEmpresaService {
    private final EmpresaRepository empresaRepository;
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaEmpresaService(EmpresaRepository empresaRepository, PessoaRepository pessoaRepository) {
        this.empresaRepository = empresaRepository;
        this.pessoaRepository = pessoaRepository;
    }

    //mostrar erro que tem de ter a empresa a null
    public boolean addEmpresa(Empresa emp){
        if (emp.getMorada() == null || emp.getMorada().isBlank() || emp.getNome()== null || emp.getNome().isBlank()){
            return false;
        }

        empresaRepository.save(emp);
        return true;
    }

    public List<Empresa> getListaEmpresas(){
        ArrayList<Empresa> empresas = new ArrayList<>();

        empresaRepository.findAll().forEach(empresas::add);

        return empresas;
    }

    public boolean deleteEmpresa(Empresa emp){
        Optional<Empresa> empOptional = getEmpresa(emp);

        if (empOptional.isEmpty()){
            return false;
        }

        Empresa empresaToDelete = empOptional.get();

        for (Pessoa aux: empresaToDelete.getListaPessoas()){
            pessoaRepository.delete(aux);
        }

        empresaRepository.delete(empresaToDelete);

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

        empresaRepository.save(emp);

        return true;
    }

    public Optional<Empresa> getEmpresa(Empresa emp){
        return empresaRepository.findById(emp.getId());
        /*if (emp.getId()!= null) {


            ArrayList<Empresa> empresasAux = new ArrayList<>();
            empresaRepository.findAll().forEach(empresasAux::add);

            for (Empresa aux : empresasAux) {
                if (aux.getId().equals(emp.getId())) {
                    return Optional.of(aux);
                }

        }

        return Optional.empty();}*/
    }

    public boolean addPessoaToEmpresa(Pessoa pessoa, Empresa empresa) {
        Optional<Empresa> empresaOptional = getEmpresa(empresa);

        //regular expression
        if (empresaOptional.isEmpty() || pessoa.getId() != null || pessoa.getNome() == null || pessoa.getNome().isBlank() || pessoa.getEmail()==null || !pessoa.getEmail().matches("^(.+)@(\\S+)$") || pessoa.getIdade() < 1 ){
            return false;
        }

        Empresa empresaAux = empresaOptional.get();
        empresaAux.addPessoa(pessoa);
        pessoa.setEmpresa(empresaAux);

        //empresaRepository.save(empresaAux);
        pessoaRepository.save(pessoa);

        return true;
    }

    public Optional<Pessoa> getPessoa(Pessoa pessoa){
        if (pessoa.getId()!=null){
            ArrayList<Pessoa> pessoaAux = new ArrayList<>();
            pessoaRepository.findAll().forEach(pessoaAux::add);

            for (Pessoa aux: pessoaAux){
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
        empresaRepository.save(emp);
        pessoaRepository.delete(p);

        return true;
    }

    public List<Pessoa> getListaPessoas(){
        ArrayList<Pessoa> pessoaAux = new ArrayList<>();
        pessoaRepository.findAll().forEach(pessoaAux::add);
        return pessoaAux;
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

        pessoaRepository.save(pessoaToUpdate);

        return true;
    }
}
