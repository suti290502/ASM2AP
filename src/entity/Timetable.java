package entity;

import java.util.List;



public class Timetable {
    private int id;
    private List<Course> courses;


    public Timetable() {
    }

    public Timetable(int id, List<Course> courses) {
        this.id = id;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}


