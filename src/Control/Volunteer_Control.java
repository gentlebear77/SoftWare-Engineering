package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Volunteer_Control {
    private Volunteer currentVolunteer;

    public void setCurrentVolunteer(Volunteer currentVolunteer) {
        this.currentVolunteer = currentVolunteer;
    }

    public Volunteer getCurrentVolunteer() {
        return this.currentVolunteer;
    }


    public ArrayList<Volunteer> Read_VolunteerJson(String StudentID){
        try{
            FileReader fr=new FileReader("src/users/"+StudentID+"/Volunteer.json");
            ArrayList<Volunteer> result=new ArrayList<Volunteer>();
            JSONReader reader=new JSONReader(fr);
            reader.startArray();//开始解析json数组
            while (reader.hasNext()) {
                reader.startObject();//开始解析json对象
                Volunteer m = new Volunteer();
                while (reader.hasNext()) {
                    String key = reader.readString();
                    if ("VolunteerName".equals(key)) {
                        m.setVolunteerName(reader.readString());
                    } else if ("Duration".equals(key)) {
                        m.setDuration(reader.readString());
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



    public boolean writeUserFile(String id, String VolunteerName,String Date,String Duration) {
        JSONObject jsonObj = new JSONObject();
//向jsonObj中添加数据：{"adapter":"WLAN","ip_address":"192.168.1.6"}
        jsonObj.put("VolunteerName", VolunteerName);
        jsonObj.put("Date", Date);
        jsonObj.put("Duration", Duration);
        System.out.println("要添加到JSON文件中的数据:" + jsonObj);
//写入操作
        try {
            String filePath = "src/users/" + id + "/Volunteer.json";

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
