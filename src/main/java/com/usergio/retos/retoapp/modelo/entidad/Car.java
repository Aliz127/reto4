package com.usergio.retos.retoapp.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor // contructor con todos los parametros evito hacerlo manual
@NoArgsConstructor // constructor sin parameteros
@ToString   // mostrar en un string los campos
@Data //me trae lo seter y getter
@Entity  // le digo q mi tabla es una entidad que va a mapiar la tabla
@Table(name="car") // le digo cual es la tabla que va a mapiar
public class Car implements Serializable {
    @Id //aqui le digo q esta es la primary key en la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // atributo Autoincremental
    private Long idCar;
    private String name;
    private String brand;
    private Integer  year;
    private String description;
    @ManyToOne //Realacion muchos a uno
    @JoinColumn(name="gamaId") // indico la foreing key
    @JsonIgnoreProperties("cars")  // bucle
    private Gama gama;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "car") // tabla q va a mapiar
     // cascade es si actulizo la pk el autmaticamente me actualiza todos esos campos que tienen la pk
    @JsonIgnoreProperties({"car","client"})
    private List<Message> messages; //clase con la que se asocia la tabla de muchos

    @OneToMany (cascade = {CascadeType.PERSIST},mappedBy = "car")
    @JsonIgnoreProperties({"car","messages"})
    private List<Reservation> reservations;



}
