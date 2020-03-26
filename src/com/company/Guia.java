package com.company;

public class Guia {
    private Integer codigoGuia;
    private Integer cantidadPaginas;
    private Double costo;
    private String titulo;


    public Guia(Integer codigoGuia, Integer cantidadPaginas, Double costo, String titulo) {
        this.codigoGuia = codigoGuia;
        this.cantidadPaginas = cantidadPaginas;
        this.costo = costo;
        this.titulo = titulo;
    }

    public Integer getCodigoGuia() {
        return codigoGuia;
    }

    public void setCodigoGuia(Integer codigoGuia) {
        this.codigoGuia = codigoGuia;
    }

    public Integer getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(Integer cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
