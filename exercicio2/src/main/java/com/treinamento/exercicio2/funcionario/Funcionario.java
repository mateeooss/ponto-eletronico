package com.treinamento.exercicio2.funcionario;

import javax.persistence.*;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long id;
    private String nome;
    private boolean situacaoPonto = true;


    public boolean isSituacaoPonto() {
        return situacaoPonto;
    }

    public Funcionario() {

    }
    public Funcionario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Long getId(){
        return id;
    }

    public void setSituacaoPonto(boolean alteracao){
        this.situacaoPonto = alteracao;
    }

    @Override
    public String toString() {
        return "nome="+nome+"\n"+
                "situacaoPonto=" + situacaoPonto ;
    }
}
