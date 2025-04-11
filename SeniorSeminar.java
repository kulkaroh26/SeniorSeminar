import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class SeniorSeminar {
    private int[] courseTally = new int[18];
    private Student[][] studentCourses = new Student[75][5];
  
    public SeniorSeminar() {
        int x = 0;
        int y = 0;
        int tempCompID;
        String tempName;
        Scanner scan = new Scanner(System.in);
        try {
            File myObj = new File("SrSeminar_RawData.csv");
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataSplit = data.split(",");
                courseTally[Integer.parseInt(dataSplit[10])]++;
                courseTally[Integer.parseInt(dataSplit[11])]++;
                courseTally[Integer.parseInt(dataSplit[12])]++;
                courseTally[Integer.parseInt(dataSplit[13])]++;
                courseTally[Integer.parseInt(dataSplit[14])]++;
                //Attendee att = new Attendee(tempName, Integer.parseInt(dataSplit[3]));
                //tempCompID = Integer.parseInt(dataSplit[3]);
                //attList.add(att);
                //numAttendees++;
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
  }
  public static void main(String[] args) {
    SeniorSeminar s1 = new SeniorSeminar();
    for (int i = 0; i < s1.courseTally.length; i++) {
        System.out.println("Course " + i + ": " + s1.courseTally[i]);
    }
  }
}
