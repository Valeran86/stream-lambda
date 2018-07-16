package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Выведите на экран все строки файла в обратном порядке.
 */
public class Counter4ReverseLines {
    private static String[] lineArray;
    private static Stream<String> lineStream;

    static {
        try {
            lineArray = StringSplitter.getLines( FileLoader.loadFile() );
            lineStream = FileLoader.loadFileStream();
        } catch ( IOException e ) {
            e.printStackTrace( System.out );
        }
    }

    public static Result getResultOld( ) {
        Result res = Result.of( "Counter4ReverseLines old", System.nanoTime() );

        ArrayList<String> reverseArray = new ArrayList<>( lineArray.length );
        for ( int i = lineArray.length - 1; i >= 0; i-- ) {
            reverseArray.add( lineArray[i] );
        }
        res.setFinish( System.nanoTime() );
        res.setResultSummary( "" + reverseArray.size() + '/' + lineArray.length );
        res.setResult(  reverseArray);
        return res;
    }

    public static Result getResultNew( ) {
        Result res = Result.of( "Counter4ReverseLines new", System.nanoTime() );

        ArrayList<String> reverseArray = new ArrayList<>( lineArray.length );
        lineStream.collect( Collectors.toCollection( LinkedList::new ) )
                .descendingIterator()
                .forEachRemaining( reverseArray::add );

        res.setFinish( System.nanoTime() );
        res.setResultSummary( "" + reverseArray.size() + '/' + lineArray.length );
                res.setResult(  reverseArray);
        return res;
    }
}
