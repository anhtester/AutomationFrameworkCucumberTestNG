/*
 * Copyright (c) 2024 Anh Tester
 * Automation Framework Selenium
 */

package com.anhtester.helpers;

import com.anhtester.utils.LogUtils;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvHelpers {

    /**
     * Reads all data from a CSV file.
     *
     * @param csvFilePath the path to the CSV file.
     * @return a 2D String array containing the CSV data, or null if an error occurs.
     */
    public static String[][] readCsvData(String csvFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> allRows = reader.readAll();
            return allRows.toArray(new String[0][]);
        } catch (IOException | CsvException e) {
            LogUtils.error("Failed to read CSV file: " + e.getMessage());
            return new String[0][];
        }
    }

}
