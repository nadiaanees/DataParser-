/**
 * Main class for Data Parsers
 * @author: Nadia Anees
 */
public class Main {
    public static void main(String[] args) {
        //Test of utils

        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        System.out.println(data);
    }
}
