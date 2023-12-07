package service;

import entity.Teacher;
import interfaces.TeacherInterface;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements TeacherInterface {
    // Singleton - Design Pattern
    private static TeacherService instance = null;
    private List<Teacher> teachers;
    TeacherService() {
        teachers = new ArrayList<>();
       }
    public static synchronized TeacherService getInstance() {
        if (instance == null) {
            instance = new TeacherService();
        }
        return instance;
    }
    //Singleton:
    // trong 1 luong du lieu  đảm bảo chi cho phep 1 doi tuong duoc khoi tao
    @Override
    public Teacher insert(Teacher teacher) {

        int newId = getNextAvailableId();
        teacher.setId(newId);
        teachers.add(teacher);
        return teacher;
    }

    @Override
    public Teacher update(Teacher teacher) {

        for (Teacher existingTeacher : teachers) {
            if (existingTeacher.getId() == teacher.getId()) {
                // Update the Teacher details
                existingTeacher.setName(teacher.getName());
                existingTeacher.setAddress(teacher.getAddress());
                existingTeacher.setPhone(teacher.getPhone());
                existingTeacher.setPersonId(teacher.getPersonId());
                existingTeacher.setBirthDay(teacher.getBirthDay());
                existingTeacher.setEmail(teacher.getEmail());
                existingTeacher.setTeacherCode(teacher.getTeacherCode());
                existingTeacher.setSalaryLevel(teacher.getSalaryLevel());
                existingTeacher.setMaxDegree(teacher.getMaxDegree());
                existingTeacher.setMajor(teacher.getMajor());
                existingTeacher.setTaxCode(teacher.getTaxCode());
                existingTeacher.setInsuranceCode(teacher.getInsuranceCode());
                existingTeacher.setSalary(teacher.getSalary());
                return existingTeacher;
            }
        }
        return null; // Return null if the Teacher with the given ID is not found
    }

    @Override
    public boolean delete(int id) {

        for (Teacher existingTeacher : teachers) {
            if (existingTeacher.getId() == id) {
                teachers.remove(existingTeacher);
                return true; // Return true if deletion is successful
            }
        }
        return false; // Return false if the Teacher with the given ID is not found
    }

    @Override
    public List<Teacher> findAll() {
        // Return the list of teachers
        return teachers;
    }

    @Override
    public Teacher findById(int id) {
        // Add your implementation for finding a Teacher by ID in the database or data source
        // Example: Find the Teacher with the given ID
        for (Teacher existingTeacher : teachers) {
            if (existingTeacher.getId() == id) {
                return existingTeacher;
            }
        }
        return null; // Return null if the Teacher with the given ID is not found
    }

    // Helper method to simulate auto-incrementing IDs (replace with database-generated IDs)
    private int getNextAvailableId() {
        int maxId = 0;
        for (Teacher existingTeacher : teachers) {
            maxId = Math.max(maxId, existingTeacher.getId());
        }
        return maxId + 1;
    }
}
