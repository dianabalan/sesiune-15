package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


        List<String> words = new LinkedList<>();
        words.add("listen");
        words.add("silent");
        words.add("elbows");
        words.add("below");
        words.add("stone");
        words.add("tones");

        findAnagrams(words);

    }

    private static Map<String, List<String>> findAnagrams(List<String> words) {

        Map<String, List<String>> anagrams = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();

            Arrays.sort(chars);

            String sortedWord = new String(chars);

            System.out.println("For word: " + word + ", sorted is: " + sortedWord);

            if (!anagrams.containsKey(sortedWord)) {
                System.out.println("For word: " + word + " : " + anagrams.get(sortedWord));
                anagrams.put(sortedWord, new ArrayList<>());
            }

            anagrams.get(sortedWord).add(word);

            System.out.println(anagrams);
        }

        return anagrams;
    }
}
