package ru.sbt.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Подсчитайте количество различных слов в файле.
 */
public class Counter1DifferentWords {

    static long notStream(String[] words){
        long t1 = System.nanoTime();
        Set<String> set = new HashSet<>( Arrays.asList( words ) );

        System.out.println( "" + set.size() + '/' + words.length );
        return System.nanoTime() - t1;
    }

    static long yesStream(String[] words) {
        long t1 = System.nanoTime();

        System.out.println( "" + Stream.of(words).distinct().count() + '/' + words.length );
        return System.nanoTime() - t1;
    }
}
