package com.gob.biblioteca_santa_fe.repository;

import com.gob.biblioteca_santa_fe.model.Libro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    //List<Libro> libros;

    // public LibroRepository(){

    //     libros= new ArrayList<>();

    //     libros.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 5, 3));
    //     libros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 7, 1));
    //     libros.add(new Libro("1984", "George Orwell", 4, 2));
    //     libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 10, 5));
    //     libros.add(new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 3, 1));
    //     libros.add(new Libro("La Odisea", "Homero", 8, 6));
    //     libros.add(new Libro("Fahrenheit 451", "Ray Bradbury", 9, 4));
    //     libros.add(new Libro("Matar a un ruiseñor", "Harper Lee", 6, 2));
    //     libros.add(new Libro("Crimen y castigo", "Fiódor Dostoyevski", 5, 2));
    //     libros.add(new Libro("Los miserables", "Victor Hugo", 12, 7));
    // }

    public static final List<Libro> libros = null;

    // public LibroRepository() {
    //     libros = new ArrayList<>();
    //     // Asignar ID manualmente
    //     libros.add(new Libro(nextId++, "1234567890", "Cien Años de Soledad", "Gabriel García Márquez", 5, null, null, null));
    //     libros.add(new Libro(nextId++, "0987654321", "Don Quijote de la Mancha", "Miguel de Cervantes", 7, null, null,null));
    //     libros.add(new Libro(nextId++, "1122334455", "1984", "George Orwell", 4, null, null,null));
    //     libros.add(new Libro(nextId++, "2233445566", "El Principito", "Antoine de Saint-Exupéry", 10, null, null,null));
    //     libros.add(new Libro(nextId++, "3344556677", "El Señor de los Anillos", "J.R.R. Tolkien", 3, null, null,null));
    //     libros.add(new Libro(nextId++, "4455667788", "La Odisea", "Homero", 8, null, null,null));
    //     libros.add(new Libro(nextId++, "5566778899", "Fahrenheit 451", "Ray Bradbury", 9, null, null,null));
    //     libros.add(new Libro(nextId++, "6677889900", "Matar a un ruiseñor", "Harper Lee", 6, null, null,null));
    //     libros.add(new Libro(nextId++, "7788990011", "Crimen y castigo", "Fiódor Dostoyevski", 5, null, null,null));
    //     libros.add(new Libro(nextId++, "8899001122", "Los miserables", "Victor Hugo", 12, null, null,null));
    // }

    public default List<Libro> findAll(){
        return this.libros;
    }

    public default Libro findByNombre(String nombre){

        return libros.stream().filter(
                libro -> libro.getNombre().equals(nombre))
                .findAny()
                .get();
    }

    public default Libro findByAutor(String autor){

        return libros.stream().filter(
                        libro -> libro.getAutor().equals(autor))
                .findAny()
                .get();

    }

    public default void agregarLibro(Libro libro){

        libros.add(libro);
    }

}
