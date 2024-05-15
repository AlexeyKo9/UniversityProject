package org.example;


import org.example.io.ExcelReader;
import org.example.student.Student;
import org.example.university.University;
import org.example.university.StudyProfile;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<University> universities =
                ExcelReader.readUniversities("src/main/resources/universityInfo.xlsx");
        for(University university : universities) {
            System.out.println(university);
        }

        List<Student> students =
                ExcelReader.readStudents("src/main/resources/universityInfo.xlsx");
        for(Student student : students) {
            System.out.println(student);
        }
    }
}