package LR6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void topWords(String filePath) {
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Integer> dict = new HashMap<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] words = line.split(" +");
            for (String word : words) {
                if (dict.containsKey(word)) {
                    dict.put(word, dict.get(word) + 1);
                } else {
                    dict.put(word, 1);
                }
            }
        }
        scanner.close();
        List list = new ArrayList<>(dict.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String,
                    Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i)); 
        }
    }
}
