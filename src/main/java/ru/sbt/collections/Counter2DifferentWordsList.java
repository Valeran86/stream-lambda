package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Выведите на экран список различных слов файла,
 * отсортированный по возрастанию их длины.
 */
public class Counter2DifferentWordsList {


    public static void main( String[] args ) throws IOException, URISyntaxException {
        oldCounter();
        newCounter();



    }

    public static void oldCounter() throws IOException {
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

        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );

    }

    public static void newCounter() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWords( file );
         Arrays.sort(words, (firstStr, secondStr) -> Integer.compare(firstStr.length(), secondStr.length()));
         Arrays.stream( words ).distinct().forEach( e -> System.out.println( e ) );

        System.out.println( Arrays.stream( words ).distinct()) ;

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





}
