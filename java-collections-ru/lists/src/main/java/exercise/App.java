package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        var wordAsArray = word.toCharArray();
        List<Character> symbolsOfWord1 = Arrays.asList(wordAsArray);
        List<Character> symbolsOfWord = new ArrayList(symbolsOfWord1);

        var symbolsAsArray = symbols.toCharArray();
        List<Character> letters1 = Arrays.asList(symbolsAsArray);
        List<Character> letters = new ArrayList(letters1);

        for (Character symbol : symbolsOfWord) {
            for (Character letter : letters) {
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
