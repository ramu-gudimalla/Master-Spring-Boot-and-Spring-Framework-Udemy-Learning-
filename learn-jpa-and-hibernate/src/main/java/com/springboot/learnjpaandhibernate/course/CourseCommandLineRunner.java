package com.springboot.learnjpaandhibernate.course;

import com.springboot.learnjpaandhibernate.course.Course;
import com.springboot.learnjpaandhibernate.course.jdbc.CourseJDBCRepository;
import com.springboot.learnjpaandhibernate.course.jpa.CourseJPARepository;
import com.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJDBCRepository courseRepository;
    @Autowired
    private CourseSpringDataJPARepository courseRepository;
    @Override
    public void run(String... args) throws Exception {
//        courseRepository.insert(new Course(1L,"JAVA","ram"));
//        courseRepository.insert(new Course(2L,"Spring Framework","laxman"));
//        courseRepository.insert(new Course(3L,"Spring","prashanth"));
        courseRepository.save(new Course(1L,"JAVA","ram"));
        courseRepository.save(new Course(2L,"Spring Framework","laxman"));
        courseRepository.save(new Course(3L,"Spring","prashanth"));
        courseRepository.deleteById(2L);
        System.out.println(courseRepository.findById(1L));
        System.out.println(courseRepository.findById(3L));

        System.out.println(courseRepository.count());

        System.out.println(courseRepository.findByAuthor("ram"));
        System.out.println(courseRepository.findByAuthor(""));
    }
}
