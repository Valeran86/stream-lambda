package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Реализуйте свой Iterator для обхода списка слов в обратном порядке.
 */
public class Counter5ReverseIterator {

    public static void main( String[] args ) throws IOException, URISyntaxException {
        oldCounter();
        newCounter();


    }

    public static void oldCounter() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        List<String> words = Arrays.asList( StringSplitter.getWords( file ) );

        Iterator<String> reverseArrayIterator = new ReverseIterator( words );

        while ( reverseArrayIterator.hasNext() )
            System.out.println( reverseArrayIterator.next() );
        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
    }

    public static void newCounter() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWords( file );
        Stream<String> wordsStream = Arrays.stream( words );

        String strWords = wordsStream.reduce( " ", (acc, n) -> n + "\n" + acc);
        System.out.println( strWords );
        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
    }

    static class ReverseIterator implements Iterator<String> {
        private int index;
        private final List<String> array;

        public ReverseIterator( List<String> array ) {
            this.array = array;
            index = array.size();
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public String next() {
            --index;
            if ( index >= 0 && index < array.size() )
                return array.get( index );

            return null;
        }
    }

}
