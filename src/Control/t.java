package Control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class t {
    public static void main(String[] args){

        //File file = new File("/src/users/"+"2"+"User.json");



//        try{
//            try (BufferedReader reader = new BufferedReader(new FileReader("src/users/1/User.json"))) {
//                StringBuilder content = new StringBuilder();
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    content.append(line);
//                }
//System.out.println(content);
//            } catch (FileNotFoundException e) {
//                throw new IOException("Error reading user file.", e);
//            }
//        }catch (IOException e){
//            ;
//        }
//
        Control_Initialize i=new Control_Initialize();
        Control_Search se=new Control_Search();
        Control_Add adder=new Control_Add();
//        System.out.println(i.loginCheck("1","1"));
        //System.out.println(i.writeUserFile("1","a","w","q","e"));
        int j=0;
        i.loginCheck("1","1");
        Student s=i.getCurrentUser();
        System.out.println(s);
        System.out.println(se.searchModule(i.getCurrentUser(),"1","credit"));
        adder.addModules(s,"EBU","EBU",9,9.0,9.0);




//        Control_Search c=new Control_Search();
//        System.out.println();
//        c.Read_ModuleJson("1");
//




    }


}
