package com.alvan.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvan.datajpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{
    
}
