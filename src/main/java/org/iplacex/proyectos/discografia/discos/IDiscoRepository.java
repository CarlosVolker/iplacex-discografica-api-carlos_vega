package org.iplacex.proyectos.discografia.discos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IDiscoRepository extends MongoRepository<Disco, String> {

    // Buscar por título
    @Query("{ 'titulo': ?0 }")
    Disco findDiscoByTitulo(String titulo);

    // Buscar por artista
    @Query("{ 'idArtista': ?0 }")
    List<Disco> findDiscosByArtistaId(String idArtista);

    // Buscar por género
    @Query("{ 'genero': ?0 }")
    List<Disco> findDiscosByGenero(String genero);


    // Buscar discos por año de publicación mayor que el ingresado
    @Query("{ 'anioPublicacion': { $gt: ?0 } }")
    List<Disco> findDiscosByAnioPublicacionGreaterThan(int anioPublicacion);

    //discos en vivo o no
    @Query("{ 'esEnVivo': ?0 }")
    List<Disco> findDiscosByEsEnVivo(boolean esEnVivo);
}
