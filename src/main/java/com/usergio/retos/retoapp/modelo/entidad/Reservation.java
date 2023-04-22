package com.usergio.retos.retoapp.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data //me trae lo seter y getter
@Entity // le digo q mi tabla es una entidad
@Table(name="reservation")
public class Reservation implements Serializable {
    @Id //aqui le digo q esta es la primary key en la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long idReservation;
    private Date starDate;
    private Date devolutionDate;
    private String status="created";

    @ManyToOne
    @JoinColumn(name="carId") // foreing key
    @JsonIgnoreProperties("reservations")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"reservations","messages"})
    private  Client client;

    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "reservation") //cascade es si actulizo la pk el autmaticamente me actualiza todos esos campos que tienen la pk
   @JsonIgnoreProperties("reservation")
    private Score score;


}
