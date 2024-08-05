package com.prepago.prueba_estudiante.service.impl;

import com.prepago.prueba_estudiante.commons.mapper.IStudentRequestMapper;
import com.prepago.prueba_estudiante.dao.dto.StudentRequestDto;
import com.prepago.prueba_estudiante.dao.dto.StudentResponseDto;
import com.prepago.prueba_estudiante.dao.entity.StudentEntity;
import com.prepago.prueba_estudiante.dao.repository.IStudentRepository;
import com.prepago.prueba_estudiante.service.IStudentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository iStudentRepository;
    private final IStudentRequestMapper iStudentRequestMapper;

    @Autowired
    public StudentServiceImpl(IStudentRepository iStudentRepository, IStudentRequestMapper iStudentRequestMapper) {
        this.iStudentRepository = iStudentRepository;
        this.iStudentRequestMapper = iStudentRequestMapper;
    }

    @Override
    @SneakyThrows
    public StudentResponseDto<?> createStudent(StudentRequestDto request) {
        var studentEntity = this.iStudentRequestMapper.studentRequestToEntity(request);
        var result = this.iStudentRepository.save(studentEntity);
        return StudentResponseDto.builder()
                .statusCode("2-OK")
                .message("created success")
                .response(result)
                .build();
    }

    @Override
    @SneakyThrows
    public StudentResponseDto<?> getAllStudents() {
        List<StudentEntity> all = this.iStudentRepository.findAll();
        return StudentResponseDto.builder()
                .statusCode("3-OK")
                .message("find success")
                .response(all)
                .build();
    }

    @Override
    @SneakyThrows
    public StudentResponseDto<?> updateStudent(StudentRequestDto request) {
        String statusCode;
        String message;
        Optional<StudentEntity> byId = this.iStudentRepository.findById(request.getEid());
        if (byId.isPresent()) {
            statusCode = "4-OK";
            message = "update success";
        } else {
            statusCode = "2-OK";
            message = "not found, create success";
        }
        var studentEntity = this.iStudentRequestMapper.studentRequestToEntity(request);
        var result = this.iStudentRepository.save(studentEntity);
        return StudentResponseDto.builder()
                .statusCode(statusCode)
                .message(message)
                .response(result)
                .build();


    }

    @Override
    @SneakyThrows
    public StudentResponseDto<?> deleteStudent(Integer eid) {
        String statusCode;
        String message;
        Optional<StudentEntity> byId = this.iStudentRepository.findById(eid);
        if (byId.isPresent()) {
            this.iStudentRepository.deleteById(eid);
            statusCode = "5-OK";
            message = "delete success";
        } else {
            statusCode = "6-not found";
            message = "not found to delete";
        }
        return StudentResponseDto.builder()
                .statusCode(statusCode)
                .message(message)
                .response("")
                .build();
    }
}
