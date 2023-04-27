package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        var wordAsArray = word.toCharArray();
        List<reference> symbolsOfWord = Arrays.asList(wordAsArray);

        var symbolsAsArray = symbols.toCharArray();
        List<reference> letters = Arrays.asList(symbolsAsArray);

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
