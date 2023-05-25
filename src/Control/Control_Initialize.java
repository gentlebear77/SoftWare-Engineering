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

    public void setCurrentUser(Student currentUser) {
        this.currentUser = currentUser;
    }

    public Student getCurrentUser() {
        return this.currentUser;
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
            this.setCurrentUser(user);
            //this.getCurrentUser().getModuleList().addAll(Read_ModuleJson(this.getCurrentUser().getStudentID()));
            return 1;
        }
        //密码错误
        return 2;
    }

    public static Student readUserFile(String id){
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

    public boolean signUp(String id,String password,String major,String studentName,String degree){
        File file = new File("././src/users/"+id+"/User.json");
        File file1 = new File("././src/users/"+id+"/Module.json");
        File file2 = new File("././src/users/"+id+"/Total.json");
        File file3 = new File("././src/users/"+id+"/Project.json");
        File file4 = new File("././src/users/"+id+"/Achievement.json");
        File file5 = new File("././src/users/"+id+"/Representative.json");
        File file6 = new File("././src/users/"+id+"/Volunteer.json");
        if(!file.exists()){

            try {
                Path path= Paths.get("././src/users/"+id);
                Files.createDirectories(path);
                file.createNewFile();
                file1.createNewFile();  file2.createNewFile();  file3.createNewFile();
                file4.createNewFile();  file5.createNewFile();  file6.createNewFile();
                System.out.println("文件创建成功");
                writeUserFile(id,password,major,studentName,degree);
                try{
                    FileWriter fileWriter1=new FileWriter(file1);
                    BufferedWriter bufferedWriter1=new BufferedWriter(fileWriter1);
                    bufferedWriter1.write("[]");

                    bufferedWriter1.close();
                    fileWriter1.close();
                    FileWriter fileWriter2=new FileWriter(file2);
                    BufferedWriter bufferedWriter2=new BufferedWriter(fileWriter2);
                    bufferedWriter2.write("[]");

                    bufferedWriter2.close();
                    fileWriter2.close();

                    FileWriter fileWriter3=new FileWriter(file3);
                    BufferedWriter bufferedWriter3=new BufferedWriter(fileWriter3);
                    bufferedWriter3.write("[]");

                    bufferedWriter3.close();
                    fileWriter3.close();

                    FileWriter fileWriter4=new FileWriter(file4);
                    BufferedWriter bufferedWriter4=new BufferedWriter(fileWriter4);
                    bufferedWriter4.write("[]");

                    bufferedWriter4.close();
                    fileWriter4.close();

                    FileWriter fileWriter5=new FileWriter(file5);
                    BufferedWriter bufferedWriter5=new BufferedWriter(fileWriter5);
                    bufferedWriter5.write("[]");

                    bufferedWriter5.close();
                    fileWriter5.close();

                    FileWriter fileWriter6=new FileWriter(file6);
                    BufferedWriter bufferedWriter6=new BufferedWriter(fileWriter6);
                    bufferedWriter6.write("[]");

                    bufferedWriter6.close();
                    fileWriter6.close();
                }catch (IOException e){System.out.println(e.getMessage());}

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

    public static void newFile(String id,String record){
        try{

            File file=new File("src/users/"+id+"/"+record+".json");
            //file.delete();
            //new FileWriter(file,false).close();
            FileWriter fw=new FileWriter(file,false);
            BufferedWriter bw=new BufferedWriter(fw);
            fw.write("[]");
            bw.close();
            fw.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}
