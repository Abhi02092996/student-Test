package com.api.service;

import com.api.entity.Student;
import com.api.exception.ResourceNotFoundException;
import com.api.payload.StudentDto;
import com.api.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private ModelMapper modelMapper;
    private StudentRepository stdRepo;

    public StudentService(ModelMapper modelMapper, StudentRepository stdRepo) {
        this.modelMapper = modelMapper;
        this.stdRepo = stdRepo;
    }

    public List<StudentDto> stdData() {
        List<Student> students = stdRepo.findAll();
        List<StudentDto> dto = students.stream().map(e -> stdToDto(e)).collect(Collectors.toList());
        return dto;
    }

    public StudentDto addStudent(StudentDto studentDto) {
        Student std = dtoToStd(studentDto);
        Student save = stdRepo.save(std);
        StudentDto dto = stdToDto(save);
        return dto;
    }

    public void deleteStudent(long id) {
        stdRepo.deleteById(id);
    }

    public StudentDto updateStd(long id, StudentDto studentDto) {

        Student std = stdRepo.findById(id).get();
        modelMapper.map(std,studentDto);

        Student save = stdRepo.save(std);
        StudentDto dto = stdToDto(save);
        return dto;

    }


    Student dtoToStd(StudentDto studentDto) {
        Student std = new Student();
        std.setName(studentDto.getName());
        std.setEmail(studentDto.getEmail());
        std.setMobile(studentDto.getMobile());
        return std;
    }

    StudentDto stdToDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setMobile(student.getMobile());
        return dto;
    }

    public StudentDto getStudentById(long id) {
        Student student = stdRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recored not found")
        );
       return stdToDto(student);
    }
//    Student dtoToStd(StudentDto studentDto){
//        Student std = modelMapper.map(studentDto, Student.class);
//        return std;
//    }
//   StudentDto stdToDto(Student student){
//       StudentDto dto = modelMapper.map(student, StudentDto.class);
//       return dto;
//   }


}
