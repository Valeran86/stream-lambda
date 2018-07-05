package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

/**
 * Выведите на экран список различных слов файла,
 * отсортированный по возрастанию их длины.
 */
class Counter2DifferentWordsList {


    static long notStream() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWords( file );

        LenghtComparator lenghtComparator = new LenghtComparator();
        Set<String> sortedSet = new TreeSet<>( lenghtComparator );
        sortedSet.addAll( Arrays.asList( words ) );

        sortedSet.iterator().forEachRemaining(
                i -> System.out.println( "[" + i + "]" )
        );

        System.out.println( "" + sortedSet.size() + '/' + words.length );

        return System.nanoTime() - t1;
    }

    static class LenghtComparator implements Comparator<String> {

        @Override
        public int compare( String o1, String o2 ) {
            int n1 = o1.length();
            int n2 = o2.length();
            if ( n1 == n2 )
                return n1 - n2;

            int min = Math.min( n1, n2 );
            for ( int i = 0; i < min; i++ )
                if ( o1.charAt( i ) != o2.charAt( i ) )
                    return o1.charAt( i ) - o2.charAt( i );

            return 0;
        }
    }

    static long yesStream() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWords( file );

        Stream.of(words).distinct()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);

        return System.nanoTime() - t1;
    }
}
