package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Выведите на экран все строки файла в обратном порядке.
 */
public class Counter4ReverseLines {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        oldCounter4ReverseLines();//0.09
        newCounter4ReverseLines();//0.30
    }
    static void oldCounter4ReverseLines () throws IOException {
        long t1 = System.nanoTime();

        String file = FileLoader.loadFile();
        String[] lineArray = StringSplitter.getLinesOld( file );

        for ( int i = lineArray.length - 1; i >= 0; i-- ) {
            System.out.println( lineArray[ i ] );
        }

        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
    }
    static void newCounter4ReverseLines () throws IOException {
        long t1 = System.nanoTime();

        String file = FileLoader.loadFile();
        Stream<String> stream = StringSplitter.getLines( file );
        stream.sorted((o1, o2) -> -1).forEach(x -> System.out.println(x));

        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
    }
}
