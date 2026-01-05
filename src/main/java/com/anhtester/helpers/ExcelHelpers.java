/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package com.anhtester.helpers;

import com.anhtester.exceptions.InvalidPathForExcelException;
import com.anhtester.utils.LogUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

public class ExcelHelpers {

    private FileInputStream fis;
    private FileOutputStream fileOut;
    private final Workbook workbook;
    private final Sheet sheet;
    private Cell cell;
    private Row row;
    private final String excelFilePath;
    private final Map<String, Integer> columns = new HashMap<>();

    /**
     * Constructs an ExcelHelpers object and sets up the Excel file and sheet for reading and writing.
     *
     * @param excelPath the path to the Excel file.
     * @param sheetName the name of the sheet to be accessed.
     */
    public ExcelHelpers(String excelPath, String sheetName) {
        this.excelFilePath = excelPath;
        try {
            fis = new FileInputStream(excelPath);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new InvalidPathForExcelException("Sheet with name '" + sheetName + "' does not exist in the Excel file.");
            }
            mapColumnHeaders();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the Excel file: " + e.getMessage(), e);
        }
    }

    /**
     * Maps the column headers to their respective column indices.
     */
    private void mapColumnHeaders() {
        Row firstRow = sheet.getRow(0);
        if (firstRow != null) {
            firstRow.forEach(cell -> {
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });
        }
    }

    /**
     * Closes the workbook and input stream to release file resources.
     */
    public void close() {
        try {
            if (workbook != null) {
                workbook.close();
            }
            if (fis != null) {
                fis.close();
            }
        } catch (IOException e) {
            LogUtils.error("Failed to close the Excel file resources: " + e.getMessage());
        }
    }

    /**
     * Saves the changes made to the workbook back to the Excel file.
     */
    public void save() {
        try {
            fileOut = new FileOutputStream(excelFilePath);
            workbook.write(fileOut);
        } catch (IOException e) {
            LogUtils.error("Failed to save the Excel file: " + e.getMessage());
        } finally {
            try {
                if (fileOut != null) {
                    fileOut.close();
                }
            } catch (IOException e) {
                LogUtils.error("Failed to close the FileOutputStream: " + e.getMessage());
            }
        }
    }

    /**
     * Retrieves the cell value as a String.
     *
     * @param cell the cell from which to retrieve the value.
     * @return the cell value as a String, or an empty string if the cell is null.
     */
    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return Objects.toString(cell.getDateCellValue(), "");
                }
                return Objects.toString((long) cell.getNumericCellValue(), "");
            case BOOLEAN:
                return Objects.toString(cell.getBooleanCellValue(), "");
            case BLANK:
                return "";
            default:
                return cell.toString();
        }
    }

    /**
     * Gets the data from the specified row.
     *
     * @param rowNum the row number.
     * @return the Row object.
     */
    public Row getRowData(int rowNum) {
        return sheet.getRow(rowNum);
    }

    /**
     * Retrieves all test data from the Excel sheet as a 2D array of Hashtables.
     *
     * @return a 2D array of objects, where each object is a Hashtable representing a row of data.
     */
    public Object[][] getTestData() {
        return getTestData(1, getRows());
    }

    /**
     * Retrieves test data from a specified range of rows in the Excel sheet.
     *
     * @param startRow the starting row number.
     * @param endRow   the ending row number.
     * @return a 2D array of objects, where each object is a Hashtable representing a row of data.
     */
    public Object[][] getTestData(int startRow, int endRow) {
        Object[][] data = new Object[(endRow - startRow) + 1][1];
        Hashtable<String, String> table;
        for (int i = startRow; i <= endRow; i++) {
            table = new Hashtable<>();
            Row row = getRowData(i);
            for (int j = 0; j < getColumns(); j++) {
                String header = getCellValue(getRowData(0).getCell(j));
                String value = getCellValue(row.getCell(j));
                table.put(header, value);
            }
            data[i - startRow][0] = table;
        }
        return data;
    }

    /**
     * Retrieves all data from the sheet as a 2D String array, skipping the header row.
     *
     * @return a 2D String array containing the sheet data.
     */
    public String[][] getSheetData() {
        int rowCount = getRows();
        int colCount = getColumns();
        String[][] data = new String[rowCount][colCount];
        for (int i = 1; i <= rowCount; i++) {
            Row row = getRowData(i);
            if (row != null) {
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = getCellValue(row.getCell(j));
                }
            }
        }
        return data;
    }

    /**
     * Gets the name of the test case from a given string.
     *
     * @param testCaseName the full test case name.
     * @return the simplified test case name.
     */
    public String getTestCaseName(String testCaseName) {
        int atIndex = testCaseName.indexOf('@');
        if (atIndex != -1) {
            testCaseName = testCaseName.substring(0, atIndex);
        }
        int dotIndex = testCaseName.lastIndexOf('.');
        if (dotIndex != -1) {
            testCaseName = testCaseName.substring(dotIndex + 1);
        }
        return testCaseName;
    }

    /**
     * Finds the row number that contains a specific test case name in a given column.
     *
     * @param testCaseName the name of the test case to find.
     * @param colNum       the column number to search in.
     * @return the row number, or -1 if not found.
     */
    public int getRowContains(String testCaseName, int colNum) {
        for (int i = 0; i <= getRows(); i++) {
            if (getCellData(i, colNum).equalsIgnoreCase(testCaseName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Gets the total number of rows in the sheet.
     *
     * @return the last row number.
     */
    public int getRows() {
        return sheet.getLastRowNum();
    }

    /**
     * Gets the total number of columns in the sheet.
     *
     * @return the last column number in the first row.
     */
    public int getColumns() {
        return sheet.getRow(0).getLastCellNum();
    }

    /**
     * Gets the data of a specific cell by row and column number.
     *
     * @param rowNum the row number.
     * @param colNum the column number.
     * @return the cell data as a String.
     */
    public String getCellData(int rowNum, int colNum) {
        if (rowNum < 0 || colNum < 0) return "";
        row = sheet.getRow(rowNum);
        if (row == null) return "";
        cell = row.getCell(colNum);
        return getCellValue(cell);
    }

    /**
     * Gets the data of a specific cell by row number and column name.
     *
     * @param rowNum     the row number.
     * @param columnName the column name.
     * @return the cell data as a String.
     */
    public String getCellData(int rowNum, String columnName) {
        if (!columns.containsKey(columnName)) {
            LogUtils.error("Column '" + columnName + "' does not exist.");
            return "";
        }
        return getCellData(rowNum, columns.get(columnName));
    }

    /**
     * Sets the data of a specific cell by row and column number.
     *
     * @param text      the text to set.
     * @param rowNumber the row number.
     * @param colNumber the column number.
     */
    public void setCellData(String text, int rowNumber, int colNumber) {
        row = sheet.getRow(rowNumber);
        if (row == null) {
            row = sheet.createRow(rowNumber);
        }
        cell = row.getCell(colNumber);
        if (cell == null) {
            cell = row.createCell(colNumber);
        }
        cell.setCellValue(text);
        applyCellStyle(cell, text);
    }

    /**
     * Sets the data of a specific cell by row number and column name.
     *
     * @param text       the text to set.
     * @param rowNumber  the row number.
     * @param columnName the column name.
     */
    public void setCellData(String text, int rowNumber, String columnName) {
        if (!columns.containsKey(columnName)) {
            LogUtils.error("Column '" + columnName + "' does not exist. Cannot set cell data.");
            return;
        }
        setCellData(text, rowNumber, columns.get(columnName));
    }

    /**
     * Applies cell style based on the cell text (e.g., "pass" or "fail").
     *
     * @param cell the cell to style.
     * @param text the text content of the cell.
     */
    private void applyCellStyle(Cell cell, String text) {
        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        String lowerCaseText = text.trim().toLowerCase();
        if (lowerCaseText.equals("pass") || lowerCaseText.equals("passed") || lowerCaseText.equals("success")) {
            style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
        } else if (lowerCaseText.equals("fail") || lowerCaseText.equals("failed") || lowerCaseText.equals("failure")) {
            style.setFillForegroundColor(IndexedColors.RED.getIndex());
        }
        cell.setCellStyle(style);
    }
}
