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
@Table(name="gama")
public class Gama implements Serializable {
    @Id //aqui le digo q esta es la primary key en la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincremental
    private Long idGama;
    private String name;
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy ="gama" ) //le digo q hay una relacion 1 a muchos en la bd
    @JsonIgnoreProperties("gama")
    private List<Car> cars; //llamado a la lista de carros

}
