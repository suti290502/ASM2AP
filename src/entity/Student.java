    package entity;

    import core.Person;
    import interfaces.NotifyInterface;

    import java.util.Date;

    public class  Student extends Person implements NotifyInterface {
        private int parentID;
        private String studentCode;
        private String groupCode;
        private float gpa;

        public Student(){

        }

        public Student(int id, String name){
            setId(id);
            setName(name);
        }

        public Student(int id, String name, String address, String phone,
                       String personId, Date birthDay, String email,
                       int parentID, String studentCode, String groupCode, float gpa) {
            super(id, name, address, phone, personId, birthDay, email);
            this.parentID = parentID;
            this.studentCode = studentCode;
            this.groupCode = groupCode;
            this.gpa = gpa;
        }

        public int getParentID() {
            return parentID;
        }

        public void setParentID(int parentID) {
            this.parentID = parentID;
        }

        public String getStudentCode() {
            return studentCode;
        }

        public void setStudentCode(String studentCode) {
            this.studentCode = studentCode;
        }

        public String getGroupCode() {
            return groupCode;
        }

        public void setGroupCode(String groupCode) {
            this.groupCode = groupCode;
        }

        public float getGpa() {
            return gpa;
        }

        public void setGpa(float gpa) {
            this.gpa = gpa;
        }

        @Override
        public void notification() {
            System.out.println("Student notify");

        }

        public String toString() {
            return String.format("%-5s | %-20s | %-10s | %-10s | %-10s | %-12s | %-20s | %-5s | %-10s | %-10s | %-4s",
                    getId(), getName(), getAddress(), getPhone(), getPersonId(), getBirthDay(), getEmail(),
                    getParentID(), getStudentCode(), getGroupCode(), getGpa());
        }

        public void setGpa(String s) {
        }

        public void setParentID(String s) {
        }
    }
