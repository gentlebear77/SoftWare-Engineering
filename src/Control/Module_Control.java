package Control;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Module_Control {
    private Module currentModule;
    private String[] Tags={"Module","moduleNum","moduleName","Grade","credit","mark"};

    public void setCurrentModule(Module currentModule) {
        this.currentModule = currentModule;
    }

    public Module getCurrentModule() {
        return this.currentModule;
    }


    public ArrayList<Module> Read_ModuleJson(String StudentID){
        ArrayList<ArrayList<String>> infoList=Record_Control.Read_Json(StudentID,this.Tags);
        ArrayList<Module> result=new ArrayList<Module>();
        for(int i=0;i<infoList.size();i++){
            result.add(new Module(infoList.get(i)));
        }
        return result;
    }


    public boolean writeUserFile(String id, String moduleNum, String moduleName, String Grade, double credit, double mark) {
        ArrayList<String> info=new ArrayList<String>();
        info.add(moduleNum);
        info.add(moduleName);
        info.add(Grade);
        info.add(""+credit);
        info.add(""+mark);
        return Record_Control.writeFile(id,this.Tags,info);
    }
}
