package com.tienda.dao;

import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {
    
public List<Categoria> findByDescripcionContainingIgnoreCaseOrderByDescripcion(String descripcion);

@Query("SELECT c FROM Categoria c WHERE LOWER(c.descripcion) LIKE LOWER(CONCAT('%', :descripcion, '%'))")
List<Categoria> filtrarPorNombre(@Param("descripcion") String descripcion);

}
