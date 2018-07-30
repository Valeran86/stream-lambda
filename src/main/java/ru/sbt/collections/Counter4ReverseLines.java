package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Выведите на экран все строки файла в обратном порядке.
 */
public class Counter4ReverseLines {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] lineArray = StringSplitter.getLines( file );

        for ( int i = lineArray.length - 1; i >= 0; i-- ) {
            System.out.println( lineArray[ i ] );
        }
        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
        stream();
    }

    public static void stream() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        Stream<String> stream = Arrays.stream( StringSplitter.getLines( file ) );
        stream.collect(Collectors.toCollection(ArrayDeque::new))
                .descendingIterator()
                .forEachRemaining(System.out::println);
        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
    }
}
