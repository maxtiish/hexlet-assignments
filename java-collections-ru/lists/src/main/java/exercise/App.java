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


        for (var num = 0; num < letters.size(); num++) {
            var currentLettersSymbol = letters.get(num);

            for (var i = 0; i < symbolsOfWord.size(); i++) {
                var currentSymbol = symbolsOfWord.get(i);

                if (currentLettersSymbol.equals(currentSymbol)) {
                    letters.remove(num);
                    symbolsOfWord.remove(i);
                }
            }
        }

        return symbolsOfWord.isEmpty();
    }
}
//END
