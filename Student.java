public class Student {
    private String name;
    private int studentID;
    
    private int course1;
    private int course2;
    private int course3;
    private int course4;
    private int course5;

    private Student(String name, int studentID, int choice1, int choice2, int choice3, int choice4, int choice5){
        this.name = name;
        this.studentID = studentID;
        course1 = choice1;
        course2 = choice2;
        course3 = choice3;
        course4 = choice4;
        course5 = choice5;
    }

    public String getName() {
        return name;
    }
    public int getStudentID() {
        return studentID;
    }
    public int getCourse1(){
        return course1;
    }
    public int getCourse2(){
        return course2;
    }
    public int getCourse3(){
        return course3;
    }
    public int getCourse4(){
        return course4;
    }
    public int getCourse5(){
        return course5;
    }
}