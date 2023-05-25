package EntityClass;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class Project {
    @JSONField(name = "ProjectName",ordinal = 1)
    private String ProjectName;
    @JSONField(name = "Date",ordinal = 2)
    private String Date;
    @JSONField(name = "Content",ordinal = 3)
    private String Content;
    @JSONField(name = "Grade",ordinal = 4)
    private String Grade;


    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getGrade() {
        return Grade;
    }
    @Override
    public String toString() {
        return "total{" +
                "ProjectName='" + ProjectName + '\'' +
                ", Date='" + Date + '\'' +
                ", Content=" + Content + '\'' +
                ", Grade=" + Grade +
                '}';
    }

    public Project(){}

    public Project(ArrayList<String> info) {
        ProjectName = info.get(0);
        Date = info.get(1);
        Content = info.get(2);
        Grade = info.get(3);
    }
}
