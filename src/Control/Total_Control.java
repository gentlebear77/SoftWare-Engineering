package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
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
                        m.setAverageScore(Double.parseDouble(reader.readString()));
                    } else if ("AveragePostgraduate".equals(key)) {
                        m.setAveragePostgraduate(Double.parseDouble(reader.readString()));
                    } else if ("GPA".equals(key)) {
                        m.setGPA(reader.readString());
                    } else if ("Rank".equals(key)) {
                        m.setRank(reader.readString());
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

    public boolean writeUserFile(String id, double AverageScore,double AveragePostgraduate,String GPA,String Rank) {
        JSONObject jsonObj = new JSONObject();
//向jsonObj中添加数据：{"adapter":"WLAN","ip_address":"192.168.1.6"}
        jsonObj.put("AverageScore", AverageScore);
        jsonObj.put("AveragePostgraduate", AveragePostgraduate);
        jsonObj.put("GPA", GPA);
        jsonObj.put("Rank", Rank);
        System.out.println("要添加到JSON文件中的数据:" + jsonObj);
//写入操作
        try {
            RandomAccessFile RAwiter = new RandomAccessFile("src/users/" + id + "/Total.json", "rw");
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
