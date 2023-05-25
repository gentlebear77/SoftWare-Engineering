package Control;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class Volunteer {
    @JSONField(name = "VolunteerName",ordinal = 1)
    private String VolunteerName;
    @JSONField(name = "Date",ordinal = 2)
    private String Date;
    @JSONField(name = "Duration",ordinal = 3)
    private String Duration;
    @JSONField(name = "Grade",ordinal = 3)
    private String Grade;


    public String getVolunteerName() {
        return VolunteerName;
    }

    public void setVolunteerName(String VolunteerName) {
        this.VolunteerName = VolunteerName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    public String getGrade() {
        return Grade;
    }

    @Override
    public String toString() {
        return "total{" +
                "VolunteerName='" + VolunteerName + '\'' +
                ", Date='" + Date + '\'' +
                ", Duration=" + Duration + '\'' +
                ", Grade=" + Grade +
                '}';
    }

    public Volunteer(){}

    public Volunteer(ArrayList<String> info) {
        VolunteerName = info.get(0);
        Date = info.get(1);
        Duration = info.get(2);
        Grade = info.get(3);
    }
}
