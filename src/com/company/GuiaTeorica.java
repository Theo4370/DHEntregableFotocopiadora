package com.company;

import java.util.List;

public class GuiaTeorica extends Guia{

    private List<String> listaDeTemas;

    public GuiaTeorica(Integer codigoGuia, Integer cantidadPaginas, Double costo, String titulo, List<String> listaDeTemas) {
        super(codigoGuia, cantidadPaginas, costo, titulo);
        this.listaDeTemas = listaDeTemas;
    }
}
