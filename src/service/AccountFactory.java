package service;

import entity.Parent;
import entity.Student;
import entity.Teacher;
import interfaces.NotifyInterface;

public class AccountFactory {
    public static NotifyInterface createNotification(String type){
        if (type.equals("Student")) {
            return new Student();
        } else if (type.equals("Teacher")) {
            return new Teacher();
        }else if(type.equals("Parent")){
            return new Parent();
        }
        throw new IllegalArgumentException("Invalid product type.");
    }
}
