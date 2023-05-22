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
            RandomAccessFile RAwiter = new RandomAccessFile("src/users/" + id + "/Volunteer.json", "rw");
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
