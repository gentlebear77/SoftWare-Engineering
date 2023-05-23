package Control;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class Representative {
    @JSONField(name = "RepresentativeName",ordinal = 1)
    private String RepresentativeName;
    @JSONField(name = "Date",ordinal = 2)
    private String Date;


    public String getRepresentativeName() {
        return RepresentativeName;
    }

    public void setRepresentativeName(String RepresentativeName) {
        this.RepresentativeName = RepresentativeName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }


    @Override
    public String toString() {
        return "total{" +
                "RepresentativeName='" + RepresentativeName + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }

    public Representative(){}

    public Representative(ArrayList<String> info) {
        RepresentativeName = info.get(0);
        Date = info.get(1);
    }
}
