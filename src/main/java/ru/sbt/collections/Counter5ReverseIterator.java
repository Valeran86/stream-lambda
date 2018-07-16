package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Реализуйте свой Iterator для обхода списка слов в обратном порядке.
 */
public class Counter5ReverseIterator {
    private static List<String> words;

    static {
        try {
            words = new ArrayList<>( Arrays.asList( StringSplitter.getWords( FileLoader.loadFile() ) ) );
        } catch ( IOException e ) {
            e.printStackTrace( System.out );
        }
    }

    public static Result getResultOld( ) {
        Result res = Result.of( "Counter5ReverseIterator old", System.nanoTime() );

        Iterator<String> reverseArrayIterator = new ReverseIterator( words );
        ArrayList<String> reverseArray = new ArrayList<>( words.size() );
        while ( reverseArrayIterator.hasNext() )
            reverseArray.add( reverseArrayIterator.next() );

        res.setFinish( System.nanoTime() );
        res.setResultSummary( "" + reverseArray.size() + '/' + words.size() );
        res.setResult(  reverseArray);
        return res;
    }

    static class ReverseIterator implements Iterator<String> {
        private int index;
        private final List<String> array;

        private ReverseIterator( List<String> array ) {
            this.array = array;
            index = array.size();
        }

        @Override
        public boolean hasNext( ) {
            return index > 0;
        }

        @Override
        public String next( ) {
            --index;
            if ( index >= 0 && index < array.size() )
                return array.get( index );

            return null;
        }
    }

    public static Result getResultNew( ) {
        Result res = Result.of( "Counter5ReverseIterator new", System.nanoTime() );

        Iterator<String> reverseArrayIterator = new ReverseIterator( words );
        ArrayList<String> reverseArray = new ArrayList<>( words.size() );
        reverseArrayIterator.forEachRemaining( reverseArray::add );

        res.setFinish( System.nanoTime() );
        res.setResultSummary( "" + reverseArray.size() + '/' + words.size() );
        res.setResult(  reverseArray);
        return res;
    }
}
