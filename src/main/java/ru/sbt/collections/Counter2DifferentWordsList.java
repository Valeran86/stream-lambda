package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.SimpleStopwatch;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Выведите на экран список различных слов файла,
 * отсортированный по возрастанию их длины.
 */
public class Counter2DifferentWordsList {


    public static void main(String[] args) {
        try {
            SimpleStopwatch.showDuration(Counter2DifferentWordsList::process, "Task two: ");
            SimpleStopwatch.showDuration(Counter2DifferentWordsList::processStream, "Task two stream: ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void process() {
        try {
            String file = FileLoader.loadFile();
            String[] words = StringSplitter.getWords(file);

            LenghtComparator lenghtComparator = new LenghtComparator();
            Set<String> sortedSet = new TreeSet<>(lenghtComparator);
            sortedSet.addAll(Arrays.asList(words));

            sortedSet.iterator().forEachRemaining(
                    i -> System.out.println("[" + i + "]")
            );

            System.out.println("" + sortedSet.size() + '/' + words.length);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void processStream() {
        FileLoader.getStream()
                .flatMap(line -> Arrays.stream(line.split("[;" + System.lineSeparator() + " .,]")))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new LenghtComparator())))
                .iterator().forEachRemaining(word -> System.out.println("[" + word + "]"));
    }


    static class LenghtComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int n1 = o1.length();
            int n2 = o2.length();
            if (n1 == n2)
                return n1 - n2;

            int min = Math.min(n1, n2);
            for (int i = 0; i < min; i++)
                if (o1.charAt(i) != o2.charAt(i))
                    return o1.charAt(i) - o2.charAt(i);

            return 0;
        }
    }
}
