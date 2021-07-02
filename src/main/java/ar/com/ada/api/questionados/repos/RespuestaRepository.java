package ar.com.ada.api.questionados.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.questionados.entities.Respuesta;

public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {
    
}
