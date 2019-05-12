package view;

import com.sun.org.apache.xpath.internal.operations.Bool;
import model.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ConsoleCallback {
    private Scanner scanner = new Scanner(System.in);
    private Storage storage = new Storage();
    private Staff currentUser = null;
    private Student selectedStudent = null;

    // Get user choice from a menu of options
    private Integer getChoice(String[] choices) {
        Integer choice = null;

        while (choice == null) {
            System.out.println("\nPlease choose an option:");
            for (int i = 1; i <= choices.length; i++) {
                System.out.println(String.valueOf(i) + ". " + choices[i - 1]);
            }
            System.out.println();
            try {
                int next = Integer.parseInt(scanner.nextLine());
                if (next > 0 && next <= choices.length) {
                    choice = next - 1;
                } else {
                    System.out.print("\nInvalid input, enter a number from the following list.");
                }
            } catch (NumberFormatException e) {
                System.out.print("\nInvalid input, must be a number.");
            }
        }
        return choice;
    }

    // Get csv user input
    private String[] getList(String question) {
        String[] input;

        System.out.print(question + " (comma separated list): ");
        String next = scanner.nextLine();
        if (next.equals("")) {
            input = null;
            System.out.println("Exiting");
        } else {
            input = next.split(",");
        }
        return input;
    }

    // Get user input
    private String getInput(String question) {
        String input;

        System.out.print(question + ": ");
        String next = scanner.nextLine();
        if (next.equals("")) {
            input = null;
            System.out.println("Exiting");
        } else {
            input = next;
        }
        return input;
    }

    // Get user input - date
    private Date getDate(String question) {
        Date input = null;
        boolean ok = false;

        while (!ok) {
            System.out.print(question + " (DDMMYYYY): ");
            String next = scanner.nextLine();
            if (next.equals("")) {
                System.out.println("Exiting");
                ok = true;
            } else {
                if (next.length() == 8) {
                    Calendar startDate = Calendar.getInstance();
                    startDate.set(Calendar.DAY_OF_MONTH, Integer.valueOf(next.substring(0, 1)));
                    startDate.set(Calendar.MONTH, Integer.valueOf(next.substring(1, 3)));
                    startDate.set(Calendar.YEAR, Integer.valueOf(next.substring(3, 7)));

                    input = startDate.getTime();
                    ok = true;
                } else {
                    System.out.println("Date not valid");
                }
            }
        }
        return input;
    }

    // Get user input - boolean
    private Boolean getBoolean(String question) {
        Boolean input = null;
        boolean ok = false;

        while (!ok) {
            System.out.print(question + " (Y/N): ");
            String next = scanner.nextLine();
            if (next.equals("")) {
                System.out.println("Exiting");
                ok = true;
            } else {
                if (next.equals("Y") || next.equals("N")) {
                    input = next.equals("Y");
                    ok = true;
                } else {
                    System.out.println("Must be Y or N");
                }
            }
        }
        return input;
    }

    // Start the system
    public void start() {

        System.out.print(
                "         ########         ########         ########\n" +
                "       #####            #####            #####     \n" +
                "      ####             ####             ####       \n" +
                "       ####             ####             ####      \n" +
                "         ####             ####             ####    \n" +
                "           ####             ####             ####  \n" +
                "         #####            #####            #####   \n" +
                "     ########         ########         ########    \n");
        System.out.println("\n                    Welcome to SSS");
        System.out.println("Loading data...");
        storage.loadData();
        System.out.println();
        mainMenu();
    }

    private void mainMenu() {
        String[] options = new String[] {"Login", "Sign up", "Quit"};
        int choice = getChoice(options);
        if (choice == 0) {
            login();
        } else if (choice == 1) {
            signup();
        } else {
            quit();
        }
    }

    private void quit() {
        System.out.println("\nSaving data to storage...");
        if (!storage.saveData()) {
            System.out.println("Error: Unable to save to storage.");
        }
        System.out.println("\nGoodbye.");
        System.exit(0);
    }

    private void login() {
        System.out.println("\nLogin to SSS");
        String staffId = getInput("Staff number");
        if (staffId == null) {
            mainMenu();
            return;
        }
        //TODO: validity checking
        String pass = getInput("Password");
        if (pass == null) {
            mainMenu();
            return;
        }

        currentUser = storage.authUser(staffId, pass);
        if (currentUser == null) {
            System.out.println("\nLogin details incorrect. Try again.");
            login();
        } else {
            // Logged in
            System.out.println("\nWelcome " + currentUser.getName());
            studentActions();
        }
    }

    private void signup() {
        System.out.println("\nSign up to SSS");

        String staffId = getInput("Staff number");
        if (staffId == null) {
            mainMenu();
            return;
        }
        //TODO: validity checking

        String given = getInput("Given name");
        if (given == null) {
            mainMenu();
            return;
        }

        String last_name = getInput("Last name");
        if (last_name == null) {
            mainMenu();
            return;
        }

        String address = getInput("Address");
        if (address == null) {
            mainMenu();
            return;
        }

        String phone = getInput("Phone number");
        if (phone == null) {
            mainMenu();
            return;
        }

        String department = getInput("Department");
        if (department == null) {
            mainMenu();
            return;
        }

        String title = getInput("Job title");
        if (title == null) {
            mainMenu();
            return;
        }

        String pass = getInput("New password");
        if (pass == null) {
            mainMenu();
            return;
        }

        String passCheck = getInput("New password (again)");
        if (passCheck == null) {
            mainMenu();
            return;
        }

        if (!pass.equals(passCheck)) {
            System.out.println("\nPasswords must match. Try again.");
            signup();
        } else {
            currentUser = storage.addUser(staffId, given, last_name, address, phone, department, title, false, pass);
            // Logged in
            System.out.println("\nWelcome " + currentUser.getName());
            studentActions();
        }
    }

    private void studentActions() {
        String[] options = new String[] {"View student", "Create student", "Log out", "Quit"};
        int choice = getChoice(options);
        if (choice == 0) {
            // Select student
            System.out.println();
            String studentId = getInput("Student number");
            if (studentId == null) {
                studentActions();
                return;
            }

            selectedStudent = storage.getStudent(studentId);
        } else if (choice == 1) {
            if (currentUser.authorityAccess()) {
                createStudent();
            } else {
                System.out.println("You don't have authority to create students.");
            }
        } else if (choice == 2) {
            currentUser = null;
            System.out.println("Logging out");
            mainMenu();
            return;
        } else {
            quit();
        }

        // View student
        if (selectedStudent != null) {
            System.out.println("\n" + selectedStudent.toString());
            selectedStudentActions();
        } else {
            System.out.println("Student doesn't exist.");
            studentActions();
        }
    }

    private void createStudent() {
        System.out.println("\nCreate a new Student");

        String studentId = getInput("Student number");
        if (studentId == null) {
            studentActions();
            return;
        }
        //TODO: validity check

        String studentGiven = getInput("Student given name");
        if (studentGiven == null) {
            studentActions();
            return;
        }

        String studentFamily = getInput("Student family name");
        if (studentFamily == null) {
            studentActions();
            return;
        }

        String studentAddress = getInput("Student address");
        if (studentAddress == null) {
            studentActions();
            return;
        }

        String studentPhone = getInput("Student phone number");
        if (studentPhone == null) {
            studentActions();
            return;
        }

        selectedStudent = storage.addStudent(studentId, studentGiven, studentFamily, studentAddress, studentPhone);

        editStudent();
    }

    private void selectedStudentActions() {
        // Viewing student
        String[] options = new String[] {"View program structure", "Filter program structure", "Edit program structure", "Close student"};
        int choice = getChoice(options);
        if (choice == 0) {
            System.out.println(String.valueOf(selectedStudent.getProgramStructure().toString()));
            //TODO: Print program structure and allow viewing of comments
            selectedStudentActions();
        } else if (choice == 1) {
            System.out.println(String.valueOf(selectedStudent.getProgramStructure().toString(ProgramStructure.FILTER_COURSE)));
            //TODO: Print program structure and allow viewing of comments
            selectedStudentActions();
        } else if (choice == 2) {
            if (currentUser.authorityAccess()) {
                editStudent();
            } else {
                System.out.println("You don't have authority to edit students");
                selectedStudentActions();
            }
        } else if (choice == 3) {
            studentActions();
        }
    }

    private void editStudent() {
        String[] options = new String[] {"Add course", "Add exemption", "Add transfer", "Add internship", "Exit edit mode"};
        int choice = getChoice(options);
        if (choice == 0 || choice == 1) {
            String courseCode = getInput("Course code");
            if (courseCode == null) {
                editStudent();
                return;
            }

            String courseName = getInput("Course name");
            if (courseName == null) {
                editStudent();
                return;
            }

            String[] prerequisitesString = null;
            Course[] prerequisites = null;
            Boolean hasPrerequisites = getBoolean("Are there any prerequisites?");
            if (hasPrerequisites == null) {
                editStudent();
                return;
            } else if (hasPrerequisites) {
                prerequisitesString = getList("Prerequisites course codes");
                prerequisites = new Course[prerequisitesString.length];
                for (int i = 0; i < prerequisitesString.length; i++) {
                    prerequisites[i] = selectedStudent.getProgramStructure().getCourseByCode(prerequisitesString[i]);
                }
            }

            Date startDate = getDate("Start date");
            if (startDate == null) {
                editStudent();
                return;
            }

            Date endDate = null;

            Boolean isCompleted = getBoolean("Course completed?");
            if (isCompleted == null) {
                editStudent();
                return;
            } else if (isCompleted) {
                endDate = getDate("End date");
                if (endDate == null) {
                    editStudent();
                    return;
                }
            }

            Course newCourse = new Course(courseCode,courseName, currentUser, prerequisites, startDate, isCompleted, endDate, choice == 1);
            selectedStudent.getProgramStructure().addCategory(newCourse);
            editStudent();
        } else if (choice == 2) {
            System.out.println("Transfer object not defined yet...");
            editStudent();
        } else if (choice == 3) {
            System.out.println("Internship object not defined yet...");
            editStudent();
        } else if (choice == 4) {
            System.out.println("\n" + selectedStudent.toString());
            selectedStudentActions();
        }
    }
}
