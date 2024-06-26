package org.example.io;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Statistics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsWriter {

    private static final Logger logger = Logger.getLogger(XlsWriter.class.getName());

    public static void writeXlsStatistics(List<Statistics> statisticsList,
                                          String filePath) {

        logger.log(Level.INFO, "Excel writing started");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statisticsSheet = workbook.createSheet("Статистика");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

        Font bodyFont = workbook.createFont();
        bodyFont.setFontHeightInPoints((short) 12);
        CellStyle bodyStyle = workbook.createCellStyle();
        bodyStyle.setFont(bodyFont);

        int rowNumber = 0;
        Row headerRow = statisticsSheet.createRow(rowNumber++);
        Cell profileCellHeader = headerRow.createCell(0);
        profileCellHeader.setCellValue("Профиль обучения");
        profileCellHeader.setCellStyle(headerStyle);
        Cell avgScoreCellHeader = headerRow.createCell(1);
        avgScoreCellHeader.setCellValue("Средний балл за экзамены по профилю");
        avgScoreCellHeader.setCellStyle(headerStyle);
        Cell numberOfStudentsCellHeader = headerRow.createCell(2);
        numberOfStudentsCellHeader.setCellValue("Количество студентов по профилю");
        numberOfStudentsCellHeader.setCellStyle(headerStyle);
        Cell numberOfUniversitiesCellHeader = headerRow.createCell(3);
        numberOfUniversitiesCellHeader.setCellValue("Количество университетов по профилю");
        numberOfUniversitiesCellHeader.setCellStyle(headerStyle);
        Cell universitiesCellHeader = headerRow.createCell(4);
        universitiesCellHeader.setCellValue("Название университета");
        universitiesCellHeader.setCellStyle(headerStyle);

        for (Statistics statistics : statisticsList) {
            Row dataRow = statisticsSheet.createRow(rowNumber++);
            Cell profileCell = dataRow.createCell(0);
            profileCell.setCellValue(statistics.getProfile().getProfileName());
            profileCell.setCellStyle(bodyStyle);
            Cell avgScoreCell = dataRow.createCell(1);
            avgScoreCell.setCellValue(statistics.getAvgExamScore());
            profileCell.setCellStyle(bodyStyle);
            Cell numberOfStudentsCell = dataRow.createCell(2);
            numberOfStudentsCell.setCellValue(statistics.getNumberOfStudents());
            profileCell.setCellStyle(bodyStyle);
            Cell numberOfUniversitiesCell = dataRow.createCell(3);
            numberOfUniversitiesCell.setCellValue(statistics.getNumberOfUniversities());
            profileCell.setCellStyle(bodyStyle);
            Cell universitiesCell = dataRow.createCell(4);
            universitiesCell.setCellValue(statistics.getUniversityNames());
            profileCell.setCellStyle(bodyStyle);
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "New excel file writing failed", e);
            return;
        }

        logger.log(Level.INFO, "Excel writing finished successfully");
    }
}