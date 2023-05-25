package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Total_Control {
    private Total currentTotal;

    public void setCurrentTotal(Total currentTotal) {
        this.currentTotal = currentTotal;
    }

    public Total getCurrentTotal() {
        return this.currentTotal;
    }

    public ArrayList<Total> Read_TotalJson(String StudentID){
        try{
            FileReader fr=new FileReader("src/users/"+StudentID+"/Total.json");

            ArrayList<Total> result=new ArrayList<Total>();
            JSONReader reader=new JSONReader(fr);
            reader.startArray();//开始解析json数组
            while (reader.hasNext()) {
                reader.startObject();//开始解析json对象
                Total m = new Total();
                while (reader.hasNext()) {
                    String key = reader.readString();
                    if ("AverageScore".equals(key)) {
                        String temp=reader.readString();
                        if(!temp.equals("")){
                            m.setAverageScore(Double.parseDouble(temp));
                        }else{m.setAverageScore(0.0);}
                    } else if ("AveragePostgraduate".equals(key)) {
                        String temp=reader.readString();
                        if(!temp.equals("")){
                            m.setAveragePostgraduate(Double.parseDouble(temp));
                        }else{m.setAveragePostgraduate(0.0);}
                    } else if ("GPA".equals(key)) {
                        m.setGPA(reader.readString());
                    } else if ("Rank".equals(key)) {
                        m.setRank(reader.readString());
                    } else {
                        System.out.println(m);
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

    public boolean writeUserFile(String id, String AverageScore,String AveragePostgraduate,String GPA,String Rank) {
        JSONObject jsonObj = new JSONObject();
//向jsonObj中添加数据：{"adapter":"WLAN","ip_address":"192.168.1.6"}
        jsonObj.put("AverageScore", AverageScore);
        jsonObj.put("AveragePostgraduate", AveragePostgraduate);
        jsonObj.put("GPA", GPA);
        jsonObj.put("Rank", Rank);
        System.out.println("要添加到JSON文件中的数据:" + jsonObj);
//写入操作
        try {
            String filePath = "src/users/" + id + "/Total.json";

//            FileWriter fw=new FileWriter(filePath);
//            BufferedWriter bw=new BufferedWriter(fw);

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
            System.out.println("Error：" + ex.getMessage());
            return false;
        }
    }
}
