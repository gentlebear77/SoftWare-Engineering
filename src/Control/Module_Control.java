package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Module_Control {
    private Module currentModule;

    public void setCurrentModule(Module currentModule) {
        this.currentModule = currentModule;
    }

    public Module getCurrentModule() {
        return this.currentModule;
    }


    public ArrayList<Module> Read_ModuleJson(String StudentID){
        try{
            FileReader fr=new FileReader("src/users/"+StudentID+"/Module.json");
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
                        m.setGrade(reader.readString());
                    } else if ("credit".equals(key)) {
                        m.setCredit(Double.parseDouble(reader.readString()));
                    } else if ("mark".equals(key)) {
                        m.setMark(Double.parseDouble(reader.readString()));
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


    public boolean writeUserFile(String id, String moduleNum, String moduleName, String Grade, double credit, double mark) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("moduleNum", moduleNum);
        jsonObj.put("moduleName", moduleName);
        jsonObj.put("Grade", Grade);
        jsonObj.put("credit", credit);
        jsonObj.put("mark", mark);

        try {
            String filePath = "src/users/" + id + "/Module.json";

            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
            long fileLength = randomAccessFile.length();
            System.out.println(fileLength);
            if (fileLength == 2) {
                randomAccessFile.seek(fileLength - 1); // 移动到倒数第二个字符位置，即最后一个数据项之前的逗号位置

                randomAccessFile.writeBytes(jsonObj.toString());
            } else {
                randomAccessFile.seek(fileLength - 2); // 移动到倒数第二个字符位置，即最后一个数据项之前的逗号位置
                randomAccessFile.writeBytes(",\n");
                randomAccessFile.writeBytes(jsonObj.toString());
            }

            randomAccessFile.writeBytes("\n]"); // 添加 JSON 数组的结束标记
            randomAccessFile.close();

            System.out.println("JSON successful：" + filePath);
            return true;
        } catch (IOException ex) {
            System.out.println("写入文件时发生错误：" + ex.getMessage());
            return false;
        }
    }
}
