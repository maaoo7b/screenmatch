package com.aluracursos.screenmatch.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploStreams {

    public void showExample(){
        List<String> names = Arrays.asList("Brenda","Luis","Eric","Genesys","Maria Fernanda");
        names.stream().sorted().limit(5).filter(n->n.startsWith("L")).map(n->n.toUpperCase()).forEach(System.out::println);
    }

}
