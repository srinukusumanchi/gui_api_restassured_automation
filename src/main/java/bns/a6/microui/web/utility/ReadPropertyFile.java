/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-07
 * Created Time: 7:18 a.m.
 */

package bns.a6.microui.web.utility;

import org.assertj.core.api.Assertions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

    private static ReadPropertyFile INSTANCE = null;


    private ReadPropertyFile() {

    }

    private Properties getPropertiesObject(String filePath,String fileName){
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(
                    filePath + fileName);
            properties.load(fileInputStream);
        } catch (IOException e) {
            Assertions.fail("Unable to load Properties file "
                    + "File Path:- " + filePath +
                    fileName);
        }
        return properties;
    }


    public static synchronized ReadPropertyFile getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new ReadPropertyFile();
        }
        return INSTANCE;
    }


    public String getPropertyValue(String filePath,
                                   String fileName,
                                   String key) throws Exception {
        String value = getPropertiesObject(filePath,fileName).getProperty(key);
        if (Objects.isNull(value) || Objects.isNull(key)) {
            throw new Exception("Property name " + key + " is not found, Please check application.properties file");
        }
        return value;
    }
}
