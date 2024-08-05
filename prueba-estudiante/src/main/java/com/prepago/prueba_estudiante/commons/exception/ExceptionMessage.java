package com.prepago.prueba_estudiante.commons.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prepago.prueba_estudiante.commons.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionMessage {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.TIMESTAMP_FORMAT)
    private String timestamp;
    private String message;
    private String path;
}
