import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter marks obtained in each subject (out of 100):");
        int numberOfSubjects = 0;
        int totalMarks = 0;

        while (true) {
            System.out.print("Subject " + (numberOfSubjects + 1) + ": ");
            if (scanner.hasNextInt()) {
                int marks = scanner.nextInt();
                if (marks >= 0 && marks <= 100) {
                    totalMarks += marks;
                    numberOfSubjects++;
                } else {
                    System.out.println("Invalid input! Marks should be between 0 and 100.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next();
            }

            if (numberOfSubjects >= 5) {
                // Break the loop after taking marks for at least 3 subjects
                break;
            }
        }

        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);

        char grade = calculateGrade(averagePercentage);

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static double calculateAveragePercentage(int totalMarks, int numberOfSubjects) {
        return (double) totalMarks / numberOfSubjects;
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

