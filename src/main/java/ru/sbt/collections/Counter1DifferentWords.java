package ru.sbt.collections;


import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Подсчитайте количество различных слов в файле.
 */
public class Counter1DifferentWords {

    public static void main( String[] args ) throws IOException, URISyntaxException {
        oldCounter();
        newCounter();
    }

    public static void newCounter() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWords( file );
        System.out.println( Arrays.stream(words).distinct().count() + " / " + words.length);

        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
        //strimForArrays.flatMap( strimForArrays.distinct(), strimForArrays.count() )
    }

    public static void oldCounter() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWords( file );
        Set<String> set = new HashSet<>( Arrays.asList( words ) );

        System.out.println( "" + set.size() + '/' + words.length );
        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
    }
}
