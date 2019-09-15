package task.drew.parsingwebsite.util;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import task.drew.parsingwebsite.persistence.model.Pair;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class Parser {

    public static Map<String, Pair> parseTag(String url, String tag){
        Map<String, Pair> treeMap = new TreeMap<>();
        Map<String, Pair> subTreeMap;
        try {

            Document document = Jsoup.connect(url).get();

            Elements tags = document.select(tag);

            for (Element element : tags) {

                subTreeMap = parseString(element.text());

                for (String word : subTreeMap.keySet()) {
                    addIfNotExists(treeMap, word);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("Tag map is " + treeMap.toString());

        return treeMap;
    }

    public static void addIfNotExists(Map<String, Pair> treeMap, String word) {
        long value;
        if(treeMap != null && word != null && !word.equals("")) {
            if (treeMap.containsKey(word)) {
                value = treeMap.get(word).getQuantity();
                treeMap.put(word, new Pair(word, ++value));
            } else {
                treeMap.put(word, new Pair(word, 1L));
            }
        }
    }

    private static Map<String, Pair> parseString(String s){
        Map<String, Pair> uniqueWordMap = new TreeMap<>();

        String[] words = s.split("\\P{L}+");

        for (String word : words) {
            addIfNotExists(uniqueWordMap, word);
        }

//        uniqueWordMap.forEach((k, v) -> log.info("Pair: " + k + " - " + v.getQuantity() + " "));

        return uniqueWordMap;
    }
}
