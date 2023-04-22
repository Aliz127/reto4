package com.usergio.retos.retoapp.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data //me trae lo seter y getter
@Entity // le digo q mi tabla es una entidad
@Table(name="client")
public class Client implements Serializable {
    @Id //aqui le digo q esta es la primary key en la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private Long idClient;
    private String email;
    private String password;
    private String  name;
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client") // tabla q va a mapiar
    @JsonIgnoreProperties("client")
    private List<Message> messages;
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client") // tabla q va a mapiar
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;


}
