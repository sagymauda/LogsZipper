package utils;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String getKeyForMap(String dateWithHours) {
        return dateWithHours.substring(10, 20);
    }

    public static void printMap(Map<String,Map<String, List<String>>> map) {
//        for (Map.Entry<String, Map<String,List<String>>> entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//            for (Map.Entry<String, List<String>> innerEntry : entry.getValue()) {
//                for (String elem : innerEntry) {
//                    System.out.println(elem);
//                }
//            }
//        }
    }

    public static String extractFile(File current) {
        Pattern pattern = Pattern.compile("systemlog-(.*)\\.log");
        Matcher matcher = pattern.matcher(current.toString());
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }


    public static boolean patternMatchToFile(File file) {

        Pattern pattern = Pattern.compile("systemlog-\\d{4}-\\d{2}-\\d{2}-\\d{2}-\\d{2}\\.log");
        Matcher matcher = pattern.matcher(file.getName());
        return matcher.find();
    }

    public static String createKeyForInnerMap(String s) {
        String temp = s.substring(0, 23);
        StringBuilder sb = new StringBuilder();
        sb.append(temp);
        return sb.append(".zip").toString();

    }
}
