import java.util.ArrayList;

/**
 * Main class for Data Parsers
 * @author: Nadia Anees
 */
public class Main {
    public static void main(String[] args) {
        //Test of utils
        //String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        String data = Utils.readFileAsString("data/Education.csv");


        String[] cleanedFiles = Utils.readFileWithCleanedLines("data/Education.csv");
       // loadDataIntoState(cleanedFiles);


    }
}
