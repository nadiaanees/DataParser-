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
        rows = removeUnwantedItems(rows);

        for (int i = 1; i < rows.length; i++) {
            String[] var = rows[i].split(",");
            for (int r = 0; r < rows.length; r++) {
                int first = var[r].indexOf(",", 0);
                double firstField = Double.parseDouble(var[r].substring(0, first));
                int second = var[r].indexOf(",", first + 1);
                double secField = Double.parseDouble(var[r].substring(first, second));
                int third = var[r].indexOf(",", second + 1);
                double thirdField = Double.parseDouble(var[r].substring(second, third));
                int fourth = var[r].indexOf(",", third + 1);
                double fourthField = Double.parseDouble(var[r].substring(third, fourth));
                int fifth = var[r].indexOf(",", fourth + 1);
                double fifthField = Double.parseDouble(var[r].substring(fourth, fifth));
                int sixth = var[r].indexOf(",", fifth + 1);
                double sixthField = Double.parseDouble(var[r].substring(fifth, sixth));
                int seventh = var[r].indexOf(",", sixth + 1);
                double seventhField = Double.parseDouble(var[r].substring(sixth, seventh));
                int eighth = var[r].indexOf(",", seventh + 1);
                String eighthField = var[r].substring(seventh, eighth);
                int ninth = var[r].indexOf(",", eighth + 1);
                String ninthField = var[r].substring(eighth, ninth);
                int tenth = var[r].indexOf(",", ninth + 1);
                double tenthField = Double.parseDouble(var[r].substring(ninth, tenth));
                ElectionResults result = new ElectionResults(firstField, secField, thirdField, fourthField, fifthField, sixthField, seventhField, eighthField, ninthField, tenthField);
                electionResults.add(result);
            }
        }

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
                rows[i] = rows[i].replace("%", "");
            }

        }
        return rows;

    }
}



