package com.treinamento.exercicio2.rh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/RH")
public class RhController {
    @Autowired
    RhService rhService;

//    @PostMapping
//    public void registrarFuncionarioRh(@RequestBody Funcionario funcionario){
//        rhService.
//    }

    @PatchMapping("/{id}")
    public String liberarAcesso(@PathVariable Long id){
      return rhService.liberarAcesso(id);
    }


}
