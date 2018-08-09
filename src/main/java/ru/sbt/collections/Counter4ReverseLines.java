package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.SimpleStopwatch;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Выведите на экран все строки файла в обратном порядке.
 */
public class Counter4ReverseLines {
    public static void main(String[] args) throws IOException, URISyntaxException {
        SimpleStopwatch.showDuration(Counter4ReverseLines::process, "Task four: ");
        SimpleStopwatch.showDuration(Counter4ReverseLines::processStream, "Task four stream: ");
    }

    public static void process() {
        try {
            String file = FileLoader.loadFile();
            String[] lineArray = StringSplitter.getLines(file);

            for (int i = lineArray.length - 1; i >= 0; i--) {
                System.out.println(lineArray[i]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void processStream() {
        FileLoader.getStream().flatMap(line -> Arrays.stream(line.split("[;" + System.lineSeparator() + " .,]")))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator().forEachRemaining(System.out::println);
    }
}
