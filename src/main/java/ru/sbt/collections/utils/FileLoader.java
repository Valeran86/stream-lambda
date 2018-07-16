package ru.sbt.collections.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Util class for loading files
 * Created by Home on 02.07.2018.
 */
public class FileLoader {
    public static String loadFile() throws IOException {
        InputStream resourceAsStream = FileLoader.class.getResourceAsStream( "/ru/sbt/collections/VeryBigText.txt" );
        return IOUtils.toString( resourceAsStream, "UTF8" );
    }

    public static Stream< String > loadFileStream() throws IOException {
        return Files.lines( Paths.get( "src/main/resources/ru/sbt/collections/VeryBigText.txt" ) );
    }
}
