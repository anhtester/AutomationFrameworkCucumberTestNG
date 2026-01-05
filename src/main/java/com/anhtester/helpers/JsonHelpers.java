package com.anhtester.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.anhtester.utils.LogUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonHelpers {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Reads a JSON file and maps it to a specified class.
     *
     * @param jsonFilePath the path to the JSON file.
     * @param clazz        the class to map the JSON to.
     * @param <T>          the type of the class.
     * @return an object of the specified class, or null if an error occurs.
     */
    public static <T> T readJsonFile(String jsonFilePath, Class<T> clazz) {
        try {
            return objectMapper.readValue(new File(jsonFilePath), clazz);
        } catch (IOException e) {
            LogUtils.error("Failed to read JSON file: " + e.getMessage());
            return null;
        }
    }

    /**
     * Reads a JSON file and maps it to a list of objects.
     *
     * @param jsonFilePath the path to the JSON file.
     * @param typeReference the type reference for the list of objects.
     * @param <T>          the type of the objects in the list.
     * @return a list of objects, or null if an error occurs.
     */
    public static <T> List<T> readJsonFileToList(String jsonFilePath, TypeReference<List<T>> typeReference) {
        try {
            return objectMapper.readValue(new File(jsonFilePath), typeReference);
        } catch (IOException e) {
            LogUtils.error("Failed to read JSON file: " + e.getMessage());
            return null;
        }
    }

    /**
     * Reads a JSON file and maps it to a map of objects.
     *
     * @param jsonFilePath the path to the JSON file.
     * @param typeReference the type reference for the map of objects.
     * @param <K>          the type of the keys in the map.
     * @param <V>          the type of the values in the map.
     * @return a map of objects, or null if an error occurs.
     */
    public static <K, V> Map<K, V> readJsonFileToMap(String jsonFilePath, TypeReference<Map<K, V>> typeReference) {
        try {
            return objectMapper.readValue(new File(jsonFilePath), typeReference);
        } catch (IOException e) {
            LogUtils.error("Failed to read JSON file: " + e.getMessage());
            return null;
        }
    }

    /**
     * Writes an object to a JSON file.
     *
     * @param jsonFilePath the path to the JSON file.
     * @param object       the object to write.
     */
    public static void writeJsonFile(String jsonFilePath, Object object) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), object);
        } catch (IOException e) {
            LogUtils.error("Failed to write JSON file: " + e.getMessage());
        }
    }

    /**
     * Gets a specific node from a JSON file.
     *
     * @param jsonFilePath the path to the JSON file.
     * @param nodeName     the name of the node to get.
     * @return the JsonNode, or null if an error occurs.
     */
    public static JsonNode getJsonNode(String jsonFilePath, String nodeName) {
        try {
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));
            return rootNode.path(nodeName);
        } catch (IOException e) {
            LogUtils.error("Failed to get JSON node: " + e.getMessage());
            return null;
        }
    }
}
