import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            System.out.print("Enter number of students (n): ");
            int n = scan.nextInt();

            double[][] marks = new double[n][3];

            System.out.println("\n Student Mark Management \n\n");
            system.out.println("Commands:");
            System.out.println("1. add [studentID]");
            System.out.println("2. update [studentID] [subjectID]");
            System.out.println("3. average_subject [subjectID]");
            System.out.println("4. average_student [studentID]");
            System.out.println("5. total[StudentID]");
            System.out.println("6. exit");       

            while (true) {
                System.out.print("\nEnter command: ");
                int command = scan.nextInt();

                if (command.equalsIgnoreCase()) {
                    System.out.println("Exiting program...");
                    break;
                }

                switch (command) {
                    case 1: {
                        int studentID = scan.nextInt();
                        if (studentID < 1 || studentID > n) {
                            System.out.println("Invalid Student ID! Must be between 1 and " + n);
                            break;
                        }
                    }
                    case 2: {
                        int studentID = scan.nextInt();
                        if (studentID < 1 || studentID > n) {
                            System.out.println("Invalid Student ID! Must be between 1 and " + n);
                            break;
                        }
                    }
                }
            }
        }
    }
}