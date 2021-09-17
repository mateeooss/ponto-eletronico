package com.treinamento.exercicio2.ponto;

import com.treinamento.exercicio2.funcionario.Funcionario;
import com.treinamento.exercicio2.funcionario.FuncionarioRepository;
import com.treinamento.exercicio2.historicoDesbloqueio.HistoricoDesbloqueio;
import com.treinamento.exercicio2.historicoDesbloqueio.HistoricoDesbloqueioService;
import com.treinamento.exercicio2.papel.Papel;
import com.treinamento.exercicio2.papel.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PontoService implements Serializable {
    @Autowired
    HistoricoDesbloqueioService historicoDesbloqueioService;
    @Autowired
    PapelRepository papelRepository;
    @Autowired
    FuncionarioRepository funcionarioRepository;

    public Funcionario findFunc(Long id){
        return funcionarioRepository.getById(id);
    }


    public List<Papel> verificarAtrasos(Long id){
        Ponto ponto = new Ponto();
        Calendar c = Calendar.getInstance();
        return papelRepository.findAll()
                .stream().filter(o -> o.getFuncionario().getId().equals(id))
                .filter(o -> o.getData().get(Calendar.MONTH) == (c.get(Calendar.MONTH)))
                .filter(o -> o.getData().get(Calendar.WEEK_OF_MONTH) == c.get(Calendar.WEEK_OF_MONTH))
                .filter(o -> o.getData().get(Calendar.HOUR_OF_DAY) >= ponto.getData_horaLimite().get(Calendar.HOUR_OF_DAY))
                .filter(o -> o.getData().get(Calendar.MINUTE) > ponto.getData_horaLimite().get(Calendar.MINUTE))
                .collect(Collectors.toList());
    }

    public List<Papel> verificarPontosNoDia(Long id){
        Calendar dataAtualParaComparacao = Calendar.getInstance();
        return papelRepository.findAll().stream().filter(o -> o.getFuncionario().getId() == id)
                              .filter(o -> o.getData().get(Calendar.MONTH) == dataAtualParaComparacao.get(Calendar.MONTH))
                              .filter(o -> o.getData().get(Calendar.DAY_OF_MONTH) == dataAtualParaComparacao.get(Calendar.DAY_OF_MONTH))
                              .filter(o -> o.getData().get(Calendar.YEAR) == dataAtualParaComparacao.get(Calendar.YEAR))
                              .collect(Collectors.toList());
    }

    public String save(Long id) throws Exception {
        Funcionario funcionario = funcionarioRepository.getById(id);

        if (verificarPontosNoDia(id).size() < 1) {
           primeiroPontoDoDia(funcionario);
        } else {
            if (verificarPontosNoDia(id).size() > 3)
                throw new Exception("VOCE PASSOU DO LIMITE DE PONTOS DIARIOS, EM CASO DE DUVIDA PROCURE O RH");
            else {
                Papel papelPonto = new Papel(funcionario, Calendar.getInstance());
                papelRepository.save(papelPonto);

            }

        }

        if (verificarPontosNoDia(id).size() == 1) return "ENTRADA\n\n" + funcionario.toString()+"\n"+Calendar.getInstance().getTime();
        if (verificarPontosNoDia(id).size() == 2) return "SAIDA ALMOÇO\n" + funcionario.toString()+"\n"+Calendar.getInstance().getTime();
        if (verificarPontosNoDia(id).size() == 3) return "RETORNO ALMOÇO\n" + funcionario.toString()+"\n"+Calendar.getInstance().getTime();
        if (verificarPontosNoDia(id).size() == 4) return "SAIDA\n" + funcionario.toString()+"\n"+Calendar.getInstance().getTime();
        return "erro";
    }

    private void primeiroPontoDoDia(Funcionario funcionario) throws Exception {
        if (funcionario.isSituacaoPonto() && verificarAtrasos(funcionario.getId()).size() < 3 || funcionario.isSituacaoPonto() && historicoDesbloqueioService.listarTodosNaSemana(funcionario.getId()) > 0) {
            Papel papelPonto = new Papel(funcionario, Calendar.getInstance());
            papelRepository.save(papelPonto);
        } else {

            funcionario.setSituacaoPonto(false);
            funcionarioRepository.save(funcionario);
            throw new Exception("PONTO BLOQUEADO, PORFAVOR PASSAR NO RH");
        }
    }

    public List<Papel> findAll() {
        return papelRepository.findAll();
    }

    public List<Papel> findByIdFunc(Long id){
        return papelRepository.findAll().stream()
                .filter(o -> o.getFuncionario().getId().equals(id))
                .collect(Collectors.toList());
    }
}
