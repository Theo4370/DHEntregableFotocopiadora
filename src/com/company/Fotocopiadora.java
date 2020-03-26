package com.company;

import java.util.HashMap;
import java.util.Map;

public class Fotocopiadora {
    //La fotocopiadora conviene que tenga un diccionario de guias, para no tener que implementar listas.
    //La clave para cada termino del diccionario (en este caso cada guia) va a ser su propio codigo.
    private Map<Integer, Guia> diccionarioDeGuias;

    public Fotocopiadora() {
        this.diccionarioDeGuias = new HashMap<>();
    }

    //Voy a definir los metodos para agregar y scar guias de la fotocopiadora.
    public void agregarGuia(Guia unaGuia) {
        if (diccionarioDeGuias.containsKey(unaGuia.getCodigoGuia())) {
            System.out.printf("Esta guia ya se encuentra en la lista de la fotocopiadora");
        } else {
            diccionarioDeGuias.put(unaGuia.getCodigoGuia(), unaGuia);
            System.out.printf("Se agrego la guia " + unaGuia.getTitulo() + " a la lista de la fotocopiadora.");
        }
    }

    public void eliminarGuia(Guia unaGuia) {
        if (!(diccionarioDeGuias.containsKey(unaGuia.getCodigoGuia()))) {
            System.out.printf("Esta guia no se encuentra en la lista de la fotocopiadora.");
        } else {
            diccionarioDeGuias.remove(unaGuia.getCodigoGuia(), unaGuia);
            System.out.printf("Se elimino la guia " + unaGuia.getTitulo() + " de la lista de la fotocopiadora,");
        }
    }
    //Voy a crear el metodo para poder imprimir las guias solo sabiendo su codigo.
    public void imprimirGuia(Integer codigoDeGuia){
        if (diccionarioDeGuias.containsKey(codigoDeGuia)){
            System.out.printf("Se esta imprimiendo la guia");
        } else {
            System.out.printf("Esta guia no encuentra cargada en la fotocopiadora");
        }
    }
}
