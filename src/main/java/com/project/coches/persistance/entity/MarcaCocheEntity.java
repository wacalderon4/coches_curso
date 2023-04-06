package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //Se indica que se crea una entidad
@Table(name="marca_coche") // Se muestra el nombre de la primera tabla de la BD
public class MarcaCocheEntity {

    /*
     * Id de la marca
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;// utilizar el wrapper , no el tipo de dato nativo

    /*
     * Descripcion de la marca
     * */
    @Column(name= "descripcion")
    private String description;



}
