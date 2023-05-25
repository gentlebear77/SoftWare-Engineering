package Control;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class Student {

    private Student currentUser;

    public void setCurrentUser(Student currentUser) {
        this.currentUser = currentUser;
    }

    public Student getCurrentUser() {
        return this.currentUser;
    }

    @JSONField(name = "studentID",ordinal = 1)
    private String studentID;
    @JSONField(name = "studentName",ordinal = 2)
    private String studentName;
    @JSONField(name = "password",ordinal = 3)
    private String password;
    @JSONField(name = "degree",ordinal = 4)
    private String degree;
    @JSONField(name = "major",ordinal = 5)
    private String major;
    public ArrayList<Module> moduleList;
    public ArrayList<Total> totalList;
    public ArrayList<Project> projectList;
    public ArrayList<Achievement> achievementList;
    public ArrayList<Representative> representativeList;
    public ArrayList<Volunteer> volunteerList;
    public String currentgrade;

    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", password='" + password + '\'' +
                ", degree='" + degree + '\'' +
                ", major='" + major + '\'' +
                ", moduleList=" + moduleList +
                '}';
    }

}
