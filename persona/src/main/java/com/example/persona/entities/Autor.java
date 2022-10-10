package com.example.persona.entities;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="autor")
@Data
@Audited
public class Autor extends Base {
    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="biografia",length = 1500)
    private String biografia;

}
