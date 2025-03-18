package com.agenda.agenda_apirest;

import java.util.ArrayList;
import java.util.Scanner;
public class Agenda {
    private String nombre;
    private ArrayList<Nota> notas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    /*public static void main(String[] args){
        Nota notanashei = new Nota();
        notanashei.setTitulo("pedro");
        notanashei.setTexto("BLABALBALABLAABLBABALBLABLALBALBLABLLALBABLABL");
        notanashei.setDia(1);
        notanashei.setMes(2);
        Agenda ag = new Agenda();
        ag.agregarNota(notanashei);
        ag.listarNotas();
    } */

    public void agregarNota(Nota nota){
        notas.add(nota);
    }

    @SuppressWarnings("unlikely-arg-type")
    public void listarNotas(){
        for(int i = 0; i<notas.size(); i++){
           if (notas.get(i) != null && notas.get(i).equals("")) {
                System.out.println(notas.get(i));
                System.out.println("--------------------------------");
                System.out.println(notas.get(i).getTexto());
                System.out.println("--------------------------------");
                System.out.println(notas.get(i).getTitulo());
           }
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
