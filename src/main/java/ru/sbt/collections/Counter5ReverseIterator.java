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
 * Реализуйте свой Iterator для обхода списка слов в обратном порядке.
 */
public class Counter5ReverseIterator {

    public static void main( String[] args ) throws IOException, URISyntaxException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        List<String> words = Arrays.asList( StringSplitter.getWords( file ) );

        Iterator<String> reverseArrayIterator = new ReverseIterator( words );

        while ( reverseArrayIterator.hasNext() )
            System.out.println( reverseArrayIterator.next() );
        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
        stream();
    }

    public static void stream() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        List<String> words = Arrays.asList( StringSplitter.getWords( file ) );

        Iterator<String> reverseArrayIterator = new ReverseIterator( words );
        reverseArrayIterator.forEachRemaining( System.out::println );

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
