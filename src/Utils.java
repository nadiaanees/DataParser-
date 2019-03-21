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

    public static String[] readEducationFile(String file, int linesToSkip) {
        file = readFileAsString(file);
        String[] lines = file.split("\n");
        for (int i = 1; i < lines.length; i++) {
            lines[i].split(",");
            lines = removePercentSymbol(lines);
            lines = removeCommasInBetweenQuotes(lines);
            String[] stringFile = keepAsString(lines, 0, 1);
            double[] doubleFile = convertToDouble(lines, 1, 8);
            EducationResults ed = new EducationResults(stringFile, doubleFile);
        }

        return lines;
    }

    private static double[] convertToDouble(String[] lines, int start, int end) {
        double[] arr = null;
        for (int i = start; i < end; i++) {
            arr[i] = Double.parseDouble(lines[i]);
        }
        return arr;
    }

    private static String[] keepAsString(String[] lines, int start, int end) {
        String[] arr = null;
        for (int i = start; i<end; i++){
            arr[i] = lines[i];
        }
        return arr;
    }

    public static String[] readPregnancyFile(String file, int linesToSkip) {
        file = readFileAsString(file);
        String[] lines = file.split("\n");
        for (int i = 1; i < lines.length; i++) {
            lines[i].split(",");
            lines = removePercentSymbol(lines);
            lines = removeCommasInBetweenQuotes(lines);
            String stateName = lines[i].substring(0, 1);
            double rate = Double.parseDouble(lines[i].substring(1, 2));
            PregnancyResults ed = new PregnancyResults(stateName, rate);
        }
        return lines;
    }

    public static String[] readUnemploymentFile(String file, int linesToSkip) {
        file = readFileAsString(file);
        String[] lines = file.split("\n");
        for (int i = 1; i < lines.length; i++) {
            lines[i].split(",");
            lines = removePercentSymbol(lines);
            lines = removeCommasInBetweenQuotes(lines);
            String stateName = lines[i].substring(0, 1);
            double[] arr = convertToDouble(lines, 1, 6);
            EmploymentResults employ = new EmploymentResults(stateName, arr);
        }

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


   /* public static ArrayList<ElectionResults> parse2016PresidentialResults(String data) {
        ArrayList<ElectionResults> electionResults = new ArrayList<>();
        String[] rows = data.split("\n");
        rows = rem(rows);
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
    */

    //split data by lines
    //loop over lines, and remove the unwanted stuff
    //convert into necessary variables and save those values into different arrays like int[], String[]
    //then create your objects like ElectionResult result = new ElectionResult(file, intFile, StringFile)
    //In electionResult, EmploymentResult and PregnancyResul you save the necessary lines into the correct fields


    }





