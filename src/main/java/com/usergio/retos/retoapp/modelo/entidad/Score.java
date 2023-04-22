package com.usergio.retos.retoapp.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor // contructor con todos los parametros evito hacerlo manual
@NoArgsConstructor // constructor sin parameteros
@ToString // mostrar en un string los campos
@Data //me trae lo seter y getter
@Entity // le digo q mi tabla es una entidad que va amapiar la tabla
@Table(name="score") // le digo cual es la tabla que va a mapiar
public class Score implements Serializable {
    @Id //aqui le digo q esta es la primary key en la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // atributo Autoincremental
    private Long idScore;
    private String messageText;
    private int stars;
    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

}
