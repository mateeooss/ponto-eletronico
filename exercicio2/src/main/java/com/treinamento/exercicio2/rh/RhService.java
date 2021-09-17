package com.treinamento.exercicio2.rh;

import com.treinamento.exercicio2.funcionario.Funcionario;
import com.treinamento.exercicio2.funcionario.FuncionarioRepository;
import com.treinamento.exercicio2.historicoDesbloqueio.HistoricoDesbloqueio;
import com.treinamento.exercicio2.historicoDesbloqueio.HistoricoDesbloqueioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RhService {
    @Autowired
    FuncionarioRepository funcionarioRepository;
    @Autowired
    HistoricoDesbloqueioService historicoDesbloqueioService;


    public String liberarAcesso(Long id){
        Funcionario funcionarioLiberarAcesso= funcionarioRepository.getById(id);

        funcionarioLiberarAcesso.setSituacaoPonto(true);
        funcionarioRepository.save(funcionarioLiberarAcesso);

        HistoricoDesbloqueio novoHistoricoDesbloqueio = new HistoricoDesbloqueio(funcionarioLiberarAcesso);
        historicoDesbloqueioService.salvar(novoHistoricoDesbloqueio);
        return funcionarioLiberarAcesso.toString();
    }
}
