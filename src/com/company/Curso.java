package com.company;

import com.company.Alumno;
import com.company.ProfesorAdjunto;
import com.company.ProfesorTitular;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombreDeCurso;
    private Integer codigoDeCurso;
    private ProfesorTitular profesorTitular;
    private ProfesorAdjunto profesorAdjunto;
    private Integer cupoMaximoDeAlumnos;
    private List<Alumno> listaDeAlumnos;
    //Cada curso tiene su lista de codigos de guias, asi que agrego ese parmametro
    private List<Integer> codigosGuias;


    public String getNombreDeCurso() {
        return nombreDeCurso;
    }

    public Curso(String nombreDeCurso, Integer codigoDeCurso, Integer cupoMaximoDeAlumnos) {
        this.nombreDeCurso = nombreDeCurso;
        this.codigoDeCurso = codigoDeCurso;
        //this.profesorTitular = profesorTitular;
        //this.profesorAdjunto = profesorAdjunto;
        this.cupoMaximoDeAlumnos = cupoMaximoDeAlumnos;
        this.listaDeAlumnos = new ArrayList<>();
        this.codigosGuias = new ArrayList<>();
    }

    public ProfesorTitular getProfesorTitular() {
        return profesorTitular;
    }

    public void setProfesorTitular(ProfesorTitular profesorTitular) {
        this.profesorTitular = profesorTitular;
    }

    public ProfesorAdjunto getProfesorAdjunto() {
        return profesorAdjunto;
    }

    public void setProfesorAdjunto(ProfesorAdjunto profesorAdjunto) {
        this.profesorAdjunto = profesorAdjunto;
    }

    public Integer getCupoMaximoDeAlumnos() {
        return cupoMaximoDeAlumnos;
    }

    public void setCupoMaximoDeAlumnos(Integer cupoMaximoDeAlumnos) {
        this.cupoMaximoDeAlumnos = cupoMaximoDeAlumnos;
    }

    public List<Alumno> getListaDeAlumnos() {
        return listaDeAlumnos;
    }

    public void setListaDeAlumnos(List<Alumno> listaDeAlumnos) {
        this.listaDeAlumnos = listaDeAlumnos;
    }


    public void setNombreDelCurso(String nombreDelCurso) {
        this.nombreDeCurso = nombreDelCurso;
    }

    public List<Integer> getCodigosGuias() {
        return codigosGuias;
    }

    public void setCodigosGuias(List<Integer> codigosGuias) {
        this.codigosGuias = codigosGuias;
    }

    public Integer getCodigoDeCurso() {
        return codigoDeCurso;
    }

    public void setCodigoDeCurso(Integer codigoDeCurso) {
        this.codigoDeCurso = codigoDeCurso;
    }


    public boolean agregarUnAlumno(Alumno unAlumno) {
        if (this.cupoMaximoDeAlumnos > listaDeAlumnos.size()) {
            return listaDeAlumnos.add(unAlumno);

        } else {
            System.out.println("El alumno " + unAlumno.getNombre() + " no pudo inscribirse porque no hay mas cupos para el curso de " + getNombreDeCurso());
        }
        return false;
    }

    public void eliminarAlumno(Alumno unAlumno) {
        this.listaDeAlumnos.remove(unAlumno);
    }


    @Override
    public boolean equals(Object cursoAComparar) {
        if (!(cursoAComparar instanceof Curso)) {
            return false;
        }

        Curso otroCurso = (Curso) cursoAComparar;
        return otroCurso.getCodigoDeCurso().equals(this.codigoDeCurso);
    }

    //Voy a agregar los metodos para que el curso pueda dar de alta y baja las guias que quiera
    public void agregarGuia(Guia unaGuia) {
        if (codigosGuias.contains(unaGuia.getCodigoGuia())) {
            System.out.printf("No se puede agregar esta guia porque ya existe");
        } else {
            codigosGuias.add(unaGuia.getCodigoGuia());
        }
    }

    public void eliminarGuia(Guia unaGuia) {
        if (!(codigosGuias.contains(unaGuia.getCodigoGuia()))) {
            System.out.printf("Esta guia no esta en la lista.");
        } else {
            codigosGuias.remove(unaGuia.getCodigoGuia());
        }

    }
}

