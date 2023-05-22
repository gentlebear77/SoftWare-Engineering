package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Project_Control {
    private Project currentProject;

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }

    public Project getCurrentProject() {
        return this.currentProject;
    }


    public ArrayList<Project> Read_ProjectJson(String StudentID){
        try{
            FileReader fr=new FileReader("src/users/"+StudentID+"/Project.json");
            ArrayList<Project> result=new ArrayList<Project>();
            JSONReader reader=new JSONReader(fr);
            reader.startArray();//开始解析json数组
            while (reader.hasNext()) {
                reader.startObject();//开始解析json对象
                Project m = new Project();
                while (reader.hasNext()) {
                    String key = reader.readString();
                    if ("ProjectName".equals(key)) {
                        m.setProjectName(reader.readString());
                    } else if ("Content".equals(key)) {
                        m.setContent(reader.readString());
                    } else if ("Date".equals(key)) {
                        m.setDate(reader.readString());
                    } else {

                        reader.readObject();//读取对象
                    }

                }
                reader.endObject();//结束解析对象
                result.add(m);
            }
            reader.endArray();//结束解析数组
            reader.close();//关闭流
            return result;
        }catch (IOException e){
            return null;
        }
    }


    public boolean writeUserFile(String id, String ProjectName,String Date,String Content) {
        JSONObject jsonObj = new JSONObject();
//向jsonObj中添加数据：{"adapter":"WLAN","ip_address":"192.168.1.6"}
        jsonObj.put("ProjectName", ProjectName);
        jsonObj.put("Date", Date);
        jsonObj.put("Content", Content);
        System.out.println("要添加到JSON文件中的数据:" + jsonObj);
//写入操作
        try {
            RandomAccessFile RAwiter = new RandomAccessFile("src/users/" + id + "/Project.json", "rw");
            if (RAwiter.length() != 0) {
                System.out.println("用户文件存在且损坏");
                return false;
            } else {
                RAwiter.writeBytes("[" + jsonObj.toString() + "]");
                RAwiter.close();
                return true;
            }

        } catch (IOException ex) {
            return false;
        }
    }
}
