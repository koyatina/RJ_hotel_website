import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String enrollmentNumber;
    private String firstName;
    private String lastName;
    private int semester;
    private String contactNumber;

    public Student(String enrollmentNumber, String firstName, String lastName, int semester, String contactNumber) {
        this.enrollmentNumber = enrollmentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.semester = semester;
        this.contactNumber = contactNumber;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}

class StudentManagementSystem {
        public static void main(String[] args) {
            StudentManagementSystem sms = new StudentManagementSystem();
            Scanner scanner = new Scanner(System.in);
            int choice;
    
            do {
                sms.displayMenu();
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
    
                switch (choice) {
                    case 1:
                        sms.addStudent();
                        break;
                    case 2:
                        sms.viewStudent();
                        break;
                    case 3:
                        sms.updateStudent();
                        break;
                    case 4:
                        sms.deleteStudent();
                        break;
                    case 5:
                        sms.exitProgram();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 5);
            
            scanner.close();
        }
       
        
    
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Add Student");
        System.out.println("2. View Student");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
    }

    public void addStudent() {
        System.out.println("Enter enrollment number: ");
        String enrollmentNumber = scanner.nextLine();
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter semester: ");
        int semester = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter contact number: ");
        String contactNumber = scanner.nextLine();

        Student student = new Student(enrollmentNumber, firstName, lastName, semester, contactNumber);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void viewStudent() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("Enrollment Number\tFirst Name\tLast Name\tSemester\tContact Number");
        for (Student student : students) {
            System.out.println(student.getEnrollmentNumber() + "\t\t\t" + student.getFirstName() + "\t\t" +
                    student.getLastName() + "\t\t" + student.getSemester() + "\t\t" + student.getContactNumber());
        }
    }

    public void updateStudent() {
        System.out.println("Enter enrollment number of the student to update: ");
        String enrollmentNumber = scanner.nextLine();
    
        boolean found = false;
        for (Student student : students) {
            if (student.getEnrollmentNumber().equals(enrollmentNumber)) {
                System.out.println("Enter new first name: ");
                String firstName = scanner.nextLine();
                System.out.println("Enter new last name: ");
                String lastName = scanner.nextLine();
                System.out.println("Enter new semester: ");
                int semester = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new contact number: ");
                String contactNumber = scanner.nextLine();
    
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setSemester(semester);
                student.setContactNumber(contactNumber);
    
                System.out.println("Student information updated successfully.");
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Student not found.");
        }
    }
    public void deleteStudent() {
        System.out.println("Enter enrollment number of the student to delete: ");
        String enrollmentNumber = scanner.nextLine();
    
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getEnrollmentNumber().equals(enrollmentNumber)) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Student not found.");
        }
    
    }
    
    public void exitProgram() {
        System.out.println("Exiting the program... Goodbye!");
        System.exit(0);
    }
} 
