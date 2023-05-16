package Control;

import com.alibaba.fastjson.JSONObject;
import java.io.*;

public class Control_Add {
    public void addModules(Student user,String moduleNum, String moduleName, int grade, double credit, double mark){
        JSONObject jsonObj = new JSONObject();
//向jsonObj中添加数据：{"adapter":"WLAN","ip_address":"192.168.1.6"}
        jsonObj.put("moduleNum", moduleNum);
        jsonObj.put("moduleName", moduleName);
        jsonObj.put("Grade", grade);
        jsonObj.put("credit", credit);
        jsonObj.put("mark", mark);
        System.out.println("要添加到JSON文件中的数据:"+jsonObj);
//写入操作
        try {
            RandomAccessFile RAwiter = new RandomAccessFile("src/users/"+user.getStudentID()+"/Modules.json", "rw");

            if(RAwiter.length()!=0){
                RAwiter.seek(RAwiter.length()-1);
                RAwiter.writeBytes(",\n"+jsonObj.toString()+"]");//转化成字符串再写
                RAwiter.close();
            }else{
                RAwiter.writeBytes("["+jsonObj.toString()+"]");
                RAwiter.close();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
