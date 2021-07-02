package edu.mum.cs.cs425.studentmgmt.mystudentmgmtapp;

import edu.mum.cs.cs425.studentmgmt.mystudentmgmtapp.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.mystudentmgmtapp.model.Student;
import edu.mum.cs.cs425.studentmgmt.mystudentmgmtapp.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.mystudentmgmtapp.repository.ClassroomRepository;
import edu.mum.cs.cs425.studentmgmt.mystudentmgmtapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassroomRepository classroomRepository;
    @Override
    public void run(String... args) throws Exception {

        Classroom classroom=new Classroom("McLaughlin building", "M105");

        Transcript transcript=new Transcript("BS Computer Science");
        Transcript transcript2=new Transcript("MSc Computer Science");

        Student s1=new Student("000-61-0001", "Anna", "Lynn", "Smith",
                3.45,LocalDate.of(2019,5,24),transcript);
        Student s2=new Student("000-61-0002", "Mnna", "Tina", "Tom",
                3.90,LocalDate.of(2019,5,24),transcript2);
        List<Student> students=Arrays.asList(s1,s2);

//        Student newStudent=saveStudent(s1);// saving student with out the classroom
        classroom.setStudents(students);
        classroom.addStudent(students);//to add the classroom id to each students
        Classroom newClassRoom=saveClassroom(classroom);//save classroom will also save each students and there transcripts
        System.out.println(newClassRoom.getStudents());
//        System.out.println(newStudent);

    }

    public static void main(String[] args) {
        SpringApplication.run(StudentMgmtApp.class, args);
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Classroom saveClassroom(Classroom classroom){
        return classroomRepository.save(classroom);
    }
}
