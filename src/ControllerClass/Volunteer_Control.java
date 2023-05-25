package ControllerClass;

import java.util.ArrayList;
import EntityClass.*;

public class Volunteer_Control {
    private Volunteer currentVolunteer;
    private String[] Tags={"Volunteer","VolunteerName","Duration","Date","Grade",""};

    public void setCurrentVolunteer(Volunteer currentVolunteer) {
        this.currentVolunteer = currentVolunteer;
    }

    public Volunteer getCurrentVolunteer() {
        return this.currentVolunteer;
    }


    public ArrayList<Volunteer> Read_VolunteerJson(String StudentID){
        ArrayList<ArrayList<String>> infoList=Record_Control.Read_Json(StudentID,this.Tags);
        ArrayList<Volunteer> result=new ArrayList<Volunteer>();
        for(int i=0;i<infoList.size();i++){
            result.add(new Volunteer(infoList.get(i)));
        }
        return result;
    }



    public boolean writeUserFile(String id, String VolunteerName,String Date,String Duration,String Grade) {
        ArrayList<String> info=new ArrayList<String>();
        info.add(VolunteerName);
        info.add(Date);
        info.add(Duration);
        info.add(Grade);
        return Record_Control.writeFile(id,this.Tags,info);
    }
}
