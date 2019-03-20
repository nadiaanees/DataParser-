import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
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

    public static String[] readFileWithCleanedLines(String file, int linesToSkip) {
        file = readFileAsString(file);
        String[] lines = file.split("\n");
        lines = removePercentSymbol(lines);
        lines = removeCommasInBetweenQuotes(lines);
        return lines;
    }

    public static String[] removeCommasInBetweenQuotes(String[] rows) {
        for (int i = 1; i < rows.length; i++) {
            if (rows[i].contains("\"")) {
                int indexOfFirstQuote = rows[i].indexOf("\"");
                int indexOfLastQuote = rows[i].indexOf("\"", indexOfFirstQuote + 1);
                String num = rows[i].substring(indexOfFirstQuote, indexOfLastQuote);
                for (int r = indexOfFirstQuote; r <= indexOfLastQuote; r++) {
                    rows[i] = rows[i].replace(num, num.replace(",", "")).trim();
                }
                int indexOfFirstQuoteN = rows[i].indexOf("\"");
                int indexOfLastQuoteN = rows[i].indexOf("\"", indexOfFirstQuoteN + 1);
                String numN = rows[i].substring(indexOfFirstQuoteN, indexOfLastQuoteN + 1);
                for (int r = indexOfFirstQuoteN; r <= indexOfLastQuoteN; r++) {
                    rows[i] = rows[i].replace(numN, numN.replace("\"", ""));
                }
            }
        }
        return rows;
    }

    public static String[] removePercentSymbol(String[] rows){
        for (int i = 1; i < rows.length; i++) {
            if (rows[i].contains("%")) {
                rows[i] = rows[i].replace("%", "");
            }
            rows[i].replaceAll(" ", "");
        }
        return rows;
    }


/*
   public static ArrayList<ElectionResults> parse2016PresidentialResults(String data) {
        ArrayList<ElectionResults> electionResults = new ArrayList<>();
        String[] rows = data.split("\n");
        rows = removeUnwantedItems(rows);
        double firstField, secField, thirdField, fourthField, fifthField, sixthField, seventhField, tenthField;
        String eighthField, ninthField;
        for (int i = 1; i < rows.length; i++) {
            String[] var = rows[i].split(",");
            firstField = Double.parseDouble(var[1]);
            secField = Double.parseDouble(var[2]);
            thirdField = Double.parseDouble(var[3]);
            fourthField = Double.parseDouble(var[4]);
            fifthField = Double.parseDouble(var[5]);
            sixthField = Double.parseDouble(var[6]);
            seventhField = Double.parseDouble(var[7]);
            eighthField = var[8];
            ninthField = var[9];
            tenthField = Double.parseDouble(var[10]);
            ElectionResults result = new ElectionResults(firstField, secField, thirdField, fourthField, fifthField, sixthField, seventhField, eighthField, ninthField, tenthField);
            electionResults.add(result);
        }
        return electionResults;
    }


    }*/

}



