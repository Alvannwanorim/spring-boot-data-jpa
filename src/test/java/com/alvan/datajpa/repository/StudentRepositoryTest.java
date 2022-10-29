package com.alvan.datajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alvan.datajpa.entity.Guardian;
import com.alvan.datajpa.entity.Student;


@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                            .emailId("alvan2@gmail.com")
                            .firstName("Alvan")
                            .lastName("Young")
                            // .guardianMobile("New")
                            // .guardianEmail("new@gmail.com")
                            // .guardianMobile("99999999999")
                            .build();
        studentRepository.save(student);
    
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                                    .name("New")
                                    .email("new@gmail.com")
                                    .mobile("99999999999")
                                    .build();
        Student student = Student.builder()
                                .emailId("alvan3@gmail.com")
                                .firstName("Alvan")
                                .lastName("Young")
                                .guardian(guardian)
                                .build();
        studentRepository.save(student);
    }
    @Test
    public void printAllStudent(){
        List<Student> studentList = 
                        studentRepository.findAll();
        System.out.println(studentList);

    }

    @Test
    public void printStudentByName(){
        List<Student> student = 
                                studentRepository.findByFirstName("Alvan");
        System.out.println(student);
    }
    @Test
    public void printStudentByNameContaining(){
        List<Student> student = 
                                studentRepository.findByFirstNameContaining("Al");
        System.out.println(student);
    }

    @Test
    public void printStudentByNameAndLastName(){
        List<Student> student = 
                                studentRepository.findByFirstNameAndLastName("Alvan", "Young");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = 
                                studentRepository.getStudentByEmailAddress("alvan@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student = 
                                studentRepository.getStudentByEmailAddressNative("alvan@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddressNativeParam(){
        Student student = 
                                studentRepository.getStudentByEmailAddressNativeParams("alvan@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudntFirstNameByEmail(){
        int student = 
                                studentRepository.updateStudntFirstNameByEmail("alvan","alvan@gmail.com");
        System.out.println(student);
    }
}
