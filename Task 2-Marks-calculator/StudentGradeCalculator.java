import java.util.Scanner;


class Student {
    //  variables

    // Array to store marks of each subject
    public int[] marks;

    // Variable to store total marks
    public int totalMarks;


    // Constructor
    public Student(int numSubjects) {

        // Initialize marks array based on the number of subjects
        marks = new int[numSubjects];

        // Initialize total marks to 0
        totalMarks = 0;
    }

    // Method to input marks for each subject.....
    public void inputMarks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks (out of 100) for each subject:");
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            // yha pr subject mai marks ko likh diya....
            marks[i] = sc.nextInt();

            // Add marks to totalMarks....
            totalMarks += marks[i];
        }
    }

    // Method to calculate total marks
    public int calculateTotalMarks() {
        return totalMarks;
    }

    // Method to calculate average percentage
    public double calculateAvgPercentage() {
        return (double) totalMarks / marks.length;
    }

    // Method to calculate grade based on average percentage
    public String calculateGrade() {
        double AvgPercentage = calculateAvgPercentage();
        if (AvgPercentage >= 95 || AvgPercentage>= 99.9) {
            return "A++";
        }
        else if (AvgPercentage >= 90) {
            return "A+";
        } else if (AvgPercentage >= 80) {
            return "B+";
        } else if (AvgPercentage >= 70) {
            return "C+";
        } else if (AvgPercentage >= 60) {
            return "D+";
        } else if(AvgPercentage >= 50) {
            return "F+'";
        } else if (AvgPercentage >=33) {
            return "Pass with Grace Marks... ( G )";
        }
        else {
            return "You are Fail.( Better Luck Next Time.)";
        }

    }
}


public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     // kitna sunject hai phela vo number likho Example = 5 subject available to fill kero 5 ya 6 subject ho vo fill kero...
//        that your choice how many subject....
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        // Create object of STUDENT   class
        Student stu = new Student(numSubjects);

        // method i/p Input marks for each subject
        stu.inputMarks();

        // Display results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + stu.calculateTotalMarks());
        System.out.println("Average Percentage: " + stu.calculateAvgPercentage() + "%");
        System.out.println("Grade: " + stu.calculateGrade());
    }
}
