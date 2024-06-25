package org.example;

import org.example.compare.UniversityComparator;
import org.example.compare.StudentComparator;
import org.example.enums.StudentComparatorEnum;
import org.example.enums.UniversityComparatorEnum;
import org.example.io.JsonWriter;
import org.example.io.XmlWriter;
import org.example.model.FullInfo;
import org.example.model.Statistics;
import org.example.utillites.ComparatorUtil;
import org.example.utillites.StatisticsUtil;
import org.example.io.XlsReader;
import org.example.model.Student;
import org.example.model.University;
import org.example.io.XlsWriter;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(INFO, "Application started, Logger configured");

        List<University> universities =
                XlsReader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorEnum.ID);
        universities.sort(universityComparator);

        List<Student> students =
                XlsReader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorEnum.AVG_EXAM_SCORE);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "src/main/output/statistics.xlsx");

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        XmlWriter.generateXmlReq(fullInfo);
        JsonWriter.writeJsonReq(fullInfo);

        logger.log(INFO, "Application finished");
    }
}