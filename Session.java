import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files
public class Session {
    private int sessionId;
    private int numStudents;
    private int timeSlot;
    private int roomNumber;
    private ArrayList<Student> roster;

    public Session(int sessionId, int timeSlot, int roomNumber) {
        this.sessionId = sessionId;
        this.timeSlot = timeSlot;
    }

    public int getSessionId() {
        return sessionId;
    }

    public int numStudents() {
        return numStudents;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public void addStudent(Student student){
        roster.add(student);
        numStudents++;
    }
}