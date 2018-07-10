package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Stream;

/**
 * Выведите на экран список различных слов файла,
 * отсортированный по возрастанию их длины.
 */
public class Counter2DifferentWordsList {


    public static void main( String[] args ) throws IOException, URISyntaxException {
        oldCounter2DifferentWordsList(); //0.36
        newCounter2DifferentWordsList(); //0.07
    }

    static void oldCounter2DifferentWordsList () throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWordsOld( file );

        LenghtComparator lenghtComparator = new LenghtComparator();
        Set<String> sortedSet = new TreeSet<>( lenghtComparator );
        sortedSet.addAll( Arrays.asList( words ) );

        sortedSet.iterator().forEachRemaining(
                i -> System.out.println( "[" + i + "]" )
        );

        System.out.println( "" + sortedSet.size() + '/' + words.length );

        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
    }
    static void newCounter2DifferentWordsList () throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        Stream<String> stream = StringSplitter.getWords( file ).distinct();

        stream.sorted(new AlphabeticalOrderComparator()).forEach(x-> System.out.println(x));

        //System.out.println( "" + sortedSet.size() + '/' + words.length );

        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
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
    static class AlphabeticalOrderComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        }
    }
}
