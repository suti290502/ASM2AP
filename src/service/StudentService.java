package service;

import entity.Student;
import interfaces.StudentInterface;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentInterface {
    private static StudentService instance = null;
    private List<Student> students;
    private StudentService() {
        students = new ArrayList<>();
        }
    public static synchronized StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

    @Override
    public Student insert(Student s) {
        // Add your implementation for inserting a student into the database or data source
        // Example: Assume the student has an auto-generated ID from the database
        int newId = getNextAvailableId();
        s.setId(newId);
        students.add(s);
        return s;
    }

    @Override
    public Student update(Student s) {

        for (Student existingStudent : students) {
            if (existingStudent.getId() == s.getId()) {
                // Update the student details
                existingStudent.setName(s.getName());
                existingStudent.setAddress(s.getAddress());
                existingStudent.setPhone(s.getPhone());
                existingStudent.setPersonId(s.getPersonId());
                existingStudent.setBirthDay(s.getBirthDay());
                existingStudent.setEmail(s.getEmail());
                existingStudent.setParentID(s.getParentID());
                existingStudent.setStudentCode(s.getStudentCode());
                existingStudent.setGroupCode(s.getGroupCode());
                existingStudent.setGpa(s.getGpa());
                return existingStudent;
            }
        }
        return null; // Return null if the student with the given ID is not found
    }

    @Override
    public boolean delete(int id) {
        // Add your implementation for deleting a student from the database or data source
        // Example: Delete the student with the given ID
        for (Student existingStudent : students) {
            if (existingStudent.getId() == id) {
                students.remove(existingStudent);
                return true; // Return true if deletion is successful
            }
        }
        return false; // Return false if the student with the given ID is not found
    }

    @Override
    public List<Student> findAll() {
        // Return the list of students
        return students;
    }

    @Override
    public Student findById(int id) {
        // Add your implementation for finding a student by ID in the database or data source
        // Example: Find the student with the given ID
        for (Student existingStudent : students) {
            if (existingStudent.getId() == id) {
                return existingStudent;
            }
        }
        return null; // Return null if the student with the given ID is not found
    }

    // Helper method to simulate auto-incrementing IDs (replace with database-generated IDs)
    private int getNextAvailableId() {
        int maxId = 0;
        for (Student existingStudent : students) {
            maxId = Math.max(maxId, existingStudent.getId());
        }
        return maxId + 1;
    }
}
