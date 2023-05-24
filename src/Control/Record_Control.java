package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Record_Control {
    public static void main(String args[]){
        Record_Control RC=new Record_Control();
        RC.Read_Json("111",new String[]{"Achievement","AchievementName","Date"});
        System.out.println(RC.Read_Json("111",new String[]{"Achievement","AchievementName","Date","","",""}));
    }
    public static ArrayList<ArrayList<String>> Read_Json(String StudentID, String[] words){
        try{
            FileReader fr=new FileReader("src/users/"+StudentID+"/"+words[0]+".json");
            JSONReader reader=new JSONReader(fr);
            ArrayList<ArrayList<String>> info=new ArrayList<ArrayList<String>>();
            reader.startArray();//开始解析json数组
            while (reader.hasNext()) {
                reader.startObject();//开始解析json对象
                ArrayList<String> info1=new ArrayList<String>();
                while (reader.hasNext()) {
                    String key = reader.readString();
                    if (words[1].equals(key)) {
                        info1.add(reader.readString());
                    } else if (words[2].equals(key)) {
                        info1.add(reader.readString());
                    } else if (words[3].equals(key)) {
                        info1.add(reader.readString());
                    } else if (words[4].equals(key)) {
                        info1.add(reader.readString());
                    } else if (words[5].equals(key)) {
                        info1.add(reader.readString());
                    } else if (words[6].equals(key)) {
                        info1.add(reader.readString());
                    } else {
                        reader.readObject();//读取对象
                    }

                }
                reader.endObject();//结束解析对象
                info.add(info1);

            }
            reader.endArray();//结束解析数组
            reader.close();//关闭流
            return info;
        }catch (IOException e){
            return null;
        }
    }
    public static boolean writeFile(String id, String[] tags,ArrayList<String> info) {
        JSONObject jsonObj = new JSONObject();
        for(int i=0;i<info.size();i++){
            jsonObj.put(tags[i+1], info.get(i));
        }

        try {
            String filePath = "src/users/" + id + "/"+tags[0]+".json";

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
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
