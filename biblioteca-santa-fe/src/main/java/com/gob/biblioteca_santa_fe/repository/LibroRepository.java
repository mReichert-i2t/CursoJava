package com.gob.biblioteca_santa_fe.repository;

import com.gob.biblioteca_santa_fe.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    List<Libro> libros;

    public LibroRepository(){

        libros= new ArrayList<>();

        libros.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 5, 3));
        libros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 7, 1));
        libros.add(new Libro("1984", "George Orwell", 4, 2));
        libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 10, 5));
        libros.add(new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 3, 1));
        libros.add(new Libro("La Odisea", "Homero", 8, 6));
        libros.add(new Libro("Fahrenheit 451", "Ray Bradbury", 9, 4));
        libros.add(new Libro("Matar a un ruiseñor", "Harper Lee", 6, 2));
        libros.add(new Libro("Crimen y castigo", "Fiódor Dostoyevski", 5, 2));
        libros.add(new Libro("Los miserables", "Victor Hugo", 12, 7));
    }

    public List<Libro> findAll(){
        return this.libros;
    }

    public Libro findByNombre(String nombre){

        return libros.stream().filter(
                libro -> libro.getNombre().equals(nombre))
                .findAny()
                .get();
    }

    public Libro findByAutor(String autor){

        return libros.stream().filter(
                        libro -> libro.getAutor().equals(autor))
                .findAny()
                .get();

    }

    public void agregarLibro(Libro libro){

        libros.add(libro);
    }

}
