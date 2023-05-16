package Control;

import com.alibaba.fastjson.annotation.JSONField;

public class Project {
    @JSONField(name = "ProjectName",ordinal = 1)
    private String ProjectName;
    @JSONField(name = "Date",ordinal = 2)
    private String Date;
    @JSONField(name = "Content",ordinal = 3)
    private String Content;


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


    @Override
    public String toString() {
        return "total{" +
                "ProjectName='" + ProjectName + '\'' +
                ", Date='" + Date + '\'' +
                ", Content=" + Content +
                '}';
    }

    public Project(){}
}
