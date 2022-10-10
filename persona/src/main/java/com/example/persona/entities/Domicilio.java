package com.example.persona.entities;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name="domiclio")
@Audited
@Data
public class Domicilio extends Base {

    @Column(name="calle")
    private String calle;

    @Column(name="numero")
    private int numero;

    @ManyToOne(optional = false)
    @JoinColumn(name="fk_localidad")
    private Localidad localidad;
}
