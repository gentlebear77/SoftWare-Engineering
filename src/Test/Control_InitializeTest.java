package Test;

import ControllerClass.Control_Initialize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;


class Control_InitializeTest {
    private Control_Initialize controlInitialize;

    @BeforeEach
    public void setUp() {
        controlInitialize = new Control_Initialize();
    }

    @Test
    public void testLoginCheck_WithValidCredentials_ShouldReturnSuccessCode() {
        // Arrange
        String id = "user1";
        String password = "password123";

        // Act
        int result = controlInitialize.loginCheck(id, password);

        // Assert
        Assertions.assertEquals(1, result);
        Assertions.assertNotNull(controlInitialize.getCurrentUser());
        Assertions.assertEquals(id, controlInitialize.getCurrentUser().getStudentID());
    }

    @Test
    public void testLoginCheck_WithInvalidId_ShouldReturnNotFoundCode() {
        // Arrange
        String id = "nonexistent";
        String password = "password123";

        // Act
        int result = controlInitialize.loginCheck(id, password);

        // Assert
        Assertions.assertEquals(0, result);
        Assertions.assertNull(controlInitialize.getCurrentUser());
    }

    @Test
    public void testLoginCheck_WithIncorrectPassword_ShouldReturnInvalidPasswordCode() {
        // Arrange
        String id = "user1";
        String password = "wrongpassword";

        // Act
        int result = controlInitialize.loginCheck(id, password);

        // Assert
        Assertions.assertEquals(2, result);
        Assertions.assertNull(controlInitialize.getCurrentUser());
    }

    @Test
    public void testSignUp_WithNewIdAndPassword_ShouldCreateUserFile() {
        // Arrange
        String id = "newuser";
        String password = "newpassword";
        String major = "Computer Science";
        String studentName = "John Doe";
        String degree = "Bachelor's";

        // Act
        boolean result = controlInitialize.signUp(id, password, major, studentName, degree);

        // Assert
        Assertions.assertTrue(result);
        // Verify that the user file is created
        File userFile = new File("src/users/" + id + "/User.json");
        Assertions.assertTrue(userFile.exists());
        // Verify that the user is set as the current user
        Assertions.assertNotNull(controlInitialize.getCurrentUser());
        Assertions.assertEquals(id, controlInitialize.getCurrentUser().getStudentID());
    }

    @Test
    public void testSignUp_WithExistingId_ShouldReturnFalse() {
        // Arrange
        String id = "user1";
        String password = "newpassword";
        String major = "Computer Science";
        String studentName = "John Doe";
        String degree = "Bachelor's";

        // Act
        boolean result = controlInitialize.signUp(id, password, major, studentName, degree);

        // Assert
        Assertions.assertFalse(result);
        File userFile = new File("src/users/" + id + "/User.json");
        Assertions.assertFalse(userFile.exists());

        Assertions.assertNull(controlInitialize.getCurrentUser());
    }



}
