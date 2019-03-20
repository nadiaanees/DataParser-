import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static List<State> states;

 public DataManager(List<State> states) {
        this.states = states;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "DataManager{" +
                "states=" + states +
                '}';
    }

    public static State getState(String name) {
        for (State state : states) {
            if (state.getName().equals(name)) {
                return state;
            }
        }
        return null;
    }

    public static void loadData(String electionFile, String educationFile, String unemploymentFile) {
        String[] electionLines = Utils.readFileWithCleanedLines(electionFile, 1);
        String[] educationLines = Utils.readFileWithCleanedLines(educationFile, 5);
        String[] unemploymentLines = Utils.readFileWithCleanedLines(unemploymentFile, 8);

        for (int i = 0; i < electionLines.length; i++) {
            String[] vals = electionLines[i].split(",");
            if (isValidToParseElect(vals)) {
                addStateObjectsElect(electionLines );
                addCountyObjectsElect(electionLines);
            }
        }

        for (int i = 0; i < educationLines.length; i++) {
            String[] vals = educationLines[i].split(",");
            if (isValidToParseEd(vals)) {
                addStateObjectsEd(educationLines);
                addCountyObjectsEd(educationLines);
            }
        }

        for (int i = 0; i < unemploymentLines.length; i++) {
            String[] vals = unemploymentLines[i].split(",");
            if (isValidToParseEmploy(vals)) {
                addStateObjectsUnemploy(unemploymentLines);
                addCountyObjectsUnemploy(unemploymentLines);
            }
        }

        loadEducationDataIntoObj(educationLines);
        loadEducationDataIntoObj(educationLines);
        loadEducationDataIntoObj(educationLines);
    }

    private static void addStateObjectsEd(String[] educationLines) {
    }

    private static boolean isValidToParseEmploy(String[] vals) {
        return false;
    }

    private static boolean isValidToParseElect(String[] vals) {
        return true;
    }

    private static boolean isValidToParseEd(String[] vals) {
        if (!(containsLetters(vals))) return false;
        return true;
    }

    private static boolean containsLetters(String[] vals) {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < alphabet.length; i++) {
            if (vals.equals(i)) return true;
        }
        return false;
    }

    private static boolean isInteger(String str) {
        int n = 0;
        try {
            n = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static void loadEducationDataIntoObj(String[] educationLines) {

    }

    private static void addCountyObjectsElect(String[] lines) {
     for(String line: lines){
         String[] vals = line.split(",");
         String stateName = vals[8];

         State e = getState(stateName);
         if( e == null){
             System.out.println("non-existant state :" + stateName);
             continue;
         }
         String countyName = vals[9];
         int fips = Integer.parseInt(vals[10]);
         e.addCounty(new County(countyName, fips, el, ed, em));
     }
    }

    private static void addStateObjectsElect(String[] electionLines) {
        for (int i = 0; i < electionLines.length; i++) {
            String[] vals = electionLines[i].split(",");
            String stateNames = vals[8];

            State e = getState(stateNames);
            states.add(e);
        }
    }

}
