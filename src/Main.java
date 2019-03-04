import java.util.ArrayList;

/**
 * Main class for Data Parsers
 * @author: Nadia Anees
 */
public class Main {
    public static void main(String[] args) {
        //Test of utils

        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        ArrayList<ElectionResults> results = Utils.parse2016PresidentialResults(data);
        for(ElectionResults r : results ){
            System.out.println(r.toString());
        }
    }
}
