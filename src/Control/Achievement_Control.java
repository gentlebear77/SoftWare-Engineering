package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Achievement_Control {
    private Achievement currentAchievement;

    public void setCurrentAchievement(Achievement currentAchievement) {
        this.currentAchievement = currentAchievement;
    }

    public Achievement getCurrentAchievement() {
        return this.currentAchievement;
    }


    private static Achievement readUserFile(String id){
        try{
            FileReader fr=new FileReader("src/users/"+id+"/Achievement.json");

            JSONReader reader=new JSONReader(fr);
            reader.startArray();//开始解析json数组
            Achievement m = new Achievement();
            while (reader.hasNext()) {
                reader.startObject();//开始解析json对象

                while (reader.hasNext()) {
                    String key = reader.readString();
                    if ("AchievementName".equals(key)) {
                        m.setAchievementName(reader.readString());
                    } else if ("Date".equals(key)) {
                        m.setDate(reader.readString());
                    }  else {
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


    public boolean writeUserFile(String id, String AchievementName,String Date) {
        JSONObject jsonObj = new JSONObject();
//向jsonObj中添加数据：{"adapter":"WLAN","ip_address":"192.168.1.6"}
        jsonObj.put("AchievementName", AchievementName);
        jsonObj.put("Date", Date);
        System.out.println("要添加到JSON文件中的数据:" + jsonObj);
//写入操作
        try {
            RandomAccessFile RAwiter = new RandomAccessFile("src/users/" + id + "/Achievement.json", "rw");
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
