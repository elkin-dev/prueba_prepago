package com.prepago.prueba_estudiante.service;

import com.prepago.prueba_estudiante.dao.dto.StudentRequestDto;
import com.prepago.prueba_estudiante.dao.dto.StudentResponseDto;

import java.util.List;

public interface IStudentService {
    StudentResponseDto<?> createStudent(StudentRequestDto request);

    StudentResponseDto<?> getAllStudents();

    StudentResponseDto<?> updateStudent(StudentRequestDto request);

    StudentResponseDto<?> deleteStudent(Integer eid);

}
