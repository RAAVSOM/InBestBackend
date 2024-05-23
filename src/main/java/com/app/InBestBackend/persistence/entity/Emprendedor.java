package com.app.InBestBackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Emprendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_emprendedor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_persona")
    private Usuario usuario;

    //realizar control de sobrecarga vaciando el emprendedor y las listas
    @OneToMany(mappedBy = "emprendedor", targetEntity = Negocio.class)
    private List<Negocio> negocios;

    //realizar control de sobrecarga vaciando todas las clases
    @OneToMany(mappedBy = "emprendedor", targetEntity = Inversion.class)
    private List<Inversion> inversiones;
    
}
