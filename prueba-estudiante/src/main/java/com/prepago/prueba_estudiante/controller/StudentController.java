package com.prepago.prueba_estudiante.controller;

import com.prepago.prueba_estudiante.dao.dto.StudentRequestDto;
import com.prepago.prueba_estudiante.dao.dto.StudentResponseDto;
import com.prepago.prueba_estudiante.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${controller.properties.base-path}")
public class StudentController {
    private final IStudentService iStudentService;

    @Autowired
    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDto<?> createStudent(@RequestBody StudentRequestDto requestDto) {
        return this.iStudentService.createStudent(requestDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.FOUND)
    public StudentResponseDto<?> getAllStudents() {
        return this.iStudentService.getAllStudents();
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public StudentResponseDto<?> updateStudent(@RequestBody StudentRequestDto requestDto) {
        return this.iStudentService.updateStudent(requestDto);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.OK)
    public StudentResponseDto<?> deleteStudent(@RequestParam("eid") Integer eid) {
        return this.iStudentService.deleteStudent(eid);
    }
}
