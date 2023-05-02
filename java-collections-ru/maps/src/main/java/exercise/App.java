package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map getWordCount(String sentence) {
        Map<String, Integer> words = new HashMap<>();

        if (sentence.length() < 1) {
            return words;
        }
        String[] sentenceAsArray = sentence.split(" ");

        for (var i = 0; i < sentenceAsArray.length; i++) {
            if (!words.containsKey(sentenceAsArray[i])) {
                words.put(sentenceAsArray[i], 0);
            }
        }
        for (Map.Entry<String, Integer> word: words.entrySet()) {
            for (var i = 0; i < sentenceAsArray.length; i++) {
                if (word.getKey().equals(sentenceAsArray[i])) {
                    words.put(word.getKey(), word.getValue() + 1);
                }
            }
        }
        return words;
    }

    public static String toString(Map words) {
        Map<String, Integer> newWords = new HashMap<>(words);
        var result = new StringBuilder();
        result.append("{");
        for (Map.Entry<String, Integer> word: newWords.entrySet()) {
            result.append("\n  " + word.getKey() + ": " + word.getValue());
        }
        result.append('}');
        return result.toString();
    }
}
//END
