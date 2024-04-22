package mx.utng.ich.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class ConcursoFotografia {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(length = 30)
    private String tema;
    
    @Column
    private LocalDate fechaEstablecida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public LocalDate getFechaEstablecida() {
        return fechaEstablecida;
    }

    public void setFechaEstablecida(LocalDate fechaEstablecida) {
        this.fechaEstablecida = fechaEstablecida;
    }

    @Override
    public String toString() {
        return "ConcursoFotografia [id=" + id + ", tema=" + tema + ", fechaEstablecida=" + fechaEstablecida + "]";
    } 

    
}
