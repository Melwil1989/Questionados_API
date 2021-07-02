package ar.com.ada.api.questionados.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.questionados.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
}
