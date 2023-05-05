package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> book) {
        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> oneBook : books) {
           for (Map.Entry<String, String> information : book.entrySet()) {
               for (Map.Entry<String, String> thisBook : oneBook.entrySet()) {
                   if (!information.getValue().equals(thisBook.getValue())) {
                       break;
                   } else {
                       result.add(oneBook);
                   }
               }
            }
        }
        return result;
    }
}
//END
