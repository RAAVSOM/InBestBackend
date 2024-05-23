package com.app.InBestBackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Inversionista {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inversionista;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    //realizar control de sobrecarga en solicitudes borrando las clases que estan en solicitudes
    @OneToMany(mappedBy = "inversionista", targetEntity = Solicitud.class)
    private List<Solicitud> solicitudes;

    //realizar control de sobrecarga en solicitudes borrando las clases que estan en inversiones
    @OneToMany(mappedBy = "inversionista", targetEntity = Inversion.class)
    private List<Inversion> inversiones;
    
}
