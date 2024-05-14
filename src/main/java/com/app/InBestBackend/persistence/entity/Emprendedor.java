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
    
    @OneToOne
    @JoinColumn(name="id_persona")
    private Usuario usuario;
    
    @OneToMany(mappedBy = "emprendedor", targetEntity = Negocio.class)
    private List<Negocio> negocios;
    
    @OneToMany(mappedBy = "emprendedor", targetEntity = Inversion.class)
    private List<Inversion> inversiones;
    
}
