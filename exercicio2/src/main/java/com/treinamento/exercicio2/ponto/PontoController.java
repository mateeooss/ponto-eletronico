package com.treinamento.exercicio2.ponto;

import com.treinamento.exercicio2.papel.Papel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api-ponto")
public class PontoController {
    @Autowired
    PontoService pontoService;
    private Ponto ponto = new Ponto();

    @PostMapping(value = "/bater-ponto/{id}")
    public String baterPonto(@PathVariable Long id) throws Exception {
        return pontoService.save(id);
    }
    @GetMapping
    public List<Papel> listarPapeisPonto () {
        return pontoService.findAll();
    }

    @GetMapping("/{id}")
    public List<Papel> listarPorFuncionario (@PathVariable @Validated Long id){
        return pontoService.findByIdFunc(id);
    }

}

//if ( pontoService.findFunc(id).isSituacaoPonto()==true) {
//  if (pontoService.verificarAtrasos( pontoService.findFunc(id).getId()).stream().count() > 3) {
//        pontoService.findFunc(id).situacaoPonto(false);
//   throw new Exception("acesso bloqueado, por favor comparecer no RH para liberar o acesso");
//   } else {
//        if (pontoService.findFunc(id).isSituacaoPonto())
//            if(pontoService.verificarAtrasos(id).size() < 3) {
//                pontoService.save(pontoService.findFunc(id));
//            }else{
//                pontoService.findFunc(id).situacaoPonto(false);
//                throw new Exception(" 2 - -acesso bloqueado, por favor comparecer no RH para liberar o acesso");
//            }
//        else throw new Exception("acesso bloqueado, por favor comparecer no RH para liberar o acesso");




//            }else{
//                throw new Exception("acesso bloqueado, por favor comparecer no RH para liberar o acesso");
//            }
//}
