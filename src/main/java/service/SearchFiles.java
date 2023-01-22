package service;

import utils.Utils;

import java.io.File;
import java.util.*;

public class SearchFiles {

    Map<String, Map<String, List<String>>> files = new HashMap<>();
    Map<String, List<String>> dates = null;
    List<String> logsList = null;


    public Map<String, Map<String, List<String>>> getFiles(final File folder) {
        for (final File currentFile : Objects.requireNonNull(folder.listFiles())) {
            if (currentFile.isDirectory()) {
                getFiles(currentFile);
            } else {
                if (Utils.patternMatchToFile(currentFile)) {
                    String current = Utils.extractFile(currentFile);

                    String currentKeyForMap = Utils.getKeyForMap(current);
                    //in case i got a new key
                    String innerMapKey = Utils.createKeyForInnerMap(current);
                    if (!files.containsKey(currentKeyForMap)) {
                        dates = new HashMap<>();
                        //in case i dont have any new inner key
                        logsList = new ArrayList<>();
                        logsList.add(current);
                        dates.put(innerMapKey, logsList);
                        files.put(currentKeyForMap, dates);
                        // in case it does contain the key
                    } else {
                        // in case the key is allready there
                        Map<String, List<String>> currentDates = files.get(currentKeyForMap);
                        if (!currentDates.containsKey(innerMapKey)) {
                            dates = new HashMap<>();
                            logsList = new ArrayList<>();
                            logsList.add(current);
                            dates.put(innerMapKey,logsList);
                            files.put(currentKeyForMap,dates);

                        }else{
                            List<String> logsList = currentDates.get(innerMapKey);
                            logsList.add(current);
                            dates.put(innerMapKey, logsList);
                        }

                        files.put(currentKeyForMap, currentDates);
                    }
                }
            }
        }

        return files;
    }
}
