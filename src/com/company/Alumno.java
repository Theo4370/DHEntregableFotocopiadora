package com.company;

import java.util.Objects;

public class Alumno {
    //Voy a agregar un parametro booleano que sea seraEstudioso, que sera true o false dependiendo del alumno.
    private String nombre;
    private String apellido;
    private Integer codigoDeAlumno;
    private boolean seraEstudioso;

    public Alumno(String nombre, String apellido, Integer codigoDeAlumno, Boolean seraEstudioso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoDeAlumno = codigoDeAlumno;
        this.seraEstudioso = seraEstudioso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCodigoDeAlumno() {
        return codigoDeAlumno;
    }

    public void setCodigoDeAlumno(Integer codigoDeAlumno) {
        this.codigoDeAlumno = codigoDeAlumno;
    }


    @Override
    public boolean equals(Object alumnoAComparar) {
        if (!(alumnoAComparar instanceof Alumno)) {
            return false;
        }

        Alumno otroAlumno = (Alumno) alumnoAComparar;
        return otroAlumno.getCodigoDeAlumno().equals(this.codigoDeAlumno);

    }

    @Override
    public String toString() {
        return "Alumno " + nombre +
                " " + apellido +
                ", con codigo de alumno: " + codigoDeAlumno;
    }
}