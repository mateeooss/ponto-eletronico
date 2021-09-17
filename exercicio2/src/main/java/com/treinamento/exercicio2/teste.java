package com.treinamento.exercicio2;

import com.treinamento.exercicio2.papel.Papel;
import com.treinamento.exercicio2.papel.PapelRepository;
import com.treinamento.exercicio2.ponto.Ponto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class teste {
    public static void main(String[] args) {
//        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
//
        Calendar a = Calendar.getInstance();
        Papel papel = new Papel();
        System.out.println(papel.getData());

        PapelRepository papelRepository;
        List<Boolean> pontos;

         Calendar b = Calendar.getInstance();

//        if(papelRepository.findAll().stream()
//                                    .filter(o -> o.getData().get(Calendar.DAY_OF_MONTH) == a.get(Calendar.DAY_OF_MONTH) )
//                                    .filter(O - > O.getStats == true )
//                                    .collect(Collectors.toList())

     //   Ponto ponto = new Ponto();
      //  System.out.println(a.get(Calendar.HOUR)+"   "+ponto.getData_horaLimite().get(Calendar.HOUR)+"  "+ponto.getData_horaLimite().get(Calendar.MINUTE));
//        List<String> a;
//
//        Date d;
//
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.HOUR, 10);
//        System.out.println(c.getTime()+"  "+c.get(Calendar.AM));
   //   DateFormat df = new SimpleDateFormat("HH:mm:ss");
  //    Date dMin = df.format(c.getTime());
  //      System.out.println(df.format(c.getTime()));
//        for (int i = 0; i < 7; i++) {
//            System.out.println(df.format(c.getTime()));
//            c.add(Calendar.DATE, 1);
//        }
//        Date d = new Date();
//        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
//        System.out.println(d.getTime() + "=" + d);
//        TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
//        System.out.println(d.getTime() + "=" + d);
//        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));
//        System.out.println(d.getTime() + "=" + d);
//        Papel p = new Papel();
//      Calendar c = Calendar.getInstance();
//        Calendar c2 = Calendar.getInstance();
//
//  //      c2.set(Calendar.HOUR_OF_DAY, 22);
//
//        System.out.println(c.get(Calendar.MONTH));
//        System.out.println(c2.getTimeInMillis());
//        System.out.println(c.get(Calendar.WEEK_OF_MONTH));
//        Calendar cal = Calendar.getInstance();
//        System.out.println("o mes tem " + cal.getActualMaximum(cal.WEEK_OF_MONTH) + " semanas ");
    }
}



// Set the calendar to monday of the current week
//        c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
//
//// Print dates of the current week starting on Monday
//        DateFormat df = new SimpleDateFormat("EEE dd/MM/yyyy");
//        for (int i = 0; i < 7; i++) {
//            System.out.println(df.format(c.getTime()));
//            c.add(Calendar.DATE, 1);
//        }
//    }
//}
