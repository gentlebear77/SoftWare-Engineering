package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;



public class Control_Initialize {
    private Student currentUser;

    public Student getCurrentUser() {
        return this.currentUser;
    }

    public void setCurrentUser(Student currentUser) {
        this.currentUser = currentUser;
    }

    public int loginCheck(String id, String password){
        //寻找文件
        File userFile = new File("src/users/"+id+"/User.json");
        if (!userFile.exists()) {//找不到文件，无用户，0
            return 0;
        }
        //字节读取判断

        Student user = readUserFile(id);
        if(user==null){return -1;}
        if (user.getPassword().equals(password)) {
            //this.setCurrentUser(user);
            //this.getCurrentUser().getModuleList().addAll(Read_ModuleJson(this.getCurrentUser().getStudentID()));
            return 1;
        }
        //密码错误
        return 2;
    }
    private static Student readUserFile(String id){
        try{
            FileReader fr=new FileReader("src/users/"+id+"/User.json");
            ArrayList<Module> result=new ArrayList<Module>();
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

    public boolean signUp(String id,String password,String major,String studentName,String degree){
        File file = new File("././src/users/"+id+"/User.json");

        if(!file.exists()){

            try {
                Path path= Paths.get("././src/users/"+id);
                Files.createDirectories(path);
                file.createNewFile();
                System.out.println("文件创建成功");
                writeUserFile(id,password,major,studentName,degree);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            System.out.println("用户文件存在");
            return false;
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

    public ArrayList<Module> Read_ModuleJson(String StudentID){
        try{
            FileReader fr=new FileReader("src/users/"+StudentID+"/Modules.json");
            ArrayList<Module> result=new ArrayList<Module>();
            JSONReader reader=new JSONReader(fr);
            reader.startArray();//开始解析json数组
            while (reader.hasNext()) {
                reader.startObject();//开始解析json对象
                Module m = new Module();
                while (reader.hasNext()) {
                    String key = reader.readString();
                    if ("moduleNum".equals(key)) {
                        m.setModuleNum(reader.readString());
                    } else if ("moduleName".equals(key)) {
                        m.setModuleName(reader.readString());
                    } else if ("Grade".equals(key)) {
                        m.setGrade(reader.readInteger());
                    } else if ("credit".equals(key)) {
                        m.setCredit(reader.readInteger());
                    } else if ("mark".equals(key)) {
                        m.setMark(reader.readInteger());
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
}
