package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.SimpleStopwatch;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализуйте свой Iterator для обхода списка слов в обратном порядке.
 */
public class Counter5ReverseIterator {

    public static void main(String[] args) throws IOException, URISyntaxException {
        SimpleStopwatch.showDuration(Counter4ReverseLines::process, "Task five: ");
        SimpleStopwatch.showDuration(Counter4ReverseLines::processStream, "Task five stream: ");
    }

    public static void process() {
        try {
            String file = FileLoader.loadFile();
            List<String> words = Arrays.asList(StringSplitter.getWords(file));

            Iterator<String> reverseArrayIterator = new ReverseIterator(words);

            while (reverseArrayIterator.hasNext())
                System.out.println(reverseArrayIterator.next());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void processStream() {
        new ReverseIterator(FileLoader.getStream()
                .flatMap(line -> Arrays.stream(line.split("[;" + System.lineSeparator() + " .,]")))
                .collect(Collectors.toList())).forEachRemaining(System.out::println);
    }

    static class ReverseIterator implements Iterator<String> {
        private int index;
        private final List<String> array;

        public ReverseIterator(List<String> array) {
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
            if (index >= 0 && index < array.size())
                return array.get(index);

            return null;
        }
    }
}
