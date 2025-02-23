/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package com.anhtester.utils;

import com.anhtester.exceptions.FrameworkException;
import com.anhtester.exceptions.InvalidPathForExtentReportFileException;
import com.anhtester.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReportUtils {

    private ReportUtils() {
        
    }

    public static String createExtentReportPath() {
        String link = "";
        if (FrameworkConstants.OVERRIDE_REPORTS.trim().equals(FrameworkConstants.NO)) {
            System.out.println("OVERRIDE_REPORTS = " + FrameworkConstants.OVERRIDE_REPORTS);
            link = FrameworkConstants.EXTENT_REPORT_FOLDER_PATH + File.separator + DateUtils.getCurrentDate() + "_"
                    + FrameworkConstants.EXTENT_REPORT_FILE_NAME;
            System.out.println("Created link reports: " + link);
            return link;
        } else {
            System.out.println("OVERRIDE_REPORTS = " + FrameworkConstants.OVERRIDE_REPORTS);
            link = FrameworkConstants.EXTENT_REPORT_FOLDER_PATH + File.separator + FrameworkConstants.EXTENT_REPORT_FILE_NAME;
            LogUtils.info("Created link reports: " + link);
            return link;
        }
    }

    public static void openReports(String linkReport) {
        if (FrameworkConstants.OPEN_REPORTS_AFTER_EXECUTION.trim().equalsIgnoreCase(FrameworkConstants.YES)) {
            try {
                Desktop.getDesktop().browse(new File(linkReport).toURI());
            } catch (FileNotFoundException fileNotFoundException) {
                throw new InvalidPathForExtentReportFileException("Extent Report file you are trying to reach is not found", fileNotFoundException.fillInStackTrace());
            } catch (IOException ioException) {
                throw new FrameworkException("Extent Report file you are trying to reach got IOException while reading the file", ioException.fillInStackTrace());
            }
        }
    }
}

