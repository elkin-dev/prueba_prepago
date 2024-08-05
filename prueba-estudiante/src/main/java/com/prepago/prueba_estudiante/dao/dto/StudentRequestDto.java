package com.prepago.prueba_estudiante.dao.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {
    private Integer eid;
    private String name;
    private String specialty;
    private String grade;
}
