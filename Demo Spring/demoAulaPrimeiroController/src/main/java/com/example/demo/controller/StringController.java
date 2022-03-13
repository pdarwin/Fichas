package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class StringController {
    List<String> listaPalavras = new ArrayList<>();

    @GetMapping("/primeiroTesteGet")
    public String getPrimeiroTeste(){
        return "Isto é o meu primeiro get";
    }

    @PostMapping("/primeiroTestePost")
    public String postPrimeiroTeste(){
        return "Isto é o meu primeiro Post";
    }

    @GetMapping("/getPalavras")
    public List<String> getListaPalavras(){
        return listaPalavras;
    }

    @PostMapping("/addPalavra")
    public List<String> addPalavra(@RequestBody String palavra){
        listaPalavras.add(palavra);
        return listaPalavras;
    }

    @DeleteMapping("/deletePalavra/{palavra}")
    public List<String> deletePalavra(@PathVariable String palavra){
        listaPalavras.removeAll(Collections.singleton(palavra));
        return listaPalavras;
    }

    @DeleteMapping("/deletePalavraId/{index}")
    public List<String> deletePalavraId(@PathVariable int index){
        try{
            listaPalavras.remove(index);
        }catch (Exception e){
            System.out.println(e);
        }
        return listaPalavras;
    }
}
