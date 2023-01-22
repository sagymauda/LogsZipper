import service.SearchFiles;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        SearchFiles searchFiles = new SearchFiles();
        final File path = new File("C:/Users/unibeam/Desktop/exc");
        Map<String, Map<String, List<String>>> resultFiles = searchFiles.getFiles(path);

        Utils.printMap(resultFiles);

    }
}
