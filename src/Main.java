

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    private String firstName;
    private String lastName;
    private String username;
    private String password;

    // Constructor
    public Main(String username, String password, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    // Method to validate username
    public boolean validateUsername() {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to validate password
    public boolean validatePassword() {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[!@#\\$%^&*].*");
    }

    // Method to register user
    public void registerUser() {
        if (validateUsername()) {
            JOptionPane.showMessageDialog(null, "Username successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return;
        }

        if (validatePassword()) {
            JOptionPane.showMessageDialog(null, "Password successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            return;
        }
    }

    // Method to log in user
    public void loginUser(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            JOptionPane.showMessageDialog(null, "Welcome to Easykaban");
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again.");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        String username = JOptionPane.showInputDialog("Enter first name:");
        String password = JOptionPane.showInputDialog("Enter last name:");
        String firstName = JOptionPane.showInputDialog("Enter username:");
        String lastName = JOptionPane.showInputDialog("Enter password:");

        Main login = new Main(username, password, firstName, lastName);
        login.registerUser();

        String loginUsername = JOptionPane.showInputDialog("Enter username to login:");
        String loginPassword = JOptionPane.showInputDialog("Enter password to login:");
        login.loginUser(loginUsername, loginPassword);
    }
}
    class Task {
        private static int taskCount = 0;
        private static String name;
        private int number;
        private String description;
        private String developerDetails;
        private int duration;
        private String id;
        private String status;

        public Task(String name, String description, String developerDetails, int duration, String status) {
            this.name = name;
            this.number = taskCount++;
            this.description = description;
            this.developerDetails = developerDetails;
            this.duration = duration;
            this.status = status;
            this.id = generateId();
        }

        private String generateId() {
            return (name.length() > 1 ? name.substring(0, 2) : name) + ":" + number + ":" +
                    (developerDetails.length() > 2 ? developerDetails.substring(0, 3) : developerDetails).toUpperCase();
        }

        private static void showMenu() {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add tasks");
            System.out.println("2. Show report");
            System.out.println("3. Quit");
        }

        private static void addTasks(BufferedReader reader) throws IOException {
            System.out.print("How many tasks do you want to add? ");
            int numTasks = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numTasks; i++) {
                System.out.print("Enter task name: ");
                String name = reader.readLine();

            }
            String description;
            while (true) {
                System.out.print("Enter task description (less than 50 characters): ");
                description = reader.readLine();
                if (description.length() <= 50) {
                    System.out.println("Task successfully captured");
                    break;
                } else {
                    System.out.println("Please enter a task description of less than 50 characters");
                }
            }

            System.out.print("Enter developer details: ");
            String developerDetails = reader.readLine();

            System.out.print("Enter task duration in hours: ");
            int duration = Integer.parseInt(reader.readLine());

            System.out.println("Select task status:");
            System.out.println("1. To Do");
            System.out.println("2. Done");
            System.out.println("3. Doing");
            String status = "";
            while (true) {
                int statusChoice = Integer.parseInt(reader.readLine());
                if (statusChoice == 1) {
                    status = "To Do";
                    break;
                } else if (statusChoice == 2) {
                    status = "Done";
                    break;
                } else if (statusChoice == 3) {
                    status = "Doing";
                    break;
                } else {
                    System.out.println("Invalid choice, please select again.");
                }
            }

            Task task = new Task(name, description, developerDetails, duration, status);
            task.add(task);
            System.out.println("Task added: " + task);
        }

        private void add(Task task) {
        }
    }



