package exercise;

import java.util.*;

// BEGIN
class App {
    public static LinkedHashMap<String, Object> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();

        for (Map.Entry<String, Object> element1 : data1.entrySet()) {
            if (!data2.containsKey(element1.getKey())) {
                result.put(element1.getKey(), "deleted");
            }
        }

        for (Map.Entry<String, Object> element2 : data2.entrySet()) {
            if (!data1.containsKey(element2.getKey())) {
                result.put(element2.getKey(), "added");
            }
        }

        for (Map.Entry<String, Object> element1 : data1.entrySet()) {
            for (Map.Entry<String, Object> element2 : data2.entrySet()) {
                if (element1.getKey() == element2.getKey() && element1.getValue() == element2.getValue()) {
                    result.put(element1.getKey(), "unchanged");
                } else if (element1.getKey() == element2.getKey() && element1.getValue() != element2.getValue()) {
                    result.put(element1.getKey(), "changed");
                }
            }
        }

        if (data1.isEmpty()) {
            for (Map.Entry<String, Object> element2 : data2.entrySet()) {
                result.put(element2.getKey(), "added");
            }
        } else if (data2.isEmpty()) {
            for (Map.Entry<String, Object> element1 : data1.entrySet()) {
                result.put(element1.getKey(), "deleted");
            }
        }

        Set<Map.Entry<String, Object>> sorting = new TreeSet<>();
        result.entrySet().stream()
                .map(element -> sorting.add(element))
                .close();
        sorting.stream()
                .map(element -> result.entrySet().add(element))
                .close();

        return result;
    }
}

//added = если в первом массиве отсутствовал, но был добавлен во второй
//deleted = если был в первом, но был удален во втором


/*      added.addAll(words1.entrySet());
        added.removeAll(words2.entrySet());

        added.stream()
        .forEach(System.out::println);

        Set<Map.Entry<String, Object>> deleted = new TreeSet<>();
        deleted.addAll(words2.entrySet());
        deleted.removeAll(words1.entrySet());

        deleted.stream()
        .forEach(System.out::println);

        Set<Map.Entry<String, Object>> changed = new TreeSet<>();

        return result;


        Set<Map.Entry<String, Object>> deleted = new TreeSet<>();
        data2.entrySet().stream()
                .map(element -> deleted.add(element))
                .close();
        data1.entrySet().stream()
                .map(element -> deleted.remove(element))
                .close();
        deleted.stream()
                .map(element -> result.put(element.getKey(), element.setValue("deleted")))
                .close();

                data1.containsKey(element2.getKey()) ?  : result.put(element1.getKey(), "deleted");*/