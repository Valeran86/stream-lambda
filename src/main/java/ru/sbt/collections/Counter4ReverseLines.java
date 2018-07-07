package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Выведите на экран все строки файла в обратном порядке.
 */
public class Counter4ReverseLines {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        oldCounter();
        newCounter();
    }

    public static void oldCounter() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] lineArray = StringSplitter.getLines( file );

        for ( int i = lineArray.length - 1; i >= 0; i-- ) {
            System.out.println( lineArray[ i ] );
        }
        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );

    }

    public static void newCounter() throws IOException {
        long t1 = System.nanoTime();
        String regex= "[;\" + System.lineSeparator() + \" .,]";

        File file = new File("src/main/resources/ru/sbt/collections/VeryBigText.txt");

        Files.lines( Paths.get( file.getAbsolutePath() ) )
                .flatMap( s -> Stream.of( s.split( regex) ))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(System.out::println);
        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
    }



}
