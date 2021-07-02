package ar.com.ada.api.questionados.entities;

import javax.persistence.*;

@Entity
@Table(name="respuesta")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="respuesta_id")
    private Integer respuestaId;

    private String texto;

    private boolean esCorrecta;

    @ManyToOne
    @JoinColumn(name="pregunta_id",referencedColumnName = "pregunta_id")
    private Pregunta pregunta;


   
    public Integer getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(Integer respuestaId) {
        this.respuestaId = respuestaId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
        this.pregunta.agregarRespuesta(this);//relacion bidireccional
    }

    
}
