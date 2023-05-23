package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Representative_Control {
    private Representative currentRepresentative;
    private String[] Tags={"Representative","RepresentativeName","Date","","",""};

    public void setCurrentRepresentative(Representative currentRepresentative) {
        this.currentRepresentative = currentRepresentative;
    }

    public Representative getCurrentRepresentative() {
        return this.currentRepresentative;
    }


    public ArrayList<Representative> Read_RepresentativeJson(String StudentID){
        ArrayList<ArrayList<String>> infoList=Record_Control.Read_Json(StudentID,this.Tags);
        ArrayList<Representative> result=new ArrayList<Representative>();
        for(int i=0;i<infoList.size();i++){
            result.add(new Representative(infoList.get(i)));
        }
        return result;
    }

    public boolean writeUserFile(String id, String RepresentativeName,String Date) {
        ArrayList<String> info=new ArrayList<String>();
        info.add(RepresentativeName);
        info.add(Date);
        return Record_Control.writeFile(id,this.Tags,info);
    }
}
