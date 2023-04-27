package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        var wordAsArray = word.toCharArray();
        List<String> symbolsOfWord1 = Arrays.asList(wordAsArray);
        List<String> symbolsOfWord = new ArrayList(symbolsOfWord1);

        var symbolsAsArray = symbols.toCharArray();
        List<String> letters1 = Arrays.asList(symbolsAsArray);
        List<String> letters = new ArrayList(letters1);

        for (char symbol : symbolsOfWord) {
            for (char letter : letters) {
                if (symbol.equalsIgnoreCase(letter)) {
                    symbolsOfWord.remove(symbol);
                    letters.remove(letter);
                }
            }
        }
        return symbolsOfWord.isEmpty();
    }
}
//END
