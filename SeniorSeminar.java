import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class SeniorSeminar {
    private static int[] courseTally = new int[19]; //array that tallies the amount of people who voted for each course
    private static int[] courseID = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18}; //used to identify each individual course
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
        System.out.println(studentCourses[i].getName() + ": " + studentCourses[i].getCourse1()+", "+ studentCourses[i].getCourse2()+", "+ studentCourses[i].getCourse3()+", "+ studentCourses[i].getCourse4()+", "+ studentCourses[i].getCourse5());
    }
    for (int i = 0; i < s1.courseTally.length; i++) {
        System.out.println("Course " + i + ": " + s1.courseTally[i]);
    }
    s1.InsertionSort(courseTally,courseID);
    int[][] schedule = s1.courseSchedule(courseID);
}
    public static void InsertionSort (int[] array, int[] arrayID){ //takes in an array of course tallies and the ID's of the courses and returns them in sorted order
        for (int i=1;i<array.length;i++){ //starts at 1 since the first number is already in sorted portion
            int temp = array[i]; //sets a temp value
            int tempID = arrayID[i];
            int j = i-1;
            while (j>=0&&temp<array[j]){ //while the temp value is less than the number at the index, keep moving down
                array[j+1]=array[j]; //shifts all values to the right
                arrayID[j+1]=arrayID[j]; //shifts the ID's to the right as well
                j--; //increments j down    
            }
            array[j+1]=temp; //when the loop ends, put the number in the correct position
            arrayID[j+1]=tempID;
    }
        System.out.println("Insertion Sort: "); //the rest prints out the values of the sort as well as comparison and moves
        for (int z=0;z<array.length;z++){
             System.out.println("Course "+arrayID[z]+": "+array[z]);
        }
        
    }
    public static int[][] courseSchedule(int[] sessionID){
        int[][] courseSchedule = new int[5][5]; //5x5 array to hold the course schedule
        int len = sessionID.length-1; //courseTally array is arranged least to most popular, so have to run backwards from the array
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                if (sessionID[len]==0){
                    len--;
                    courseSchedule[j][i]=sessionID[len];
                    len--;
                }
                if (len==0){
                    courseSchedule[j][i]=sessionID[len];
                    len = sessionID.length-1;
                }
                courseSchedule[j][i]=sessionID[len]; //sets the course schedule to the most popular courses in order going down then across
                len--;

            }
        }
        for (int z=0;z<5;z++){
            for (int y=0;y<5;y++){
                System.out.print(courseSchedule[z][y]+"\t"); //prints out the course schedule
            }
            System.out.println();
        }
        return courseSchedule; //returns the course schedule
    }
  
}

