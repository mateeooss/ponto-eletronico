package com.treinamento.exercicio2.historicoDesbloqueio;

import com.treinamento.exercicio2.funcionario.Funcionario;
import com.treinamento.exercicio2.papel.Papel;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
@Entity
public class HistoricoDesbloqueio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
    private Calendar dataDoDesbloqueio;

    public HistoricoDesbloqueio() {
    }

    public HistoricoDesbloqueio(Funcionario funcionario) {
        this.funcionario = funcionario;
        this.dataDoDesbloqueio = Calendar.getInstance();
    }

    public Long getId() {
        return id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Calendar getDataDoDesbloqueio() {
        return dataDoDesbloqueio;
    }


}
