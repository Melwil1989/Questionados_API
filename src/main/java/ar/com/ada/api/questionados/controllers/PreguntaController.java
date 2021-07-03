package ar.com.ada.api.questionados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.models.request.InfoPreguntaNueva;
import ar.com.ada.api.questionados.models.response.GenericResponse;
import ar.com.ada.api.questionados.services.PreguntaService;

@RestController
public class PreguntaController {

    @Autowired
    PreguntaService service;

    @GetMapping("/pregunta")
    public ResponseEntity<List<Pregunta>> traerPreguntas() {

        return ResponseEntity.ok(service.traerPreguntas());
    }

    @GetMapping("/pregunta/{id}")
    public ResponseEntity<Pregunta> buscarPreguntaPorId(@PathVariable Integer id) {
        
        return ResponseEntity.ok(service.buscarPreguntaPorId(id));
    } 

    @PostMapping("/pregunta")
    public ResponseEntity<?> crearPregunta(@RequestBody InfoPreguntaNueva preguntaNueva) {

        GenericResponse respuesta = new GenericResponse();

        Pregunta pregunta = service.crearPregunta(preguntaNueva.enunciado, preguntaNueva.categoriaId, preguntaNueva.opciones);

        respuesta.id = pregunta.getPreguntaId();
        respuesta.isOk = true;
        respuesta.message = "La pregunta fue creada con exito";

        return ResponseEntity.ok(respuesta);
    }
    
}
