package ControllerClass;

import java.util.ArrayList;
import EntityClass.*;

public class Achievement_Control {
    private Achievement currentAchievement;
    private String[] Tags={"Achievement","AchievementName","Date","Grade","",""};

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



    public boolean writeUserFile(String id, String AchievementName,String Date, String Grade) {
        ArrayList<String> info=new ArrayList<String>();
        info.add(AchievementName);
        info.add(Date);
        info.add(Grade);

        return Record_Control.writeFile(id,this.Tags,info);
    }
}
