package org.example;


import org.example.compare.UniversityComparator;
import org.example.compare.StudentComparator;
import org.example.enums.StudentComparatorEnum;
import org.example.enums.UniversityComparatorEnum;
import org.example.io.ComparatorUtil;
import org.example.io.ExcelReader;
import org.example.universitymanagement.Student;
import org.example.universitymanagement.University;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<University> universities =
                ExcelReader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorEnum.ID);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

        List<Student> students =
                ExcelReader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorEnum.AVG_EXAM_SCORE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
    }
}