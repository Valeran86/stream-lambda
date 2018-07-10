package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Реализуйте свой Iterator для обхода списка слов в обратном порядке.
 */
public class Counter5ReverseIterator {

    public static void main( String[] args ) throws IOException, URISyntaxException {
        oldCounter5ReverseIterator();//0.08
        newCounter5ReverseIterator();//0.26
    }
    static void oldCounter5ReverseIterator () throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        List<String> words = Arrays.asList( StringSplitter.getWordsOld( file ) );

        Iterator<String> reverseArrayIterator = new ReverseIterator( words );

        while ( reverseArrayIterator.hasNext() )
            System.out.println( reverseArrayIterator.next() );
        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
    }
    static void newCounter5ReverseIterator () throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        List<String> words = Arrays.asList( StringSplitter.getWordsOld( file ) );

        Spliterator<String> stringSpliterator = new ReverseSpliterator(words);
        stringSpliterator.forEachRemaining(x -> System.out.println(x));

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
    static class ReverseSpliterator implements Spliterator<String> {
        private int index;
        private final List<String> array;

        public ReverseSpliterator(List<String> array) {
            this.array = array;
            index = array.size();
        }

        @Override

        public boolean tryAdvance(Consumer<? super String> action) {
            --index;
            if ( index >= 0 && index < array.size() ) {
                action.accept(array.get(index));
                return true;
            }
            return false;
        }

        @Override
        public long estimateSize() {
            return index;
        }

        @Override
        public int characteristics() {
            return 0;
        }

        @Override
        public Spliterator<String> trySplit() {
            return null;
        }
    }
}
