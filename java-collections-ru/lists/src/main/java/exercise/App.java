package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        var symbolsLowerCase = symbols.toLowerCase();
        var wordLowerCase = word.toLowerCase();

        char[] charsOfSymbols = symbolsLowerCase.toCharArray();
        char[] charsOfWord = wordLowerCase.toCharArray();

        List<Character> letters = new ArrayList<>();
        List<Character> symbolsOfWord = new ArrayList<>();

        for (char symbol : charsOfSymbols) {
            letters.add(symbol);
        }

        for (char symbol : charsOfWord) {
            symbolsOfWord.add(symbol);
        }

        for (var i = 0; i < symbolsOfWord.size(); i++) {
            var currentSymbol = symbolsOfWord.get(i);
            if (letters.contains(currentSymbol)) {
                symbolsOfWord.remove(i);
                letters.remove(currentSymbol);
            }
        }
        return symbolsOfWord.isEmpty();
    }
}
//END
