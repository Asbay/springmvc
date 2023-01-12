package com.tpe.service;


import com.tpe.domain.Student;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;  //interfacei yaziyoruz cünkü claslarda degisiklik yaparsak kod calismaz ama interface degismiycek ordan
    //altindaki classlara da ulasabiliriz @autowired da ya interfaci yada concurrent classi ekliycem. concurrent classda degisiklik yapilma ihtimali oldugu icin
    //onu yazmiyoruz . Interfacede degisiklik olmaz o yuzden onu yaziyoruz.

    @Override
    public List<Student> getAllStudent() {

        return repository.getAll();
    }


    @Override
    public Student findStudentById(Long id) {

        Student student = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Istenilen id li Student objesi bulunamadi: "+ id));
        //aslinda bu repo da optinal olan bi obje ama bizim mthodda student vermesi lazim

        return student;
    }

    @Override
    public void saveStudent(Student student) {

        repository.save(student);

    }

    @Override
    public void updateStudent(Student student) {
        repository.update(student);

    }

    @Override
    public void deleteStudent(Long id) {
        repository.delete(id);

    }
}
