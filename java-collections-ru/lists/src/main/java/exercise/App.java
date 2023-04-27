package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        var wordAsArray = word.toCharArray();
        List<Char> symbolsOfWord = Arrays.asList(wordAsArray);

        var symbolsAsArray = symbols.toCharArray();
        List<char> letters = Arrays.asList(symbolsAsArray);

        for (char symbol : symbolsOfWord) {
            for (char letter : letters) {
                if (symbol.equals(letter)) {
                    symbolsOfWord.remove(symbol);
                    letters.remove(letter);
                }
            }
        }
        return symbolsOfWord.isEmpty();
    }
}
//END
