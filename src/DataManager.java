import java.util.List;

public class DataManager {
    public DataManager(List<State> states) {
        this.states = states;
    }

    private List<State> states;

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
}
