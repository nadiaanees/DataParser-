public class EmploymentResults {

    private String stateName;
    private double rate;

    public EmploymentResults(String stateName, double[] values) {
        this.stateName = stateName;
        this.rate = rate;
    }

    public String getStateName() {
        return stateName;
    }

    public double getRate(){
       return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
