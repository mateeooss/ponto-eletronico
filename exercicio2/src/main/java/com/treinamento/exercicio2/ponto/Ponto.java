package com.treinamento.exercicio2.ponto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Ponto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Calendar data_horaLimite= Calendar.getInstance();


    public Ponto() {
    }

    public Calendar getData_horaLimite() {
        data_horaLimite.set(Calendar.HOUR_OF_DAY, 9);
        data_horaLimite.set(Calendar.MINUTE, 5);
        return data_horaLimite;
    }

    public long getId() {
        return id;
    }
}
