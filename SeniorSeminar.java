import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class SeniorSeminar {
    private int[] courseTally = new int[19];
    private static Student[] studentCourses = new Student[75]; //75 students
  
    public SeniorSeminar() {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        try {
            File myObj = new File("SrSeminar_RawData.csv");
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();  //skip header row
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataSplit = data.split(",");
                if (dataSplit.length==0){
                    break;
                }
                //System.out.println(dataSplit.length);
                studentCourses[x] = new Student(dataSplit[3], Integer.parseInt(dataSplit[10]),Integer.parseInt(dataSplit[11]),Integer.parseInt(dataSplit[12]),Integer.parseInt(dataSplit[13]),Integer.parseInt(dataSplit[14]));
                courseTally[Integer.parseInt(dataSplit[10])]++;
                courseTally[Integer.parseInt(dataSplit[11])]++;
                courseTally[Integer.parseInt(dataSplit[12])]++;
                courseTally[Integer.parseInt(dataSplit[13])]++;
                courseTally[Integer.parseInt(dataSplit[14])]++;
                //System.out.println("Works");
                x++;
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
  }
  public static void main(String[] args) {
    SeniorSeminar s1 = new SeniorSeminar();
    for (int i = 0; i < s1.studentCourses.length-1; i++) {
        System.out.println(studentCourses[i].getName() + ": " + studentCourses[i].getCourse1()+", "+ studentCourses[i].getCourse2()+", "+ studentCourses[i].getCourse3()+", "+ studentCourses[i].getCourse4()+", "+ studentCourses[i].getCourse5()+", ");
    }
    for (int i = 0; i < s1.courseTally.length; i++) {
        System.out.println("Course " + i + ": " + s1.courseTally[i]);
    }
  }
}
