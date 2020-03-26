package com.company;

public class GuiaPractica extends Guia {

    private Integer cantidadDeEjercicios;

    public GuiaPractica(Integer codigoGuia, Integer cantidadPaginas, Double costo, String titulo, Integer cantidadDeEjercicios) {
        super(codigoGuia, cantidadPaginas, costo, titulo);
        this.cantidadDeEjercicios = cantidadDeEjercicios;
    }
}
