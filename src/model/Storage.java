package model;

import model.interfaces.StorageInt;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import org.json.*;

public class Storage implements StorageInt {

    private List<Staff> staff = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    // Load the data from the database
    public void loadData(boolean test) {
        if (test) {
            Staff testStaff1 = new Staff("e94145", "Kodikara", "Milindi", "10 Street, Suburb", "5555555555", "milindi.kodikara@rmit.edu.au", "Software Engineering", "Sessional Tutor", 0);
            Staff testStaff2 = new Staff("e12345", "Thevethayan", "Charles", "10 Street, Suburb", "5555555555", "charles.thevethayan@rmit.edu.au", "Software Engineering", "Lecturer", 3);
            staff.add(testStaff1);
            staff.add(testStaff2);

            Student testStudent = new Student("s1234", "Stark", "Samantha", "10 Street, Suburb", "5555555555", "s1234@student.rmit.edu.au");
            testStudent.getProgramStructure().addCategory(new Course("ABC123", "Software Engineering Fundamentals", "1", testStaff1, null, new Date(), false, null, false));
            testStudent.setRiskLevel(2);
            testStudent.setRiskReasonAndAdvice("Example advice");
            students.add(testStudent);

            System.out.println("Test data loaded");
        } else {
            JSONObject json = null;
            File f = new File("data.json");
            if (f.exists()) {
                try {
                    InputStream in = new FileInputStream("data.json");
                    Scanner s = new Scanner(in).useDelimiter("\\A");
                    String jsonTxt = s.hasNext() ? s.next() : "";
                    json = new JSONObject(jsonTxt);
                } catch (Exception e) {
                    System.out.println("Error while loading data");
                }
            }

            if (json != null) {
                try {
                    JSONArray staffJSON = json.getJSONArray("staff");
                    for (int i = 0; i < staffJSON.length(); i++) {
                        Staff s = new Staff(
                                staffJSON.getJSONObject(i).getString("userID"),
                                staffJSON.getJSONObject(i).getString("famName"),
                                staffJSON.getJSONObject(i).getString("givenName"),
                                staffJSON.getJSONObject(i).getString("address"),
                                staffJSON.getJSONObject(i).getString("phoneNo"),
                                staffJSON.getJSONObject(i).getString("email"),
                                staffJSON.getJSONObject(i).getString("department"),
                                staffJSON.getJSONObject(i).getString("staffTitle"),
                                staffJSON.getJSONObject(i).getInt("authority")
                        );
                        staff.add(s);
                    }

                    JSONArray studentsJSON = json.getJSONArray("students");
                    for (int i = 0; i < studentsJSON.length(); i++) {
                        Student s = new Student(
                                studentsJSON.getJSONObject(i).getString("userID"),
                                studentsJSON.getJSONObject(i).getString("famName"),
                                studentsJSON.getJSONObject(i).getString("givenName"),
                                studentsJSON.getJSONObject(i).getString("address"),
                                studentsJSON.getJSONObject(i).getString("phoneNo"),
                                studentsJSON.getJSONObject(i).getString("email")
                        );
                        s.setRiskLevel(studentsJSON.getJSONObject(i).getInt("riskLevel"));
                        s.setRiskReasonAndAdvice(studentsJSON.getJSONObject(i).getString("riskReason"));

                        // Structure
                        JSONObject structureJSON = studentsJSON.getJSONObject(i).getJSONObject("structure");
                        Iterator<String> keys = structureJSON.keys();
                        while (keys.hasNext()) {
                            String key = keys.next();
                            if (structureJSON.get(key) instanceof JSONObject) {
                                AbstractCategory cat = null;
                                if (key.equals(Course.class.getSimpleName())) {
                                    // Course object

                                    // Prerequisites
                                    JSONArray prerequisitesJSON = ((JSONObject) structureJSON.get(key)).getJSONArray("prerequisites");
                                    String[] prerequisites = null;
                                    if (prerequisitesJSON != null) {
                                        prerequisites = new String[prerequisitesJSON.length()];
                                        for (int j = 0; j < prerequisitesJSON.length(); j++) {
                                            prerequisites[j] = prerequisitesJSON.getString(j);
                                        }
                                    }

                                    Date endDate = null;
                                    if (((JSONObject) structureJSON.get(key)).has("endDate"))
                                        endDate = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", new Locale("us")).parse(((JSONObject) structureJSON.get(key)).getString("endDate"));
                                    cat = new Course(
                                            ((JSONObject) structureJSON.get(key)).getString("courseCode"),
                                            ((JSONObject) structureJSON.get(key)).getString("courseName"),
                                            ((JSONObject) structureJSON.get(key)).getString("semester"),
                                            getUser(((JSONObject) structureJSON.get(key)).getString("staff")),
                                            prerequisites,
                                            new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", new Locale("us")).parse(((JSONObject) structureJSON.get(key)).getString("startDate")),
                                            ((JSONObject) structureJSON.get(key)).getBoolean("isCompleted"),
                                            endDate,
                                            ((JSONObject) structureJSON.get(key)).getBoolean("isExemption")
                                    );
                                    s.getProgramStructure().addCategory(cat);
                                } else if (key.equals(Internship.class.getSimpleName())) {
                                    // Internship object
                                    if (((JSONObject) structureJSON.get(key)).getBoolean("gainedInternship")) {
                                        Date endDate = null;
                                        if (((JSONObject) structureJSON.get(key)).has("endDate"))
                                            endDate = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", new Locale("us")).parse(((JSONObject) structureJSON.get(key)).getString("endDate"));
                                        cat = new Internship(
                                                ((JSONObject) structureJSON.get(key)).getString("company"),
                                                new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", new Locale("us")).parse(((JSONObject) structureJSON.get(key)).getString("startDate")),
                                                ((JSONObject) structureJSON.get(key)).getBoolean("isCompleted"),
                                                endDate,
                                                ((JSONObject) structureJSON.get(key)).getString("contactPerson"),
                                                getUser(((JSONObject) structureJSON.get(key)).getString("staff"))
                                        );
                                    } else {
                                        cat = new Internship(
                                                null,
                                                getUser(((JSONObject) structureJSON.get(key)).getString("staff"))
                                        );
                                    }
                                    s.getProgramStructure().addCategory(cat);
                                } else if (key.equals(Transfer.class.getSimpleName())) {
                                    // Transfer object
                                    Date endDate = null;
                                    if (((JSONObject) structureJSON.get(key)).has("endDate"))
                                        endDate = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", new Locale("us")).parse(((JSONObject) structureJSON.get(key)).getString("endDate"));
                                    cat = new Transfer(
                                            ((JSONObject) structureJSON.get(key)).getString("fromProgram"),
                                            ((JSONObject) structureJSON.get(key)).getString("toProgram"),
                                            new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", new Locale("us")).parse(((JSONObject) structureJSON.get(key)).getString("startDate")),
                                            ((JSONObject) structureJSON.get(key)).getBoolean("isCompleted"),
                                            endDate,
                                            getUser(((JSONObject) structureJSON.get(key)).getString("staff"))
                                    );
                                    s.getProgramStructure().addCategory(cat);
                                } else {
                                    System.out.println("Error loading category, unknown type");
                                }
                                if (cat != null) {
                                    cat.setTimestamp(new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", new Locale("us")).parse(((JSONObject) structureJSON.get(key)).getString("lastEditTimestamp")));

                                    // Comments
                                    JSONArray commentsJSON = ((JSONObject) structureJSON.get(key)).getJSONArray("comments");
                                    for (int j = 0; j < commentsJSON.length(); j++) {
                                        Comment c = new Comment(
                                                commentsJSON.getJSONObject(j).getString("comment"),
                                                getUser(((JSONObject) structureJSON.get(key)).getString("author")),
                                                new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", new Locale("us")).parse(commentsJSON.getJSONObject(j).getString("date"))
                                        );
                                        cat.addComment(c);
                                    }
                                }
                            }
                        }
                        students.add(s);
                    }
                } catch (Exception e) {
                    System.out.println("Error while reading JSON");
                    e.printStackTrace();
                }
            } else {
                System.out.println("No data loaded");
            }
        }
    }

    // Store the data in the database
    public boolean saveData() {
        JSONObject o = new JSONObject();

        JSONArray staffJson = new JSONArray();
        for (Staff s : staff) {
            JSONObject sJson = new JSONObject();
            sJson.put("userID", s.getID());
            sJson.put("famName", s.getFamName());
            sJson.put("givenName", s.getGivenName());
            sJson.put("address", s.getAddress());
            sJson.put("phoneNo", s.getPhone());
            sJson.put("email", s.getEmail());
            sJson.put("department", s.getDepartment());
            sJson.put("staffTitle", s.getStaffTitle());
            sJson.put("authority", s.authorityAccess());
            staffJson.put(sJson);
        }
        o.put("staff", staffJson);

        JSONArray studentsJSON = new JSONArray();
        for (Student s : students) {
            JSONObject studentJSON = new JSONObject();
            studentJSON.put("userID", s.getID());
            studentJSON.put("famName", s.getFamName());
            studentJSON.put("givenName", s.getGivenName());
            studentJSON.put("address", s.getAddress());
            studentJSON.put("phoneNo", s.getPhone());
            studentJSON.put("email", s.getEmail());
            studentJSON.put("riskLevel", s.getRiskLevel());
            studentJSON.put("riskReason", s.getRiskReasonAndAdvice());

            // Program structure
            JSONObject structureJSON = new JSONObject();
            for (AbstractCategory c : s.getProgramStructure().getCategories()) {
                JSONObject catJSON = new JSONObject();
                catJSON.put("staff", c.getStaff().getID());
                catJSON.put("startDate", c.startDate);
                catJSON.put("isCompleted", c.isCompleted);
                catJSON.put("endDate", c.endDate);
                catJSON.put("lastEditTimestamp", c.lastEditTimestamp);

                // Comments
                JSONArray commentsJSON = new JSONArray();
                for (Comment com : c.getCommentList()) {
                    JSONObject commentJSON = new JSONObject();
                    commentJSON.put("comment", com.getComment());
                    commentJSON.put("author", com.getAuthor().getID());
                    commentJSON.put("date", com.getDate());
                    commentsJSON.put(commentJSON);
                }
                catJSON.put("comments", commentsJSON);

                // Specific
                if (c instanceof Course) {
                    // Course object
                    catJSON.put("courseCode", ((Course) c).getCourseCode());
                    catJSON.put("courseName", ((Course) c).getCourseName());
                    catJSON.put("semester", ((Course) c).getSemester());

                    // Prerequisites
                    JSONArray prerequisitesJSON = new JSONArray();
                    if (((Course) c).getPrerequisiteArray() != null) {
                        for (String pre : ((Course) c).getPrerequisiteArray()) {
                            prerequisitesJSON.put(pre);
                        }
                    }
                    catJSON.put("prerequisites", prerequisitesJSON);

                    catJSON.put("isExemption", ((Course) c).getExemption());
                } else if (c instanceof Internship) {
                    // Internship object
                    catJSON.put("company", ((Internship) c).getCompany());
                    catJSON.put("contactPerson", ((Internship) c).getContactPerson());
                    catJSON.put("gainedInternship", ((Internship) c).getGainedInternship());
                } else if (c instanceof Transfer) {
                    // Transfer object
                    catJSON.put("fromProgram", ((Transfer) c).getFromProgram());
                    catJSON.put("toProgram", ((Transfer) c).getToProgram());
                } else {
                    System.out.println("Failed to save one or more categories (unrecognised format)");
                }
                structureJSON.put(c.getClass().getSimpleName(), catJSON);
            }
            studentJSON.put("structure", structureJSON);

            studentsJSON.put(studentJSON);
        }

        o.put("students", studentsJSON);

        try (PrintStream out = new PrintStream(new FileOutputStream("data.json"))) {
            out.print(o);
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    // Authenticate a staff member by id and password
    public Staff authUser(String staffId, String pass) {
        return staff.stream()
                .filter(staff -> staffId.equalsIgnoreCase(staff.getID()))
                .findAny()
                .orElse(null);
    }

    // Register a new staff member
    public Staff addUser(String staffId, String given, String family, String address, String phone, String department, String jobTitle, int authority, String pass) {
        Staff newUser = new Staff(staffId, family, given, address, phone, staffId + "@rmit.edu.au", department, jobTitle, authority);
        staff.add(newUser);
        return newUser;
    }

    // Get a staff member by id
    public Staff getUser(String staffId) {
        return staff.stream()
                .filter(staff -> staffId.equalsIgnoreCase(staff.getID()))
                .findAny()
                .orElse(null);
    }

    // Retrieve a student by student number
    public Student getStudent(String id) {
        return students.stream()
                .filter(student -> id.equalsIgnoreCase(student.getID()))
                .findAny()
                .orElse(null);
    }

    // Add a new student
    public Student addStudent(String id, String given, String family, String address, String phone) {
        Student newStudent = new Student(id, family, given, address, phone, id + "@student.rmit.edu.au");
        students.add(newStudent);
        return newStudent;
    }

    // Return list of at risk students
    public List<Student> getAtRiskStudents() {
        return students.stream()
                .filter(student -> student.getRiskLevel() > 0)
                .collect(Collectors.toList());
    }
}
