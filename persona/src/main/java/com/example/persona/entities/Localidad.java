package com.example.persona.entities;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="localidad")
@Data
@Audited
public class Localidad extends Base{
    @Column(name="denominacion")
    private String denominacion;
}
