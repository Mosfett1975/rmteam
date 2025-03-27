package ru.rmteam.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import static com.codeborne.selenide.Selenide.sessionId;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;


@Log4j2
public class UserProperties {
    static String PATHTOPROPERTIES = "src/test/resources/userData.properties";
    public static Map<String, Object> variableApi = new HashMap<>();


    /**
     * Выполняется проверка наличия входного параметра в Properties
     *
     * @param value
     * @return
     */
    public static String checkValueAndReturnString(String value) {
        String prop = getProperty(value);
        if (prop == null) {
            return value;
        }
        return prop;
    }


    @SneakyThrows(IOException.class)
    public static Properties loadProperties() {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(PATHTOPROPERTIES)));
        return properties;
    }

    public static String getProperty(String propertyName) {
        if(loadProperties().getProperty(propertyName)==null){
            return propertyName;
        }
        return loadProperties().getProperty(propertyName);
    }


    public static void setVarObj(String name, Object value) {
        variableApi.put(name,value);
    }

    @NotNull
    public static Field[] getFields() {
        Class < ? > clazz = ( Class < ? > ) getVarResp ( "currentPage" + sessionId () );
        Field[] fields = ( clazz ).getDeclaredFields ( );
        return fields;
    }

    public static Object getVarResp(String name) {
        Object obj = variableApi.get(name);
        if (obj==null){ throw new IllegalArgumentException("Variable \"" + name + "\" not found");}
        return obj;
    }


}
