package com.prepago.prueba_estudiante.dao.dto;

import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto<T> {
    private String statusCode;
    private String message;
    private T response;
}
