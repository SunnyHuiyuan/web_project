package com.atguigu.fileupload.app.utils;

import java.util.HashMap;
import java.util.Map;

public class FileUploadAppProperties {

    private Map<String, String> properties = new HashMap<>();

    private FileUploadAppProperties() {
    }

    private static FileUploadAppProperties instance = new FileUploadAppProperties();

    public static FileUploadAppProperties getInstance() {
        return instance;
    }

    public void addProperties(String propertiesName, String propertiesValue) {
        properties.put(propertiesName, propertiesValue);
    }

    public String getProperties(String propertiesName) {
        return properties.get(propertiesName);
    }
}
