package org.iplacex.proyectos.discografia.artistas;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface IArtistaRepository extends MongoRepository<Artista, String> {

    // Buscar por nombre
    @Query("{ 'nombre': ?0 }")
    Artista findArtistaByNombre(String nombre);

    // Buscar por estilo
    @Query("{ 'estilos': ?0 }")
    List<Artista> findArtistasByEstilo(String estilo);

    // Buscar artistas que tengan un año de fundación mayor que el valor dado
    @Query("{ 'anioFundacion': { $gt: ?0 } }")
    List<Artista> findArtistasByAnioFundacionGreaterThan(int anioFundacion);

    // Buscar artistas activos
    @Query("{ 'estaActivo': ?0 }")
    List<Artista> findArtistasByEstaActivo(boolean estaActivo);

    // Buscar por año de fundación dentro de rango
    @Query("{ 'anioFundacion': { $gte: ?0, $lte: ?1 } }")
    List<Artista> findArtistasByAnioFundacionBetween(int anioInicio, int anioFin);
}