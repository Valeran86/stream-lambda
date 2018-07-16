package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Выведите на экран список различных слов файла,
 * отсортированный по возрастанию их длины.
 */
public class Counter2DifferentWordsList {
    private static String[] words;

    static {
        try {
            words = StringSplitter.getWords( FileLoader.loadFile() );
        } catch ( IOException e ) {
            e.printStackTrace( System.out );
        }
    }

    public static Result getResultOld( ) {
        Result res = Result.of( "Counter2DifferentWordsList old", System.nanoTime() );

        LenghtComparator lenghtComparator = new LenghtComparator();
        Set<String> sortedSet = new TreeSet<>( lenghtComparator );
        sortedSet.addAll( Arrays.asList( words ) );
        res.setFinish( System.nanoTime() );
        res.setResult( sortedSet );
        res.setResultSummary( "" + sortedSet.size() + '/' + words.length );

        return res;
    }

    static class LenghtComparator implements Comparator<String> {

        @Override
        public int compare( String o1, String o2 ) {
            int n1 = o1.length();
            int n2 = o2.length();
            if ( n1 != n2 )
                return n1 - n2;

            int min = Math.min( n1, n2 );
            for ( int i = 0; i < min; i++ )
                if ( o1.charAt( i ) != o2.charAt( i ) )
                    return o1.charAt( i ) - o2.charAt( i );

            return 0;
        }
    }


    public static Result getResultNew( ) {
        Result res = Result.of( "Counter2DifferentWordsList new", System.nanoTime() );

        LenghtComparator lenghtComparator = new LenghtComparator();
        List<String> sortedSet = Arrays
                .stream( words )
                .distinct()
                .sorted( lenghtComparator )
                .collect( Collectors.toList() );

        res.setFinish( System.nanoTime() );
        res.setResult( sortedSet );
        res.setResultSummary( "" + sortedSet.size() + '/' + words.length );

        return res;
    }


}
