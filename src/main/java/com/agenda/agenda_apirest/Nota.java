package com.agenda.agenda_apirest;

public class Nota {
    private String titulo;
    private String texto;
    private int dia;
    private int mes;
    private Contactos contacto;

    

    //Getters & setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public Contactos getContacto() {
        return contacto;
    }
    public void setContacto(Contactos contacto) {
        this.contacto = contacto;
    }
   


}
