package com.agenda.agenda_apirest;
import java.util.Scanner;
public class Contactos {
    
    private String nombre;
    private String localidad;
    private String direccion;
    String[] telefono = new String[5]; 
    Scanner sc = new Scanner(System.in);

    public Contactos(String nombre, String localidad, String direccion, String caracteristica, int telefono){
        setNombre(nombre);
        setLocalidad(localidad);
        setDireccion(direccion);
        if (caracteristica.length()>0) {
            if (String.valueOf(telefono).length()>0) {
                agregarTelefono(caracteristica, telefono);
            }
        }else{
            agregarTelefono();
        }

    }

    public int emptyElement(){
        int count = 0;
        for(int i = 0; i < 5; i++){
            if (telefono[i] == null || telefono[i].isEmpty() && count!=telefono.length) {
                count ++;
            }else{return -2;}
            if (telefono[i] == null || telefono[i].isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    public boolean validarCaracteristica(String caracteristica){
        if(caracteristica.startsWith("0")){
            if (caracteristica.length()<=5 && caracteristica.length()>=3) {
                for(int i = 0; i < caracteristica.length(); i++){
                    if (!Character.isDigit(caracteristica.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;   
    }

    public boolean validarNumero(int numero){
        if(String.valueOf(numero).length()>=5 && String.valueOf(numero).length()<=7 && !String.valueOf(numero).startsWith("0")){
            return true;
        }
        return false;
    }

    public void agregarTelefono(String caracteristica, int numero){
        if(!validarCaracteristica(caracteristica) || !validarNumero(numero)){
            System.out.println("El numero ingresado es erroneo");              
        }else if(emptyElement() != -1){
            telefono[emptyElement()] = caracteristica+"-"+numero;
            }else{ 
            System.out.println("No existen elementos vacíos");
        }
    }

    public void agregarTelefono(){
        if (emptyElement() != -1) {
            System.out.println("No existe más lugar para agregar números telefónicos");
        }else{
            String caracteristica;
            int numero;
            System.out.print("Ingrese caracteristica telefónica: ");  
            do{
                caracteristica = sc.nextLine();   
            }while(!validarCaracteristica(caracteristica));
            System.out.print("Ingrese número telefónico: ");
            do{
                numero = sc.nextInt();   
            }while(!validarNumero(numero));
            telefono[emptyElement()] = caracteristica + "-" + numero;
        }

    }

    public void eliminarTelefono(){
        System.out.println("ingresa el numero de telefono a eliminar: ");
        listarTelefonos();
        int choice;
        boolean x = false;
        do {
            choice = sc.nextInt();
            if (telefono[choice] != null || !telefono[choice].isEmpty()) {
                telefono[choice] = "";
                x = true;
            }else{
                System.out.println("El número no existe");
            }
        } while (x);
        System.out.println("Número eliminado correctamente");
    }

    public void modificarTelefono(){
        System.out.println("ingresa el numero de telefono a modificar: ");
        listarTelefonos();
        int choice;
        boolean x = true;
        do {
            if (emptyElement() == -2) {
               System.out.println("No hay ningun numero telefonico para modificar.");
            }else{
                System.out.println("Ingrese el número a modificar: ");
                listarTelefonos();
                choice = sc.nextInt();
                System.out.print("Ingrese la caracteristica del nuevo numero: ");
                String caracteristica = sc.nextLine();
                System.out.print("Ingrese el numero: ");
                int numero = sc.nextInt();
                telefono[choice] = caracteristica + "-" + numero;
                x = false;
            }
        } while (x);
        System.out.println("Número modificado correctamente");
    }


    public void listarTelefonos(){
        for(int i = 0; i<telefono.length; i++){
           if (telefono[i] != null && !telefono[i].isEmpty() ) {
                System.out.println((i+1)+ ") "+telefono[i]);
           }
        }

    }

    //setters
    public void setDireccion(String direccion){this.direccion = direccion.trim().toUpperCase();}
    public void setLocalidad(String localidad){this.localidad = localidad.trim().toUpperCase();}
    public void setNombre(String nombre){this.nombre = nombre.trim().toUpperCase();}

    //getters
    public String getDireccion(){return direccion;}
    public String getLocalidad(){return localidad;}
    public String getNombre(){return nombre;}

}
