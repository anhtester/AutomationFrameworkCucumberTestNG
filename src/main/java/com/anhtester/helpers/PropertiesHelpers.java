/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package com.anhtester.helpers;

import com.anhtester.utils.LanguageUtils;
import com.anhtester.utils.LogUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

public class PropertiesHelpers {

    private static Properties properties;
    private static String linkFile;
    private static FileInputStream file;
    private static FileOutputStream out;
    private static String relPropertiesFilePathDefault = "src/test/resources/config/config.properties";

    public static Properties loadAllFiles() {
        LinkedList<String> files = new LinkedList<>();
        // Add all file Properties
        files.add("src/test/resources/config/config.properties");
        files.add("src/test/resources/extent.properties");
        files.add("src/test/resources/config/data.properties");

        try {
            properties = new Properties();

            for (String f : files) {
                Properties tempProp = new Properties();
                linkFile = SystemHelpers.getCurrentDir() + f;
                file = new FileInputStream(linkFile);
                tempProp.load(file);
                properties.putAll(tempProp);
            }
            file.close();
            LogUtils.info("Loaded all properties files.");
            LogUtils.info(properties);
            return properties;
        } catch (IOException e) {
            LogUtils.warn("Warning !! Can not Load All File.");
            return new Properties();
        }
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setFile(String relPropertiesFilePath) {
        properties = new Properties();
        try {
            linkFile = SystemHelpers.getCurrentDir() + relPropertiesFilePath;
            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            LogUtils.warn("Warning !! Can not set Properties file.");
            e.printStackTrace();
        }
    }

    public static void setDefaultFile() {
        properties = new Properties();
        try {
            linkFile = SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault;
            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            LogUtils.warn("Warning !! Can not set Default Properties file.");
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        String keyValue = null;
        try {
            if (file == null && properties == null) {
                setDefaultFile();
            }

            keyValue = properties.getProperty(key);
            return LanguageUtils.convertCharset_ISO_8859_1_To_UTF8(keyValue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return keyValue;
        }
    }

    public static void setValue(String key, String keyValue) {
        try {
            if (file == null) {
                properties = new Properties();
                file = new FileInputStream(SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault);
                properties.load(file);
                file.close();
                out = new FileOutputStream(SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault);
            }

            out = new FileOutputStream(linkFile);
            System.out.println(linkFile);
            properties.setProperty(key, keyValue);
            properties.store(out, "Set value to properties file success.");
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
