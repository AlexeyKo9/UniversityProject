package org.example;


import org.example.Student.Student;
import org.example.University.University;
import org.example.University.StudyProfile;

public class Main {
    public static void main(String[] args) {
        University university1 = new University("1", "Забайкальский Институт Железнодорожного Транспорта", "ЗабИЖТ", 1956, StudyProfile.ENGINEERING);
        University university2 = new University("2", "Читинская государственная медицинская академия", "ЧГМА", 1953, StudyProfile.MEDICINE);
        University university3 = new University("3", "Московский технологический институт", "МТИ", 1997, StudyProfile.IT);
        Student student1 = new Student("Иванов Иван Иванович", "1", 5, 4.0f);
        Student student2 = new Student("Петрова Юлия Сергеевна", "2", 3, 4.7f);
        Student student3 = new Student("Васильев Игорь Александрович", "3", 1, 3.8f);
        System.out.println(university1);
        System.out.println(university2);
        System.out.println(university3);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }
}