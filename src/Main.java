import java.util.ArrayList;

/**
 * Main class for Data Parsers
 * @author: Nadia Anees
 */
public class Main {
    public static void main(String[] args) {
        //Test of utils
        //String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        String[] data = Utils.readEducationFile("C:\\Users\\nanees600\\IdeaProjects\\DataParser2\\data\\Education V.2 - Education (1).csv");


        //String[] cleanedFiles = Utils.readFileWithCleanedLines("data/Education.csv");
       // loadDataIntoState(cleanedFiles);


    }
}
