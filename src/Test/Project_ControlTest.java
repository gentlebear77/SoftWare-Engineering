package Test;

import ControllerClass.Project_Control;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import EntityClass.*;

public class Project_ControlTest {
    private Project_Control projectControl;

    @BeforeEach
    public void setUp() {
        projectControl = new Project_Control();
    }

    @Test
    public void testRead_ProjectJson_WithValidStudentID_ShouldReturnProjectList() {
        // Arrange
        String studentID = "user1";
        // Mock the behavior of Record_Control.Read_Json method to return a sample project information list
        ArrayList<ArrayList<String>> projectInfoList = new ArrayList<>();
        projectInfoList.add(new ArrayList<String>() {{
            add("P001");
            add("Project 1");
            add("2023-05-01");
            add("Lorem ipsum dolor sit amet");
        }});
        projectInfoList.add(new ArrayList<String>() {{
            add("P002");
            add("Project 2");
            add("2023-05-15");
            add("Consectetur adipiscing elit");
        }});

        // Act
        ArrayList<Project> result = projectControl.Read_ProjectJson(studentID);

        // Assert
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Project 1", result.get(0).getProjectName());
        Assertions.assertEquals("2023-05-01", result.get(0).getDate());
        Assertions.assertEquals("Lorem ipsum dolor sit amet", result.get(0).getContent());
        Assertions.assertEquals("Project 2", result.get(1).getProjectName());
        Assertions.assertEquals("2023-05-15", result.get(1).getDate());
        Assertions.assertEquals("Consectetur adipiscing elit", result.get(1).getContent());
    }

    @Test
    public void testWriteUserFile_WithValidData_ShouldWriteToFileAndReturnTrue() {
        // Arrange
        String id = "user1";
        String projectName = "Project 1";
        String date = "2023-05-01";
        String content = "Lorem ipsum dolor sit amet";
        // Mock the behavior of Record_Control.writeFile method to return true


        // Act
        boolean result = projectControl.writeUserFile(id, projectName, date, content,"1");

        // Assert
        Assertions.assertTrue(result);
        // Verify that the file is written
        File projectFile = new File("src/users/" + id + "/Project.json");
        Assertions.assertTrue(projectFile.exists());
        // Verify the content of the file
        // Add your own assertions here to check the file content if needed
    }

    // Add more test cases as needed

}
