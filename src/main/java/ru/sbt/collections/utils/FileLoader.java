package ru.sbt.collections.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/** Util class for loading files
 * Created by Home on 02.07.2018.
 */
public class FileLoader {
    public static String loadFile() throws IOException {
        InputStream resourceAsStream = FileLoader.class.getResourceAsStream( "/ru/sbt/collections/VeryBigText.txt" );
    //    InputStream resourceAsStream = FileLoader.class.getResourceAsStream( "/ru/sbt/collections/NotBigText.txt" );
        return IOUtils.toString( resourceAsStream, "UTF8" );
    }
}
