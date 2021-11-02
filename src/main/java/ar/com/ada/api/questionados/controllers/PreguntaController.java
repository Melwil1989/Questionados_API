package ar.com.ada.api.questionados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.questionados.entities.*;
import ar.com.ada.api.questionados.models.request.InfoPreguntaNueva;
import ar.com.ada.api.questionados.models.response.GenericResponse;
import ar.com.ada.api.questionados.services.PreguntaService;

@RestController
public class PreguntaController {

    @Autowired
    PreguntaService service;

    @GetMapping("/preguntas")
    public ResponseEntity<List<Pregunta>> traerPreguntas() {

        /*List<Pregunta> respuesta = service.traerPreguntas();  (se puede hacer eso?)

        return ResponseEntity.ok(respuesta);*/

        return ResponseEntity.ok(service.traerPreguntas());
    }

    @GetMapping("/preguntas/{id}")
    public ResponseEntity<?> buscarPreguntaPorId(@PathVariable Integer id) {

        GenericResponse respuesta = new GenericResponse();

        if(service.existePorId(id)) {

            return ResponseEntity.ok(service.buscarPreguntaPorId(id));

        } else {

            respuesta.isOk = false;
            respuesta.message = "La pregunta no existe";
        
            return ResponseEntity.badRequest().body(respuesta);
        }
    } 

    @PostMapping("/preguntas")
    public ResponseEntity<?> crearPregunta(@RequestBody InfoPreguntaNueva preguntaNueva) {

        GenericResponse respuesta = new GenericResponse();

        Pregunta pregunta = new Pregunta();

        if(service.crearPregunta(preguntaNueva.enunciado, preguntaNueva.categoriaId, preguntaNueva.opciones) != null) {

            respuesta.id = pregunta.getPreguntaId();
            respuesta.isOk = true;
            respuesta.message = "La pregunta fue creada con exito";
    
            return ResponseEntity.ok(respuesta);

        } else {

            respuesta.isOk = false;
            respuesta.message = "La pregunta ya existe";

            return ResponseEntity.badRequest().body(respuesta);
        }
    }
   
}
