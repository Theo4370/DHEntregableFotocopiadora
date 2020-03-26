package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DigitalHouseManager nuevoManager = new DigitalHouseManager();

        //Creo los profesores

        nuevoManager.altaProfesorAdjunto("Tomas", "Contreras", 3819, 2);
        nuevoManager.altaProfesorAdjunto("Jose", "Verdini", 4178, 5);
        nuevoManager.altaProfesorTitular("Pedro", "Fatti", 4370, "Redes sociales");
        nuevoManager.altaProfesorTitular("Chester", "Gonzalez", 1856, "Diseño de paginas web");

        //Creo los cursos

        nuevoManager.altaCurso("Full Stack", 20001, 3);
        nuevoManager.altaCurso("Android", 20002, 2);

        //Asigo profesores a los cursos

        nuevoManager.asignarProfesores(20001, 1856, 4178);
        nuevoManager.asignarProfesores(20002, 4370, 3819);

        //Doy de alta 3 alumnos

        nuevoManager.altaAlumno("Theo", "Musumeci", 113, false);
        nuevoManager.altaAlumno("Juan", "Perez", 365, true);
        nuevoManager.altaAlumno("Tomas", "Nuñez", 867, true);

        //Inscribo 2 alumnos en el curso Full Stack

        nuevoManager.inscribirAlumno(113, 20001);
        nuevoManager.inscribirAlumno(867, 20001);

        //Inscribo 3 alumnos al curso Android

        nuevoManager.inscribirAlumno(113, 20002);
        nuevoManager.inscribirAlumno(867, 20002);
        nuevoManager.inscribirAlumno(365, 20002);

        //Doy de baja un profesor

        nuevoManager.bajaProfesor(4178);

        //Doy de baja un curso

       // nuevoManager.bajaCurso(20002);


        nuevoManager.altaGuiaPractica(111,30,45.6,"Ejercicios de matematica",15);

        List<String> temas = new ArrayList<>();
        temas.add("tema 1");
        temas.add("tema 2");
        nuevoManager.altaGuiaTeorica(222,34,39.8,"Teoria de la...", temas);

nuevoManager.asignarGuiaCurso(nuevoManager.buscarGuia(111),nuevoManager.buscarCurso(20001));
nuevoManager.asignarGuiaCurso(nuevoManager.buscarGuia(222),nuevoManager.buscarCurso(20002));

Fotocopiadora fotocopiadora = new Fotocopiadora();
fotocopiadora.imprimirGuia(222);

    }
}
