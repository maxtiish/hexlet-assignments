package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map getWordCount(String sentence) {
        Map<String, Integer> words = new HashMap<>();
        String[] sentenceAsArray = sentence.split(" ");

            for (var i = 0; i < sentenceAsArray.length; i++) {
                for (Map.Entry<String, Integer> word: words.entrySet()) {
                    if (!words.containsKey(sentenceAsArray[i])) {
                        words.put(sentenceAsArray[i], 1);
                    } else {
                        words.put(sentenceAsArray[i], word.getValue() + 1);
                }
            }
        }
            return words;
    }

    public static String toString(Map words) {
        Map<String, Integer> newWords = new HashMap<>();
        var result = new StringBuilder();
        result.append("{\n");
        for (Map.Entry<String, Integer> word: newWords.entrySet()) {
            result.append("  " + word.getKey() + ": " + word.getValue() + "\n");
        }
        result.append('}');
        return result.toString();
    }
}
//END
