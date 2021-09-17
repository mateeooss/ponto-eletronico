package com.treinamento.exercicio2.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api-funcionario")
public class FuncionarioController {
    @Autowired
    FuncionarioRepository repo;

    @PostMapping
    public void cadastrarFuncionario(@RequestBody @Validated Funcionario funcionario){
        repo.save(funcionario);
    }

    @GetMapping
    public List<Funcionario> listarFuncionario(){
        return repo.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Funcionario> buscarFuncionario(@PathVariable Long id){
        return repo.findById(id);
    }



}
