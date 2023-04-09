package com.eurotech.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {
        try {
            //what file to read
            String path ="configuration.properties";

            //read the file into java, finds the file using the string path
            FileInputStream input = new FileInputStream(path);  // Path okumayi saglayan class :  FileInputStream
            // properties ---> class that store properties in key / value format
            properties = new Properties();  // Properties class dan object olusturuyoruz.
            // the values  from the file input is loaded / fed in to the properties object
            properties.load(input); // olusan object e kendi configuration.properties dosyamizi gönderiyoruz.
            input.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // how can we call the configurationReader
    public static String get(String keyName) {
        return  properties.getProperty(keyName); // Properties class key-value seklinde oldugu icin,
                                            // biz key girdigimizde, bize value yu döndürür.
    }
}
