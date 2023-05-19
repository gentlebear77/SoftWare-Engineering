package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Module_Control {
    private Module currentModule;

    public void setCurrentModule(Module currentModule) {
        this.currentModule = currentModule;
    }

    public Module getCurrentModule() {
        return this.currentModule;
    }

    public int ModuleCheck(String id){
        //寻找文件
        File userFile = new File("src/users/"+id+"/User.json");
        if (!userFile.exists()) {//找不到文件，无用户，0
            return 0;
        }
        //字节读取判断

        Module user = readUserFile(id);

        this.setCurrentModule(user);
        return 1;
    }

    private static Module readUserFile(String id){
        try{
            FileReader fr=new FileReader("src/users/"+id+"/Module.json");

            JSONReader reader=new JSONReader(fr);
            reader.startArray();//开始解析json数组
            Module m = new Module();
            while (reader.hasNext()) {
                reader.startObject();//开始解析json对象

                while (reader.hasNext()) {
                    String key = reader.readString();
                    if ("moduleNum".equals(key)) {
                        m.setModuleNum(reader.readString());
                    } else if ("moduleName".equals(key)) {
                        m.setModuleName(reader.readString());
                    } else if ("Grade".equals(key)) {
                        m.setGrade(reader.readInteger());
                    } else if ("credit".equals(key)) {
                        m.setCredit(Double.parseDouble(reader.readString()));
                    } else if ("mark".equals(key)) {
                        m.setMark(Double.parseDouble(reader.readString()));
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


    public boolean writeUserFile(String id, String moduleNum,String moduleName,int Grade,double credit,double mark) {
        JSONObject jsonObj = new JSONObject();
//向jsonObj中添加数据：{"adapter":"WLAN","ip_address":"192.168.1.6"}
        jsonObj.put("moduleNum", moduleNum);
        jsonObj.put("moduleName", moduleName);
        jsonObj.put("Grade", Grade);
        jsonObj.put("credit", credit);
        jsonObj.put("mark", mark);
        System.out.println("要添加到JSON文件中的数据:" + jsonObj);
//写入操作
        try {
            RandomAccessFile RAwiter = new RandomAccessFile("src/users/" + id + "/Module.json", "rw");
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
