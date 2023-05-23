package Control;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class Module {
    @JSONField(name = "moduleNum",ordinal = 1)
    private String moduleNum;
    @JSONField(name = "moduleName",ordinal = 2)
    private String moduleName;
    @JSONField(name = "Grade",ordinal = 3)
    private String Grade;
    @JSONField(name = "credit",ordinal = 4)
    private double credit;
    @JSONField(name = "mark",ordinal = 5)
    private double mark;

    public String getModuleNum() {
        return moduleNum;
    }

    public void setModuleNum(String moduleNum) {
        this.moduleNum = moduleNum;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
       this.Grade = grade;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "module{" +
                "moduleNum='" + moduleNum + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", Grade=" + Grade +
                ", credit=" + credit +
                ", mark=" + mark +
                '}';
    }

    public Module(ArrayList<String> info) {
        this.moduleNum = info.get(0);
        this.moduleName = info.get(1);
        this.Grade = info.get(2);
        this.credit = Double.parseDouble(info.get(3));
        this.mark = Double.parseDouble(info.get(4));
    }
    public Module(){}
}
