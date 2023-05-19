package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;



public class Student_Control {
    private Student currentUser;

    public void setCurrentUser(Student currentUser) {
        this.currentUser = currentUser;
    }

    public Student getCurrentUser() {
        return this.currentUser;
    }


    private static Student readUserFile(String id){
        try{
            FileReader fr=new FileReader("src/users/"+id+"/User.json");
            //ArrayList<Module> result=new ArrayList<Module>();
            JSONReader reader=new JSONReader(fr);
            reader.startArray();//开始解析json数组
            Student m = new Student();
            while (reader.hasNext()) {
                reader.startObject();//开始解析json对象

                while (reader.hasNext()) {
                    String key = reader.readString();
                    if ("studentID".equals(key)) {
                        m.setStudentID(reader.readString());
                    } else if ("studentName".equals(key)) {
                        m.setStudentName(reader.readString());
                    } else if ("password".equals(key)) {
                        m.setPassword(reader.readString());
                    } else if ("degree".equals(key)) {
                        m.setDegree(reader.readString());
                    } else if ("major".equals(key)) {
                        m.setMajor(reader.readString());
                    } else {
                        reader.readObject();//读取对象
                    }

                }
                reader.endObject();//结束解析对象
            }
            reader.endArray();//结束解析数组
            reader.close();//关闭流
            return m;
        }catch (IOException e){
            System.out.println(e);
            System.out.println("用户数据文件异常");
            return null;
        }
    }

    public boolean writeUserFile(String id,String password,String major,String studentName,String degree){
        JSONObject jsonObj = new JSONObject();
//向jsonObj中添加数据：{"adapter":"WLAN","ip_address":"192.168.1.6"}
        jsonObj.put("studentID", id);
        jsonObj.put("studentName", studentName);
        jsonObj.put("password", password);
        jsonObj.put("degree", degree);
        jsonObj.put("major", major);
        System.out.println("要添加到JSON文件中的数据:"+jsonObj);
//写入操作
        try {
            RandomAccessFile RAwiter = new RandomAccessFile("src/users/"+id+"/User.json", "rw");
            if(RAwiter.length()!=0){
                System.out.println("用户文件存在且损坏");
                return false;
            }else{
                RAwiter.writeBytes("["+jsonObj.toString()+"]");
                RAwiter.close();
                return true;
            }

        } catch (IOException ex) {
            return false;
        }
    }

}
