package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        List<Character> symbolsOfWord = new ArrayList<>();
        List<Character> letters = new ArrayList<>();

        var symbolsLowerCase = symbols.toLowerCase();
        var wordLowerCase = word.toLowerCase();

        for(var i = 0; i < symbols.length(); i++) {
            var letter = symbolsLowerCase.charAt(i);
            letters.add(letter);
        }
        for (var i = 0; i < word.length(); i++) {
            var symbol = wordLowerCase.charAt(i);
            symbolsOfWord.add(symbol);
        }

        for (Character symbol : symbolsOfWord) {
            for (Character letter : letters) {
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
