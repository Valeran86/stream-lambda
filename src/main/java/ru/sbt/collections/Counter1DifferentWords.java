package ru.sbt.collections;


import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Подсчитайте количество различных слов в файле.
 */
public class Counter1DifferentWords {

    static long notStream() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWords( file );
        Set<String> set = new HashSet<>( Arrays.asList( words ) );

        System.out.println( "" + set.size() + '/' + words.length );
        return System.nanoTime() - t1;
    }

    static long yesStream() throws IOException {
        long t1 = System.nanoTime();

        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWords( file );

        System.out.println( "" + Stream.of(words).distinct().count() + '/' + words.length );
        return System.nanoTime() - t1;
    }
}
