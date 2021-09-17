package com.treinamento.exercicio2.papel;

import com.treinamento.exercicio2.funcionario.Funcionario;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Papel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    private Calendar data;


    public  Papel(){
    }

    public Papel(Funcionario funcionario, Calendar data) {
        this.funcionario = funcionario;
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Calendar getData() {
        return data;
    }

    public Long getId() {
        return id;
    }

    public void setData(Calendar data) {
        this.data = data;
    }


}
