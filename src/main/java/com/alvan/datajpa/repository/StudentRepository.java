package com.alvan.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alvan.datajpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId =?1")
    Student getStudentByEmailAddress(String emailId);


    //Native SQL
    @Query(
        value = "select * from mit_student s where s.email =?1",
        nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //Native SQL with Named Params
    @Query(
        value = "select * from mit_student s where s.email = :emailId",
        nativeQuery = true
    )
    Student getStudentByEmailAddressNativeParams(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
        value = "update mit_student set first_name = ?1 where email =?2",
        nativeQuery = true
    )
    int updateStudntFirstNameByEmail(String firstName, String emailId);
}
