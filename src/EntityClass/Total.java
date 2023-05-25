package EntityClass;

import com.alibaba.fastjson.annotation.JSONField;

public class Total {
    @JSONField(name = "AverageScore",ordinal = 1)
    private double AverageScore;
    @JSONField(name = "AveragePostgraduate",ordinal = 2)
    private double AveragePostgraduate;
    @JSONField(name = "GPA",ordinal = 3)
    private String GPA;
    @JSONField(name = "Rank",ordinal = 4)
    private String Rank;


    public double getAverageScore() {
        return AverageScore;
    }

    public void setAverageScore(double AverageScore) {
        this.AverageScore = AverageScore;
    }

    public double getAveragePostgraduate() {
        return AveragePostgraduate;
    }

    public void setAveragePostgraduate(double AveragePostgraduate) {
        this.AveragePostgraduate = AveragePostgraduate;
    }

    public String getGPA() {
        return GPA;
    }

    public void setGPA(String GPA) {
        this.GPA = GPA;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String Rank) {
        this.Rank = Rank;
    }


    @Override
    public String toString() {
        return "total{" +
                "AverageScore='" + AverageScore + '\'' +
                ", AveragePostgraduate='" + AveragePostgraduate + '\'' +
                ", GPA=" + GPA +
                ", Rank=" + Rank +
                '}';
    }

    public Total(){}

    public Total(double averageScore, double averagePostgraduate, String GPA, String rank) {
        AverageScore = averageScore;
        AveragePostgraduate = averagePostgraduate;
        this.GPA = GPA;
        Rank = rank;
    }
}
