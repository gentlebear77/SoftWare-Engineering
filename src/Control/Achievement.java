package Control;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class Achievement {
    @JSONField(name = "AchievementName",ordinal = 1)
    private String AchievementName;
    @JSONField(name = "Date",ordinal = 2)
    private String Date;
    @JSONField(name = "Grade",ordinal = 3)
    private String Grade;

    public String getAchievementName() {
        return AchievementName;
    }

    public void setAchievementName(String AchievementName) {
        this.AchievementName = AchievementName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getGrade() {
        return Grade;
    }
    @Override
    public String toString() {
        return "total{" +
                "AchievementName='" + AchievementName + '\'' +
                ", Date='" + Date + '\'' +
                ", Grade='" + Grade +
                '}';
    }

    public Achievement(){}

    public Achievement(ArrayList<String> info) {
        AchievementName = info.get(0);
        Date = info.get(1);
        Grade = info.get(2);
    }
}
