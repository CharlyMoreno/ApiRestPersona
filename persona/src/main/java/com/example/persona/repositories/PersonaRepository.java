package com.example.persona.repositories;

import com.example.persona.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    @Query(value="SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param("filtro") String filtro);

    @Query(
            value="Select * from persona where persona.nombre Like %:filtro% or persona.apellido like %:filtro%",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);

    @Query(
            value="Select * from persona where persona.nombre Like %:filtro% or persona.apellido like %:filtro%",
            nativeQuery = true,
            countQuery = "SELECT count (*) from persona"
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
