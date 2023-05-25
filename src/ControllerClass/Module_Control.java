package ControllerClass;

import java.util.ArrayList;
import EntityClass.*;
import EntityClass.Module;

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
