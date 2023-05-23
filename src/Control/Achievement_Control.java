package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Achievement_Control {
    private Achievement currentAchievement;
    private String[] Tags={"Achievement","AchievementName","Date","","",""};

    public void setCurrentAchievement(Achievement currentAchievement) {
        this.currentAchievement = currentAchievement;
    }

    public Achievement getCurrentAchievement() {
        return this.currentAchievement;
    }


    public ArrayList<Achievement> Read_AchievementJson(String StudentID){
        ArrayList<ArrayList<String>> infoList=Record_Control.Read_Json(StudentID,this.Tags);
        ArrayList<Achievement> result=new ArrayList<Achievement>();
        for(int i=0;i<infoList.size();i++){
            result.add(new Achievement(infoList.get(i)));
        }
       return result;
    }



    public boolean writeUserFile(String id, String AchievementName,String Date) {
        ArrayList<String> info=new ArrayList<String>();
        info.add(AchievementName);
        info.add(Date);
        return Record_Control.writeFile(id,this.Tags,info);
    }
}
