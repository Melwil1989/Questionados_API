package ar.com.ada.api.questionados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.repos.PreguntaRepository;

@Service
public class PreguntaService {

    @Autowired
    PreguntaRepository repo;

    public Pregunta buscarPreguntaPorId(Integer preguntaId) {

        Optional<Pregunta> resultado = repo.findById(preguntaId);

        if(resultado.isPresent())
            return resultado.get();

        return null;

    }

    public List<Pregunta> traerPreguntas() {
        return repo.findAll();
    }

    public void crearPregunta(Pregunta pregunta) {
        repo.save(pregunta);
    }
    
}
