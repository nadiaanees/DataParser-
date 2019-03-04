import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public static ArrayList<ElectionResults> parse2016PresidentialResults(String data) {

        ArrayList<ElectionResults> electionResults = new ArrayList<>();
        String[] rows = data.split("\n");
        //rows = removeUnwantedItems(rows);

        // for (int i = 1; i < rows.length; i++) {
            //String[] var = rows[i].split(",");
            //ElectionResults result = new ElectionResults();
            //electionResults.add(result);
       // }

        return electionResults;
    }

    public static String[] removeUnwantedItems(String[] rows) {

        for (int i = 1; i < rows.length; i++) {

            if (rows[i].contains("\"")) {
                int indexOfFirstQuote = rows[i].indexOf("\"");
                int indexOfLastQuote = rows[i].indexOf("\"", indexOfFirstQuote + 1);
                String num = rows[i].substring(indexOfFirstQuote, indexOfLastQuote);
                for (int r = indexOfFirstQuote; r <= indexOfLastQuote; r++) {
                    rows[i] = rows[i].replace(num, num.replace(",", ""));
                }

                int indexOfFirstQuoteN = rows[i].indexOf("\"");
                int indexOfLastQuoteN = rows[i].indexOf("\"", indexOfFirstQuoteN + 1);
                String numN = rows[i].substring(indexOfFirstQuoteN, indexOfLastQuoteN + 1);
                for (int r = indexOfFirstQuoteN; r <= indexOfLastQuoteN; r++) {
                    rows[i] = rows[i].replace(numN, numN.replace("\"", ""));
                }
            }

            if (rows[i].contains("%")) {
                rows[i] = rows[i].replace("%","");
            }

        }
        return rows;

    }
}



