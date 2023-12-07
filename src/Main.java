import entity.Student;
import entity.Teacher;
import entity.Course;

import entity.Timetable;
import service.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Singleton - Creational
        StudentService studentService = StudentService.getInstance();
        TeacherService teacherService = TeacherService.getInstance();
        CourseService courseService = CourseService.getInstance();
        TimetableService timetableService = TimetableService.getInstance();


        AdminService adminService = new AdminService(teacherService);

        // Main menu loop
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Teachers");
            System.out.println("3. Manage Courses");
            System.out.println("4. Manage Timetable");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageStudents(scanner, studentService);
                    break;
                case 2:
                    manageTeachers(scanner, teacherService);
                    break;
                case 3:

                    manageCourses(scanner, courseService);
                    break;
                case 4:

                    manageTimetables(scanner, timetableService);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void manageStudents(Scanner scanner, StudentService studentService) {
        System.out.println("Student Management:");
        System.out.println("1. Insert Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. View All Students");
        System.out.println("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Insert Student
                System.out.println("Enter student details:");

                System.out.print("1");
                String name1 = scanner.nextLine();
                System.out.print("Name: ");
                String name = scanner.nextLine(); // Consume the newline character
                System.out.print("Address: ");
                String address = scanner.nextLine();
                System.out.print("Phone: ");
                String phone = scanner.nextLine();
                System.out.print("Person ID: ");
                String personId = scanner.nextLine();
                System.out.print("Birth Day (yyyy-MM-dd): ");
                String birthDayStr = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Parent ID: ");
                int parentId = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                System.out.print("Student Code: ");
                String studentCode = scanner.nextLine();
                System.out.print("Group Code: ");
                String groupCode = scanner.nextLine();
                System.out.print("GPA: ");
                float gpa = scanner.nextFloat();

                Student newStudent = new Student(0, name, address, phone, personId,
                        Date.valueOf(birthDayStr), email, parentId, studentCode, groupCode, gpa);
                studentService.insert(newStudent);
                System.out.println("Student inserted successfully!");
                break;
            case 2:
                // Update Student
                System.out.println("Enter student ID to update: ");
                int studentIdToUpdate = scanner.nextInt();
                scanner.nextLine();
                Student studentToUpdate = studentService.findById(studentIdToUpdate);
                if (studentToUpdate != null) {
                    // Update student details, e.g., name, GPA
                    System.out.println("Enter updated details for student:");
                    System.out.println("Name: ");
                    studentToUpdate.setName(scanner.nextLine());
                    System.out.println("Address: ");
                    studentToUpdate.setAddress(scanner.nextLine());
                    System.out.println("PersonId: ");
                    studentToUpdate.setPersonId(scanner.nextLine());
                    System.out.println("Phone: ");
                    studentToUpdate.setPhone(scanner.nextLine());
                    System.out.println("BirthDay: ");
                    studentToUpdate.setBirthDay(new Date(System.currentTimeMillis()));
                    System.out.println("ParentID: ");
                    studentToUpdate.setParentID(scanner.nextLine());
                    System.out.println("StudentCode: ");
                    studentToUpdate.setStudentCode(scanner.nextLine());
                    System.out.println("GroupCode: ");
                    studentToUpdate.setGroupCode(scanner.nextLine());
                    System.out.println("Gpa: ");
                    studentToUpdate.setGpa(scanner.nextLine());

                    // Add other input prompts as needed
                    studentService.update(studentToUpdate);
                    System.out.println("Student updated successfully!");
                } else {
                    System.out.println("Student not found!");
                }
                break;
            case 3:
                // Delete Student
                System.out.println("Enter student ID to delete: ");
                int studentIdToDelete = scanner.nextInt();
                if (studentService.delete(studentIdToDelete)) {
                    System.out.println("Student deleted successfully!");
                } else {
                    System.out.println("Student not found!");
                }

                break;
            case 4:
                viewAllStudents(studentService);
                break;

            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private static void manageTeachers(Scanner scanner, TeacherService teacherService) {
        System.out.println("Teacher Management:");
        System.out.println("1. Insert Teacher");
        System.out.println("2. Update Teacher");
        System.out.println("3. Delete Teacher");
        System.out.println("4. View All Teachers");
        System.out.println("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:

                System.out.println("Enter student details:");

                System.out.print("1");
                String name1 = scanner.nextLine();
                System.out.print("Name: ");
                String name = scanner.nextLine(); // Consume the newline character
                System.out.print("Address: ");
                String address = scanner.nextLine();
                System.out.print("Phone: ");
                String phone = scanner.nextLine();
                System.out.print("Person ID: ");
                String personId = scanner.nextLine();
                System.out.println("Birth Day (yyyy-MM-dd): ");
                String birthDayStr = scanner.next();
                System.out.println("Email: ");
                String email = scanner.next();
                System.out.println("Teacher Code: ");
                String teacherCode = scanner.next();
                System.out.println("Salary Level: ");
                int salaryLevel = scanner.nextInt();
                System.out.println("Max Degree: ");
                String maxDegree = scanner.next();
                System.out.println("Major: ");
                String major = scanner.next();
                System.out.println("Tax Code: ");
                String taxCode = scanner.next();
                System.out.println("Insurance Code: ");
                String insuranceCode = scanner.next();
                System.out.println("Salary: ");
                double salary = scanner.nextDouble();

                Teacher newTeacher = new Teacher(0, name, address, phone, personId,
                        Date.valueOf(birthDayStr), email, teacherCode, salaryLevel,
                        maxDegree, major, taxCode, insuranceCode, salary);
                teacherService.insert(newTeacher);
                System.out.println("Teacher inserted successfully!");
                break;
            case 2:
                // Update Teacher
                System.out.println("Enter teacher ID to update: ");
                int teacherIdToUpdate = scanner.nextInt();
                Teacher teacherToUpdate = teacherService.findById(teacherIdToUpdate);
                if (teacherToUpdate != null) {
                    // Update teacher details, e.g., name, salary
                    System.out.println("Enter updated details for teacher:");
                    System.out.println("Name: ");
                    teacherToUpdate.setName(scanner.next());
                    // Add other input prompts as needed
                    teacherService.update(teacherToUpdate);
                    System.out.println("Teacher updated successfully!");
                } else {
                    System.out.println("Teacher not found!");
                }
                break;
            case 3:
                System.out.println("Enter teacher ID to delete: ");
                int teacherIdToDelete = scanner.nextInt();
                if (teacherService.delete(teacherIdToDelete)) {
                    System.out.println("Teacher deleted successfully!");
                } else {
                    System.out.println("Teacher not found!");
                }
                // Facade -- Structural
                FacadeService facadeService = new FacadeService();
                facadeService.operationDeleteTeacher(teacherIdToDelete);
                //Gói gọn các tất cả các hành động cos trong doi tuong
                //thưc hien tat ca cac hanh dong co trong doi tuong mot cach lan luot,
                //ko can gọi tung hanh dong

                break;
            case 5:
                viewAllTeachers(teacherService);
                break;

            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private static void manageCourses(Scanner scanner, CourseService courseService) {
        System.out.println("Course  Management:");
        System.out.println("1. Insert Course");
        System.out.println("2. Update Course");
        System.out.println("3. Delete Course");
        System.out.println("4. View All Courses");
        System.out.println("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Insert Course
                System.out.println("Enter course details:");

                System.out.print("Code: ");
                String code = scanner.next();
                System.out.print("Name: ");
                String name = scanner.nextLine(); // Consume the newline character
                System.out.print("Subject Code: ");
                String subjectCode = scanner.next();
                System.out.print("Start Date (yyyy-MM-dd): ");
                String startDateStr = scanner.next();
                System.out.print("End Date (yyyy-MM-dd): ");
                String endDateStr = scanner.next();

                // Additional details for Course
                System.out.print("Enter Teacher details:\n");
                System.out.print("Teacher Code: ");
                String teacherCode = scanner.next();
                System.out.print("Salary Level: ");
                int salaryLevel = scanner.nextInt();
                System.out.print("Max Degree: ");
                String maxDegree = scanner.next();
                System.out.print("Major: ");
                String major = scanner.next();
                System.out.print("Tax Code: ");
                String taxCode = scanner.next();
                System.out.print("Insurance Code: ");
                String insuranceCode = scanner.next();
                System.out.print("Salary: ");
                double salary = scanner.nextDouble();

                // Parse dates
                Date startDate = Date.valueOf(startDateStr);
                Date endDate = Date.valueOf(endDateStr);

                // Create a new Teacher object
                Teacher teacher = new Teacher(0, "", "", "", "", new Date(System.currentTimeMillis())
                        , "",
                        teacherCode, salaryLevel, maxDegree, major, taxCode, insuranceCode, salary);

                // Create a new Course object
                Course newCourse = new Course(0, code, subjectCode, name, startDate, endDate, teacher, null);

                // Insert the new course
                Course insertedCourse = courseService.insert(newCourse);

                if (insertedCourse != null) {
                    System.out.println("Course inserted successfully! Course ID: " + insertedCourse.getId());
                } else {
                    System.out.println("Course insertion failed.");
                }
                break;

            case 2:
                // Update Teacher
                System.out.println("Enter teacher ID to update: ");
                int courseIdToUpdate = scanner.nextInt();
                Course courseToUpdate = courseService.findById(courseIdToUpdate);
                if (courseToUpdate != null) {
                    // Update teacher details, e.g., name, salary
                    System.out.println("Enter updated details for teacher:");
                    System.out.println("Name: ");
                    courseToUpdate.setName(scanner.next());
                    // Add other input prompts as needed
                    courseService.update(courseToUpdate);
                    System.out.println("Teacher updated successfully!");
                } else {
                    System.out.println("Teacher not found!");
                }
                break;

            case 3:
                // Delete Teacher
                System.out.println("Enter teacher ID to delete: ");
                int courseIdToDelete = scanner.nextInt();
                if (courseService.delete(courseIdToDelete)) {
                    System.out.println("Course deleted successfully!");
                } else {
                    System.out.println("Course not found!");
                }
                break;
            case 6:
                viewAllCourses(courseService);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private static void viewAllStudents(StudentService studentService) {
        List<Student> students = studentService.findAll();
        System.out.println("All Students:");
//        System.out.println("ID   | Name                   | Address    | Phone      | Person ID   | Birth Day    | Email                | ParentID | Student Code | Group Code  | GPA ");
//        System.out.println("-----|------------------------|------------|------------|-------------|--------------|----------------------|----------|--------------|-------------|------");
        System.out.format("%-10s %-20s %-20s %-15s %-10s %-20s %-20s %-10s %-20s %-20s %-10s\n",
                "ID",
                "Name", "Address", "Phone", "PersonID", "BirthDay ", "Email", "ParentID", "StudentCode", "GroupCode", "GPA"
        );
        for (Student student : students) {
            System.out.format("%-10s %-20s %-20s %-15s %-10s %-20s %-20s %-10s %-20s %-20s %-10s",
                    student.getId(),
                    student.getName(), student.getAddress(), student.getPhone(), student.getPersonId(),
                    student.getBirthDay(), student.getEmail(), student.getPersonId(), student.getStudentCode(), student.getGroupCode(), student.getGpa()
            );
            System.out.println();
        }
    }

    private static void viewAllTeachers(TeacherService teacherService) {

        List<Teacher> teachers = teacherService.findAll();
        System.out.println("All Teachers:");
        System.out.println("ID   | Name                | Address    | Phone      | Person ID   | Birth Day    | Email                | Teacher Code | Salary Level | Max Degree | Major     | Tax Code        | Insurance Code  | Salary    ");
        System.out.println("-----|---------------------|------------|------------|-------------|--------------|----------------------|--------------|--------------|------------|-----------|-----------------|-----------------|-----------");
//        for (Teacher teacher : teachers) {
//            System.out.println(teacher);
//        }
        Iterator iterator = teachers.iterator();
        while (iterator.hasNext()) {
            Teacher teacher = (Teacher) iterator.next();
            System.out.println(teacher);
        }
        //Khởi tạo đối tượng Iterator
        // Sử dụng vòng lặp while kiểm tra nếu phần tử iterator tiếp theo neu ton tai
        // thi lay duoc giá tri ke tiep cua phan tu iterator
    }

    private static void viewAllCourses(CourseService courseService) {
        // Replace this loop with your actual code to display courses
        List<Course> courses = courseService.findAll();
        System.out.println("All Courses:");
        System.out.println("ID   | Code    | Subject Code  | Name                | Start Date   | End Date     | Teacher Name          | Student Count ");
        System.out.println("-----|---------|---------------|---------------------|--------------|--------------|-----------------------|---------------");
//        for (Course course : courses) {
//            System.out.printf("%-5s | %-7s | %-13s | %-20s | %-12s | %-12s | %-22s | %-13s%n",
//                    course.getId(), course.getCode(), course.getSubjectCode(), course.getName(),
//                    course.getStartDate(), course.getEndDate(), course.getTeacher().getName(),
//                    (course.getStudentList() != null) ? course.getStudentList().size() : 0);
//        }

        // Iterator - Behavioral
        Iterator iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course course = (Course) iterator.next();
            System.out.println(course);
        }

    }

    private static void manageTimetables(Scanner scanner, TimetableService timetableService) {
        System.out.println("Timetable Management:");
        System.out.println("1. Insert Timetable");
        System.out.println("2. Update Timetable");
        System.out.println("3. Delete Timetable");
        System.out.println("4. View All Timetables");
        System.out.println("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Insert Timetable
                System.out.println("Enter timetable details:");

                // Assuming you have a list of courses (you can get it from your CourseService)
                List<Course> listOfCourses = Arrays.asList(/* ... */);

                Timetable newTimetable = new Timetable(0, listOfCourses);
                timetableService.insert(newTimetable);
                System.out.println("Timetable inserted successfully!");
                break;
            case 2:
                // Update Timetable
                System.out.println("Enter timetable ID to update: ");
                int timetableIdToUpdate = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                Timetable timetableToUpdate = timetableService.findById(timetableIdToUpdate);
                if (timetableToUpdate != null) {
                    // Assuming you have a list of updated courses
                    List<Course> newListOfCourses = Arrays.asList(/* ... */);
                    timetableToUpdate.setCourses(newListOfCourses);
                    timetableService.update(timetableToUpdate);
                    System.out.println("Timetable updated successfully!");
                } else {
                    System.out.println("Timetable not found!");
                }
                break;
            case 3:
                // Delete Timetable
                System.out.println("Enter timetable ID to delete: ");
                int timetableIdToDelete = scanner.nextInt();
                if (timetableService.delete(timetableIdToDelete)) {
                    System.out.println("Timetable deleted successfully!");
                } else {
                    System.out.println("Timetable not found!");
                }
                break;
            case 4:
                // View All Timetables
                viewAllTimetables(timetableService);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private static void viewAllTimetables(TimetableService timetableService) {
        List<Timetable> timetables = timetableService.findAll();
        System.out.println("All Timetables:");
        System.out.println("ID   | Courses");
        System.out.println("-----|------------------------");
        for (Timetable timetable : timetables) {
            System.out.format("%-5s | %-20s%n", timetable.getId(), timetable.getCourses());
        }
    }
}
