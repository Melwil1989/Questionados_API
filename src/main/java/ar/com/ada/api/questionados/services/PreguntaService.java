package ar.com.ada.api.questionados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.entities.*;
import ar.com.ada.api.questionados.repos.PreguntaRepository;

@Service
public class PreguntaService {

    @Autowired
    PreguntaRepository repo;

    @Autowired
    CategoriaService categoriaService;

    public Pregunta buscarPreguntaPorId(Integer preguntaId) {

        Optional<Pregunta> resultado = repo.findById(preguntaId);

        if(resultado.isPresent())
            return resultado.get();

        return null;
    }

    public List<Pregunta> traerPreguntas() {
        return repo.findAll();
    }

    public Pregunta crearPregunta(String enunciado, Integer categoriaId, List<Respuesta> opciones) {

        if(!existePreguntaPorPregunta(enunciado)) {

            Pregunta pregunta = new Pregunta();
        
            pregunta.setEnunciado(enunciado);

            Categoria categoria = categoriaService.buscarCategoriaPorId(categoriaId);

            pregunta.setCategoria(categoria);
        
            for(Respuesta respuesta : opciones) {
                respuesta.setPregunta(pregunta);
            }

            repo.save(pregunta);
            return pregunta;
        }

        return null;
    }

    public boolean existePorId(int id) {

        Pregunta pregunta = repo.findById(id);
        return pregunta != null;
    }

    public boolean existePreguntaPorPregunta(String enunciado) {

        Pregunta pregunta = repo.findByEnunciado(enunciado);
        return pregunta != null;
    }
    
}
