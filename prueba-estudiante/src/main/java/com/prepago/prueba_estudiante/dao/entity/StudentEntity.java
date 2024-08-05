package com.prepago.prueba_estudiante.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "prepago", name = "prueba_estudiante")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
    @Id
    @Column(name = "eid")
    private Integer eid;
    @Column(name = "nombre")
    private String name;
    @Column(name = "especialidad")
    private String specialty;
    @Column(name = "grado")
    private String grade;

}
