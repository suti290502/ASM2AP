package service;

import entity.Teacher;
import interfaces.UpdateInfoRequest;

public class AdminService implements UpdateInfoRequest {
    public TeacherService teacherService;
    public AdminService(TeacherService teacherService){
        this.teacherService = teacherService;
    }
    @Override
    public void updateInfoTeacher(Teacher teacher) {
        teacherService.update(teacher);
    }
}
