package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.SimpleStopwatch;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 */
public class Counter3DifferentWordsCount {

    public static void main(String[] args) {
        SimpleStopwatch.showDuration(Counter3DifferentWordsCount::process, "Task three: ");
        SimpleStopwatch.showDuration(Counter3DifferentWordsCount::processStream, "Task three stream: ");
    }

    public static void process() {
        try {
            String file = FileLoader.loadFile();
            String[] words = StringSplitter.getWords(file);
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                int value = 1;
                if (map.containsKey(word))
                    value += map.get(word);

                map.put(word, Integer.valueOf(value));
            }

            System.out.println(map);
            System.out.println("" + map.size() + '/' + words.length);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void processStream() {
        FileLoader.getStream()
                .flatMap(line -> Arrays.stream(line.split("[;" + System.lineSeparator() + " .,]")))
                .collect(Collectors.toMap(s -> s, s -> 1, (old, fresh) -> old + fresh)).entrySet()
                .iterator().forEachRemaining(entry -> System.out.print(entry.getKey() + ": " + entry.getValue() + "   "));
    }
}
