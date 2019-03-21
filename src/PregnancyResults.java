public class PregnancyResults {

    private String stateName;
    private  double rate;

    public PregnancyResults(String stateName, double rate ){
        this.stateName = stateName;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate){
        this.rate = rate;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "state name: " + stateName + "rate: " + rate;
    }
}
