package ru.sbt.collections;


import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.SimpleStopwatch;
import ru.sbt.collections.utils.StringSplitter;

import javax.script.ScriptException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Подсчитайте количество различных слов в файле.
 */
public class Counter1DifferentWords {
    public static void main(String[] args) throws IOException, URISyntaxException, Exception {
        Set<String> usual = SimpleStopwatch.showDuration(Counter1DifferentWords::process, "Task one: ");
        Set<String> streamed = SimpleStopwatch.showDuration(Counter1DifferentWords::processStream,"Task one stream: ");
    }

    public static Set<String> process() throws IOException {
        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWords(file);
        Set<String> set = new HashSet<>(Arrays.asList(words));
        return set;
    }

    public static Set<String> processStream() {
        return FileLoader.getStream()
                .flatMap(line -> Arrays.stream(line.split("[;" + System.lineSeparator() + " .,]")))
                .collect(Collectors.toSet());
    }
}
