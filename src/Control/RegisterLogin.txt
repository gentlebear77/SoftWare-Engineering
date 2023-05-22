package Control;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class RegisterLogin {
    private static final String USER_DATA_DIR = "src/users";
    /**
     * the main funcion is the reference of the hint for the user
     * we will delete it in our later processing
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:\n1. Register\n2. Login");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            System.out.println("Enter your username:");
            String username = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            try {
                register(username, password, "1","2","yhz");
            } catch (IOException e) {
                System.err.println("Error during registration: " + e.getMessage());
            }
        } else if (option == 2) {
            System.out.println("Enter your username:");
            String username = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            try {
                if (login(username, password)) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Invalid username or password.");
                }
            } catch (IOException e) {
                System.err.println("Error during login: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid option.");
        }

        scanner.close();
    }

    /**
     * why we need the real name of a user?
     * @param username
     * @param password
     * @param grade
     * @param major
     * @param name
     * @return
     * @throws IOException
     */
    public static boolean register(String username, String password, String grade, String major, String name) throws IOException {
        File userFile = getUserFile(username);
        if (userFile.exists()) {
            System.out.println("Username already exists.");
            return false;
        }

        JSONObject user = new JSONObject();
        user.put("username", username);
        user.put("password", password);
        user.put("grade", grade);
        user.put("major", major);
        user.put("name", name);
        writeUserToFile(userFile, user);
        System.out.println("Registration successful!");
        return true;
    }

    public static boolean login(String username, String password) throws IOException {
        File userFile = getUserFile(username);
        if (!userFile.exists()) {
            return false;
        }

        JSONObject user = readUserFromFile(userFile);
        if (user.getString("password").equals(password)) {
            return true;
        }
        return false;
    }

    private static File getUserFile(String username) {
        return new File(USER_DATA_DIR + File.separator + username + ".json");
    }

    private static JSONObject readUserFromFile(File userFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            return JSON.parseObject(content.toString());
        } catch (FileNotFoundException e) {
            throw new IOException("Error reading user file.", e);
        }
    }

    private static void writeUserToFile(File userFile, JSONObject user) throws IOException {
        if (!userFile.getParentFile().exists()) {
            Files.createDirectories(Paths.get(userFile.getParent()));
        }
        try (FileWriter writer = new FileWriter(userFile)) {
            writer.write(JSON.toJSONString(user));
        } catch (IOException e) {
            throw new IOException("Error writing user file.", e);
        }
    }
}
