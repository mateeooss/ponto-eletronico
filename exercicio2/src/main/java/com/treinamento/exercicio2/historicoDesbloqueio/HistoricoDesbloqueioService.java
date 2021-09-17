package com.treinamento.exercicio2.historicoDesbloqueio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricoDesbloqueioService {
    @Autowired
    HistoricoDesbloqueioRepository historicoDesbloqueioRepository;

    public void salvar(HistoricoDesbloqueio desbloqueioParaSerSalvo){
        historicoDesbloqueioRepository.save(desbloqueioParaSerSalvo);
    }

    public int listarTodosNaSemana(Long id){
        Calendar dataAtualParaComparacao = Calendar.getInstance();
        return historicoDesbloqueioRepository.findAll().stream().filter(o -> o.getFuncionario().getId() == id)
                                                                .filter(o -> o.getDataDoDesbloqueio().get(Calendar.MONTH) == dataAtualParaComparacao.get(Calendar.MONTH))
                                                                .filter(o -> o.getDataDoDesbloqueio().get(Calendar.YEAR) == dataAtualParaComparacao.get(Calendar.YEAR))
                                                                .filter(o -> o.getDataDoDesbloqueio().get(Calendar.WEEK_OF_MONTH) == dataAtualParaComparacao.get(Calendar.WEEK_OF_MONTH))
                                                                .collect(Collectors.toList()).size();
    }

}
