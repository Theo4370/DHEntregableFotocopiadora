package com.company;

import com.company.Profesor;
import com.company.ProfesorAdjunto;
import com.company.ProfesorTitular;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DigitalHouseManager {
    private List<Alumno> listaDeAlumnos = new ArrayList<>();
    private List<Profesor> listaDeProfesores = new ArrayList<>();
    private List<Inscripcion> listaDeInscripciones = new ArrayList<>();
    //Para poder agregar cursos, necesito que listaDeCursos sea un new ArrayList() (si no me devolveria null). APLICA LO MISMO CON TODOS LOS ATRIBUTOS.
    private List<Curso> listaDeCursos = new ArrayList<>();
    //El manager ahora necesita una lista de guias;
    private List<Guia> listaDeGuias = new ArrayList<>();

    public List<Profesor> getListaDeProfesores() {
        return listaDeProfesores;
    }

    public List<Curso> getListaDeCursos() {
        return listaDeCursos;
    }

    public List<Alumno> getListaDeAlumnos() {
        return listaDeAlumnos;
    }

    public void altaCurso(String nombre, Integer codigoCurso, Integer cupoMaximoDeAlumnos) {
        Curso unCurso = new Curso(nombre, codigoCurso, cupoMaximoDeAlumnos);
        this.listaDeCursos.add(unCurso);

    }

    public void bajaCurso(Integer codigoCurso) {
        Curso cursoAEliminar = null;
        for (Curso curso : listaDeCursos) {
            if (codigoCurso.equals(curso.getCodigoDeCurso())) {
                cursoAEliminar = curso;
                break;
            }
        }
        this.listaDeCursos.remove(cursoAEliminar);
    }

    public void altaProfesorAdjunto(String nombre, String apellido, Integer codigoProfesor, Integer cantidadDeHoras) {
        ProfesorAdjunto profesorAdjunto = new ProfesorAdjunto(nombre, apellido, codigoProfesor, cantidadDeHoras);
        this.listaDeProfesores.add(profesorAdjunto);

    }

    public void altaProfesorTitular(String nombre, String apellido, Integer codigoProfesor, String especialidad) {
        ProfesorTitular profesorTitular = new ProfesorTitular(nombre, apellido, codigoProfesor, especialidad);
        this.listaDeProfesores.add(profesorTitular);
    }

    public void bajaProfesor(Integer codigoProfesor) {
        Profesor profesorBaja = null;
        for (Profesor profesor : listaDeProfesores) {
            if (codigoProfesor.equals(profesor.getCodigoDeProfesor())) {
                profesorBaja = profesor;
                break;
            }
        }
        this.listaDeProfesores.remove(profesorBaja);
    }

    public void altaAlumno(String nombre, String apellido, Integer codigoAlumno, Boolean seraEstudioso) {
        Alumno alumno = new Alumno(nombre, apellido, codigoAlumno, seraEstudioso);
        this.listaDeAlumnos.add(alumno);
    }

    public void inscribirAlumno(Integer codigoAlumno, Integer codigoCurso) {
        Curso cursoAInscribir = null;
        Alumno alumnoAInscribir = null;

        for (Curso curso : listaDeCursos) {
            if (codigoCurso.equals(curso.getCodigoDeCurso())) {
                cursoAInscribir = curso;
                break;
            }
        }

        for (Alumno alumno : listaDeAlumnos) {
            if (codigoAlumno.equals(alumno.getCodigoDeAlumno())) {
                alumnoAInscribir = alumno;
                break;
            }
        }
        if (cursoAInscribir.agregarUnAlumno(alumnoAInscribir)) {
            Inscripcion nuevaInscripcion = new Inscripcion(alumnoAInscribir, cursoAInscribir);
            listaDeInscripciones.add(nuevaInscripcion);
            System.out.println("Se Inscribio con exito a " + alumnoAInscribir.getNombre() + " " + alumnoAInscribir.getApellido() + " al curso de " + cursoAInscribir.getNombreDeCurso());
        }
    }


    public void asignarProfesores(Integer codigoCurso, Integer codigoProfesorTitular, Integer codigoProfesorAdjunto) {
        Curso cursoAAsignar = null;
        ProfesorTitular profeTitularAAsignar = null;
        ProfesorAdjunto profeAdjuntoAAsignar = null;

        for (Curso curso : listaDeCursos) {
            if (codigoCurso.equals(curso.getCodigoDeCurso())) {
                cursoAAsignar = curso;
                break;
            }
        }
        for (Profesor profeAdj : listaDeProfesores) {
            if (codigoProfesorAdjunto.equals(profeAdj.getCodigoDeProfesor())) {
                profeAdjuntoAAsignar = (ProfesorAdjunto) profeAdj;
                break;
            }
        }
        for (Profesor profeTit : listaDeProfesores) {
            if (codigoProfesorTitular.equals(profeTit.getCodigoDeProfesor())) {
                profeTitularAAsignar = (ProfesorTitular) profeTit;
                break;
            }
        }
        cursoAAsignar.setProfesorAdjunto(profeAdjuntoAAsignar);
        cursoAAsignar.setProfesorTitular(profeTitularAAsignar);
    }

    //Voy a crear los metodos para poder dar de alta y baja las guias.
    public void altaGuiaPractica(Integer codigoGuia, Integer cantidadPaginas, Double costo, String titulo, Integer cantidadDeEjercicios) {
        Guia unaGuia = new GuiaPractica(codigoGuia, cantidadPaginas, costo, titulo, cantidadDeEjercicios);
        listaDeGuias.add(unaGuia);
    }

    public void altaGuiaTeorica(Integer codigoGuia, Integer cantidadPaginas, Double costo, String titulo, List<String> listaDeTemas) {
        Guia unaGuia = new GuiaTeorica(codigoGuia, cantidadPaginas, costo, titulo, listaDeTemas);
        listaDeGuias.add(unaGuia);
    }

    //Voy a definir metodos para buscar las guias y los cursos solo por su codigo.
    public Guia buscarGuia(Integer codigoDeGuia) {
        Guia guiaAEncontrar = null;
        for (Guia unaGuia : listaDeGuias) {
            if (unaGuia.getCodigoGuia().equals(codigoDeGuia)) {
                guiaAEncontrar = unaGuia;
                break;
            }
        }
        return guiaAEncontrar;
    }

    public Curso buscarCurso(Integer codigoDeCurso) {
        Curso cursoAEncontrar = null;
        for (Curso unCurso : listaDeCursos) {
            if (unCurso.getCodigoDeCurso().equals(codigoDeCurso)) {
                cursoAEncontrar = unCurso;
                break;
            }
        }
        return cursoAEncontrar;
    }

    public void bajaGuia(Integer codigoDeGuia) {
        Guia unaGuia = null;
        for (Guia guia : listaDeGuias) {
            if (guia.getCodigoGuia().equals(codigoDeGuia)) {
                unaGuia = guia;
                listaDeGuias.remove(unaGuia);
                System.out.printf("Se ha eliminado la guia " + unaGuia.getTitulo() + " de la lista.");

            } else {
                System.out.printf("esta guia no existe en la lista.");
            }
        }
    }
    //Por ultimo tengo que poder asignarle a cada curso su guia
    public void asignarGuiaCurso(Guia nuevaGuia, Curso curso){
        curso.agregarGuia(nuevaGuia);
        System.out.println("Se agrego la guia "+nuevaGuia.getTitulo()+" al curso de codigo "+curso.getNombreDeCurso());
    }
}