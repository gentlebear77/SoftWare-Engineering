package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Project_Control {
    private Project currentProject;
    private String[] Tags=new String[]{"Project","ProjectName","Content","Date","Grade",""};

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }

    public Project getCurrentProject() {
        return this.currentProject;
    }


    public ArrayList<Project> Read_ProjectJson(String StudentID){
        ArrayList<ArrayList<String>> infoList=Record_Control.Read_Json(StudentID,this.Tags);
        ArrayList<Project> result=new ArrayList<Project>();
        for(int i=0;i<infoList.size();i++){
            result.add(new Project(infoList.get(i)));
        }
        return result;
    }


    public boolean writeUserFile(String id, String ProjectName,String Date,String Content,String Grade) {
        ArrayList<String> info=new ArrayList<String>();
        info.add(ProjectName);
        info.add(Date);
        info.add(Content);
        info.add(Grade);
        return Record_Control.writeFile(id,this.Tags,info);
    }
}
