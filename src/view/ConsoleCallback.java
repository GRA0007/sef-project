package view;

import model.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

    // Get user input - number
    private Integer getNumber(String question) {
        Integer input = null;
        boolean ok = false;

        while (!ok) {
            System.out.print(question + ": ");
            try {
                String next = scanner.nextLine();
                if (next.equals("")) {
                    ok = true;
                    System.out.println("Exiting");
                } else {
                    input = Integer.parseInt(next);
                    ok = true;
                }
            } catch (NumberFormatException e) {
                System.out.print("\nInvalid input, must be a number.");
                ok = false;
            }
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
                if (next.equalsIgnoreCase("Y") || next.equalsIgnoreCase("N")) {
                    input = next.equalsIgnoreCase("Y");
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
        storage.loadData(false);
        System.out.println();
        mainMenu();
    }

    private void mainMenu() {
        String[] options = new String[] {"Login", "Sign up", "Quit", "[TEST] Load test data", "[TEST] Clear all data"};
        int choice = getChoice(options);
        if (choice == 0) {
            login();
        } else if (choice == 1) {
            signup();
        } else if (choice == 2) {
            quit();
        } else if (choice == 3) {
            storage.loadData(true);
            mainMenu();
        } else if (choice == 4) {
            storage.clearData();
            mainMenu();
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
            currentUser = storage.addUser(staffId, given, last_name, address, phone, department, title, 0, pass);
            // Logged in
            System.out.println("\nWelcome " + currentUser.getName());
            studentActions();
        }
    }

    private void studentActions() {
        String[] options = new String[] {"View student", "Create student", "View list of at risk students", "Log out", "Quit"};
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
            if (currentUser.authorityAccess() > 2) {
                createStudent();
            } else {
                System.out.println("You don't have authority to create students.");
            }
        } else if (choice == 2) {
            List<Student> students = storage.getAtRiskStudents();
            System.out.println("List of at risk students:\n");
            System.out.println("#  | Risk | Student id | Student name");
            System.out.println("-------------------------------------------------");
            int i = 0;
            for (Student student : students) {
                System.out.println(String.format("%-2s | %-4s | %-10s | %s", i+1, student.getRiskLevel(), student.getID(), student.getName()));
                i++;
            }
            System.out.println("-------------------------------------------------\n");

            if (students.size() > 0) {
                Boolean selectStudent = getBoolean("Select a student?");
                if (selectStudent != null && selectStudent) {
                    Integer index = getNumber("Enter number from the list above");
                    if (index == null) {
                        studentActions();
                        return;
                    } else if (index - 1 < 0 || index - 1 > students.size()) {
                        System.out.println("Number not valid");
                        studentActions();
                        return;
                    }
                    selectedStudent = students.get(index - 1);
                }
            } else {
                studentActions();
                return;
            }
        } else if (choice == 3) {
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
        String[] options = new String[] {"View program structure", "Filter program structure", "Edit program structure", "Edit \"at risk\" status", "Close student"};
        int choice = getChoice(options);
        if (choice == 0) {
            System.out.println(String.valueOf(selectedStudent.getProgramStructure().toString()));
            programStructureActions(selectedStudent.getProgramStructure().getResults());
            selectedStudentActions();
        } else if (choice == 1) {
            filterStructure();
        } else if (choice == 2) {
            if (currentUser.authorityAccess() > 2) {
                editStudent();
            } else {
                System.out.println("You don't have authority to edit students");
                selectedStudentActions();
            }
        } else if (choice == 3) {
            editAtRisk();
        } else if (choice == 4) {
            studentActions();
        }
    }

    private void filterStructure() {
        String[] options = new String[] {"Filter by category (course, internship, etc.)", "Filter by staff member", "Cancel"};
        int choice = getChoice(options);
        if (choice == 0) {
            String[] filters = new String[] {"Courses", "Exemptions", "Internships", "Transfers", "Back"};
            int filterChoice = getChoice(filters);
            if (filterChoice == 0) {
                System.out.println(String.valueOf(selectedStudent.getProgramStructure().toString(ProgramStructure.FILTER_COURSE)));
                programStructureActions(selectedStudent.getProgramStructure().getResults(ProgramStructure.FILTER_COURSE));
            } else if (filterChoice == 1) {
                System.out.println(String.valueOf(selectedStudent.getProgramStructure().toString(ProgramStructure.FILTER_EXEMPTION)));
                programStructureActions(selectedStudent.getProgramStructure().getResults(ProgramStructure.FILTER_EXEMPTION));
            } else if (filterChoice == 2) {
                System.out.println(String.valueOf(selectedStudent.getProgramStructure().toString(ProgramStructure.FILTER_INTERNSHIP)));
                programStructureActions(selectedStudent.getProgramStructure().getResults(ProgramStructure.FILTER_INTERNSHIP));
            } else if (filterChoice == 3) {
                System.out.println(String.valueOf(selectedStudent.getProgramStructure().toString(ProgramStructure.FILTER_TRANSFER)));
                programStructureActions(selectedStudent.getProgramStructure().getResults(ProgramStructure.FILTER_TRANSFER));
            }
            selectedStudentActions();
        } else if (choice == 1) {
            String staff_id = getInput("Staff id");
            if (staff_id == null) {
                filterStructure();
                return;
            }

            System.out.println(String.valueOf(selectedStudent.getProgramStructure().toString(storage.getUser(staff_id))));
            programStructureActions(selectedStudent.getProgramStructure().getResults(storage.getUser(staff_id)));
            selectedStudentActions();
        } else {
            selectedStudentActions();
        }
    }

    private void programStructureActions(List<AbstractCategory> results) {
        if (results.size() > 0) {
            Boolean viewComments = getBoolean("View comments on a category?");
            if (viewComments != null && viewComments) {
                Integer index = getNumber("Enter number of category to choose");
                if (index == null) {
                    return;
                } else if (index - 1 < 0 || index - 1 > results.size()) {
                    System.out.println("Number not valid");
                    return;
                }

                System.out.println(results.get(index - 1).getComments());
                Boolean addComments = getBoolean("Add a comment?");
                if (addComments != null && addComments) {
                    String newComment = getInput("Enter your comment");
                    if (newComment != null) {
                        Comment newCommentToAdd = new Comment(newComment, currentUser);
                        results.get(index - 1).addComment(newCommentToAdd);

                        Boolean sendComment = getBoolean("Would you like to send the comment to the student?");

                        if(sendComment != null && sendComment){
                            String email = getInput("Please enter your email address or DEFAULT if you wish to use the existing email address");
                            //TODO: Validation
                            if(email.equalsIgnoreCase("DEFAULT")){
                                email = currentUser.getEmail();
                            }
                            String password = getInput("Password");
                            try {
                                boolean sentEmail = selectedStudent.sendCommentEmail(newCommentToAdd, email, password);
                                if (sentEmail) {
                                    System.out.println("Email has been successfully sent to " + selectedStudent.getName());
                                }
                            } catch (Exception e) {
                                System.out.println("Email failed to send: " + e.toString());
                            }
                        }else{
                            return;
                        }
                        results.get(index - 1).updateTimestamp();
                    }
                }
            }
        }
    }

    private void editAtRisk() {
        System.out.println("The selected student is" + (selectedStudent.getRiskLevel() > 0 ? " " : " not ") + "currently at risk");
        Boolean edit = getBoolean("Would you like to change their status?");
        if (edit != null && edit) {
            Integer riskLevel = getNumber("Risk level (0 for not at risk)");
            if (riskLevel == null) {
                selectedStudentActions();
                return;
            }

            String riskReason = null;
            if (riskLevel > 0) {
                riskReason = getInput("Reason/advice given");
                if (riskReason == null) {
                    selectedStudentActions();
                    return;
                }
            }

            selectedStudent.setRiskLevel(riskLevel);
            selectedStudent.setRiskReasonAndAdvice(riskReason);
            System.out.println("Risk level saved");
        }
        selectedStudentActions();
    }

    private void editStudent() {
        String[] options = new String[] {"Add course", "Add exemption", "Add transfer", "Add internship", "Load predefined structure", "Exit edit mode"};
        int choice = getChoice(options);
        if (choice == 0 || choice == 1) {
            // Course/Exemption
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

            String semester = getInput("Semester");
            if (semester== null) {
                editStudent();
                return;
            }

            String[] prerequisitesString = null;
            Boolean hasPrerequisites = getBoolean("Are there any prerequisites?");
            if (hasPrerequisites == null) {
                editStudent();
                return;
            } else if (hasPrerequisites) {
                prerequisitesString = getList("Prerequisites course codes");
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

            Course newCourse = new Course(courseCode, courseName, semester, currentUser, prerequisitesString, startDate, isCompleted, endDate, choice == 1);
            selectedStudent.getProgramStructure().addCategory(newCourse);
            editStudent();
        } else if (choice == 2) {
            // Transfer
            String fromProgram = getInput("Transferred from (program code)");
            if (fromProgram == null) {
                editStudent();
                return;
            }

            String toProgram = getInput("Transferred to (program code)");
            if (toProgram == null) {
                editStudent();
                return;
            }

            Date startDate = getDate("Start date");
            if (startDate == null) {
                editStudent();
                return;
            }

            Date endDate = null;

            Boolean isCompleted = getBoolean("Transfer completed?");
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

            Transfer newTransfer = new Transfer(fromProgram, toProgram, startDate, isCompleted, endDate, currentUser);
            selectedStudent.getProgramStructure().addCategory(newTransfer);
            editStudent();
        } else if (choice == 3) {
            // Internship
            Boolean hasInternship = getBoolean("Has the student got an internship?");
            if (hasInternship == null) {
                editStudent();
            } else if (hasInternship) {
                String company = getInput("Company");
                if (company == null) {
                    editStudent();
                    return;
                }

                Date startDate = getDate("Start date");
                if (startDate == null) {
                    editStudent();
                    return;
                }

                Date endDate = null;

                Boolean isCompleted = getBoolean("Internship completed?");
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

                String contactPerson = getInput("Contact person");
                if (contactPerson == null) {
                    editStudent();
                    return;
                }

                Internship newInternship = new Internship(company, startDate, isCompleted, endDate, contactPerson, currentUser);
                selectedStudent.getProgramStructure().addCategory(newInternship);
                editStudent();
            } else {
                String advice = getInput("Advice given");
                if (advice == null) {
                    editStudent();
                    return;
                }

                Internship newInternship = new Internship(advice, currentUser);
                selectedStudent.getProgramStructure().addCategory(newInternship);
                editStudent();
            }
        } else if (choice == 4) {
            // Load structure
            System.out.println("Choose a predefined program structure to load");
            String[] courses = new String[] {"Bachelor of Software Engineering", "Cancel"};
            int course = getChoice(courses);
            if (course == 0) {
                // Staff
                Staff jamesHarland = new Staff("e11111","Harland", "James","12 Address St, Suburb", "5555555555", "james.harland@rmit.edu.au", "SEH", "Assoc. Prof.", 2);
                Staff philVines = new Staff("e11112","Vines", "Phil","12 Address St, Suburb", "5555555555", "phil.vines@rmit.edu.au", "SEH", "Dr", 2);
                Staff shekharKalra = new Staff("e11113","Kalra", "Shekhar","12 Address St, Suburb", "5555555555", "shekhar.kalra@rmit.edu.au", "SEH", "", 2);
                Staff floraSalim = new Staff("e11114","Salim", "Flora","12 Address St, Suburb", "5555555555", "flora.salim@rmit.edu.au", "SEH", "Dr", 2);
                Staff ibrahimKhalil = new Staff("e11115","Khalil", "Ibrahim","12 Address St, Suburb", "5555555555", "ibrahim.khalil@rmit.edu.au", "SEH", "Assoc. Prof.", 2);
                Staff casparRyan = new Staff("e11116","Ryan", "Caspar","12 Address St, Suburb", "5555555555", "caspar.ryan@rmit.edu.au", "SEH", "Dr", 2);
                Staff jennyZhang = new Staff("e11117","Zhang", "Jenny","12 Address St, Suburb", "5555555555", "jenny.zhang@rmit.edu.au", "SEH", "Assoc. Prof.", 2);
                Staff sebastianSardina = new Staff("e11118","Sardina", "Sebastian","12 Address St, Suburb", "5555555555", "sebastian.sardina@rmit.edu.au", "SEH", "Dr", 2);
                Staff charlesThevathayan = new Staff("e11119","Thevathayan", "Charles","12 Address St, Suburb", "5555555555", "charles.thevathayan@rmit.edu.au", "SEH", "Dr", 2);
                Staff timothyWiley = new Staff("e11121","Wiley", "Timothy","12 Address St, Suburb", "5555555555", "timothy.wiley@rmit.edu.au", "SEH", "Dr", 2);
                Staff lawrenceCavedon = new Staff("e11122","Cavedon", "Lawrence","12 Address St, Suburb", "5555555555", "lawrence.cavedon@rmit.edu.au", "SEH", "Assoc. Prof.", 2);
                Staff jeffreyChan = new Staff("e11123","Chan", "Jeffrey","12 Address St, Suburb", "5555555555", "jeffrey.chan@rmit.edu.au", "SEH", "Dr", 2);
                Staff keDeng = new Staff("e11124","Deng", "Ke","12 Address St, Suburb", "5555555555", "ke.deng@rmit.edu.au", "SEH", "Dr", 2);
                Staff margaretHamilton = new Staff("e11125","Hamilton", "Margaret","12 Address St, Suburb", "5555555555", "margaret.hamilton@rmit.edu.au", "SEH", "Assoc. Prof.", 2);
                Staff bartiMurugesan = new Staff("e11126","Murugesan", "Barti","12 Address St, Suburb", "5555555555", "barti.murugesan@rmit.edu.au", "SEH", "", 2);
                storage.addUsers(new Staff[] {
                        jamesHarland, philVines, shekharKalra, floraSalim, ibrahimKhalil,
                        casparRyan, jennyZhang, sebastianSardina, charlesThevathayan, timothyWiley,
                        lawrenceCavedon, jeffreyChan, keDeng, margaretHamilton, bartiMurugesan
                });
                Date d = new Date();

                // Year 1
                selectedStudent.getProgramStructure().addCategory(new Course("COSC2627", "Discrete Structures in Computing", "1", jamesHarland, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("COSC2473", "Introduction to Computer Systems", "1", philVines, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("COSC1284", "Programming Techniques", "1", shekharKalra, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("COSC2628", "User-centred Design", "1", floraSalim, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("COSC2536", "Security in Computing and Information Technology", "2", ibrahimKhalil, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("COSC2391", "Further Programming", "2", casparRyan, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("ISYS1057", "Database Concepts", "2", jennyZhang, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("COSC2758", "Further Web Programming", "2", charlesThevathayan, d, false, null, false));
                // Year2
                selectedStudent.getProgramStructure().addCategory(new Course("COSC1107", "Computing Theory", "1", sebastianSardina, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("ISYS1118", "Software Engineering Fundamentals", "1", charlesThevathayan, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("COSC1076", "Advanced Programming Techniques", "1", timothyWiley, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("COSC2299", "Software Engineering: Process and Tools", "1", lawrenceCavedon, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("COSC2123", "Algorithms and Analysis", "2", jeffreyChan, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("COSC1114", "Operating Systems Principles", "2", keDeng, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("COSC1147", "Professional Computing Practice", "2", margaretHamilton, d, false, null, false));
                // Year3
                selectedStudent.getProgramStructure().addCategory(new Internship("INTE2376: Approved Industry Experience 1", bartiMurugesan));
                selectedStudent.getProgramStructure().addCategory(new Internship("INTE2377, Approved Industry Experience 2", bartiMurugesan));
                selectedStudent.getProgramStructure().addCategory(new Course("INTE2374", "Software Engineering Principles and Practice 1", "", bartiMurugesan, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("INTE2375", "Software Engineering Principles and Practice 2", "", bartiMurugesan, d, false, null, false));
                // Year 4
                selectedStudent.getProgramStructure().addCategory(new Course("ISYS1084", "Object Oriented Software Design", "1", lawrenceCavedon, d, false, null, false));
                selectedStudent.getProgramStructure().addCategory(new Course("COSC2410", "Software Engineering Project", "2", bartiMurugesan, d, false, null, false));

                editStudent();
            } else {
                editStudent();
            }
        } else if (choice == 5) {
            System.out.println("\n" + selectedStudent.toString());
            selectedStudentActions();
        }
    }
}
