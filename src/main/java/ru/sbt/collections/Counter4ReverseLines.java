package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Выведите на экран все строки файла в обратном порядке.
 */
public class Counter4ReverseLines {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        String file = FileLoader.loadFile();
        String[] lineArray = StringSplitter.getLines( file );

        for ( int i = lineArray.length - 1; i >= 0; i-- ) {
            System.out.println( lineArray[ i ] );
        }
    }
}
