package Test;

import ControllerClass.Module_Control;
import EntityClass.Module;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import EntityClass.*;

public class Module_ControlTest {
    private Module_Control moduleControl;

    @BeforeEach
    public void setUp() {
        moduleControl = new Module_Control();
    }

    @Test
    public void testRead_ModuleJson_WithValidStudentID_ShouldReturnModuleList() {
        // Arrange
        String studentID = "user1";
        // Mock the behavior of Record_Control.Read_Json method to return a sample module information list
        ArrayList<ArrayList<String>> moduleInfoList = new ArrayList<>();
        moduleInfoList.add(new ArrayList<String>() {{
            add("M001");
            add("Module 1");
            add("A");
            add("4.0");
            add("87.5");
        }});
        moduleInfoList.add(new ArrayList<String>() {{
            add("M002");
            add("Module 2");
            add("B+");
            add("3.0");
            add("75.0");
        }});


        // Act
        ArrayList<Module> result = moduleControl.Read_ModuleJson(studentID);

        // Assert
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("M001", result.get(0).getModuleNum());
        Assertions.assertEquals("Module 1", result.get(0).getModuleName());
        Assertions.assertEquals("A", result.get(0).getGrade());
        Assertions.assertEquals(4.0, result.get(0).getCredit());
        Assertions.assertEquals(87.5, result.get(0).getMark());
        Assertions.assertEquals("M002", result.get(1).getModuleNum());
        Assertions.assertEquals("Module 2", result.get(1).getModuleName());
        Assertions.assertEquals("B+", result.get(1).getGrade());
        Assertions.assertEquals(3.0, result.get(1).getCredit());
        Assertions.assertEquals(75.0, result.get(1).getMark());
    }

    @Test
    public void testWriteUserFile_WithValidData_ShouldWriteToFileAndReturnTrue() {
        // Arrange
        String id = "user1";
        String moduleNum = "M001";
        String moduleName = "Module 1";
        String grade = "A";
        double credit = 4.0;
        double mark = 87.5;



        // Act
        boolean result = moduleControl.writeUserFile(id, moduleNum, moduleName, grade, credit, mark);

        // Assert
        Assertions.assertTrue(result);
        // Verify that the file is written
        File moduleFile = new File("src/users/" + id + "/Module.json");
        Assertions.assertTrue(moduleFile.exists());

    }


}
