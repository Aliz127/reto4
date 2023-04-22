package com.usergio.retos.retoapp.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data //me trae lo seter y getter
@Entity // le digo q mi tabla es una entidad
@Table(name="message")
public class Message implements Serializable {
    @Id //aqui le digo q esta es la primary key en la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name="carId") // indico la foreing key
    @JsonIgnoreProperties({"messages","reservations"})
    private Car car;

    @ManyToOne
    @JoinColumn(name="clientId") // indico la foreing key
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;


}
