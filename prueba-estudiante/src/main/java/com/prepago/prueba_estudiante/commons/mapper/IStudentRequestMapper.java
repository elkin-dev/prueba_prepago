package com.prepago.prueba_estudiante.commons.mapper;

import com.prepago.prueba_estudiante.dao.dto.StudentRequestDto;
import com.prepago.prueba_estudiante.dao.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IStudentRequestMapper {
    @Mappings({})
    StudentEntity studentRequestToEntity(StudentRequestDto source);
}
