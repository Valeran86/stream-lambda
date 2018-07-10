package ru.sbt.collections;


import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Подсчитайте количество различных слов в файле.
 */
public class Counter1DifferentWords {

    public static void main( String[] args ) throws IOException, URISyntaxException {
        oldCounter1DifferentWords(); //0.05
        newCounter1DifferentWords(); //0.19
    }
    static void oldCounter1DifferentWords () throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWordsOld( file );
        Set<String> set = new HashSet<>( Arrays.asList( words ) );

        System.out.println( "" + set.size() + '/' + words.length );
        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
    }
    static void newCounter1DifferentWords () throws IOException {
        long t1 = System.nanoTime();

        String file = FileLoader.loadFile();
        Stream<String> stream = StringSplitter.getWords( file );
        long count = stream.distinct().count();

        //System.out.println( "" + count + '/' + stream.count() );
        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
    }
}
