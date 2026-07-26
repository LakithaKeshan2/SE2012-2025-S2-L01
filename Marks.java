import java.util.Scanner;

public class Marks {
    static final String[] SUBJECTS = {"Mathematics", "Chemistry", "Physics"};
    static double[][] marks;
    static boolean[] added;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students (n): ");
        n = Integer.parseInt(sc.nextLine().trim());

        marks = new double[n + 1][3]; // index 0 unused, students are 1..n
        added = new boolean[n + 1];

        System.out.println("Commands available:");
        System.out.println("add [studentID] - add marks for a student");
        System.out.println("update [studentID] [subjectID] - update a mark");
        System.out.println("average_s [subjectID] - average for a subject");
        System.out.println("average [studentID] - average for a student");
        System.out.println("total [studentID] - total marks for a student");
        System.out.println("exit - quit the program");

        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String cmd = parts[0].toLowerCase();

            switch (cmd) {
                case "add":
                    handleAdd(parts, sc);
                    break;
                case "update":
                    handleUpdate(parts, sc);
                    break;
                case "average_s":
                    handleAverageSubject(parts);
                    break;
                case "average":
                    handleAverageStudent(parts);
                    break;
                case "total":
                    handleTotal(parts);
                    break;
                case "exit":
                case "quit":
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Unknown command: " + cmd);
            }
        }
    }

    static boolean validStudent(int id) {
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID. Must be between 1 and " + n + ".");
            return false;
        }
        return true;
    }

    static void handleAdd(String[] parts, Scanner sc) {
        if (parts.length != 2) {
            System.out.println("Usage: add [studentID]");
            return;
        }
        int id = Integer.parseInt(parts[1]);
        if (!validStudent(id)) return;

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter " + SUBJECTS[i] + " mark for student " + id + ": ");
            marks[id][i] = Double.parseDouble(sc.nextLine().trim());
        }
        added[id] = true;
        System.out.println("Marks added for student " + id + ".");
    }

    static void handleUpdate(String[] parts, Scanner sc) {
        if (parts.length != 3) {
            System.out.println("Usage: update [studentID] [subjectID]");
            return;
        }
        int id = Integer.parseInt(parts[1]);
        int subId = Integer.parseInt(parts[2]);

        if (!validStudent(id)) return;
        if (subId < 1 || subId > 3) {
            System.out.println("Invalid subject ID. Must be 1 (Math), 2 (Chemistry), or 3 (Physics).");
            return;
        }
        if (!added[id]) {
            System.out.println("Student " + id + " has no marks yet. Use 'add' first.");
            return;
        }

        System.out.print("Enter new " + SUBJECTS[subId - 1] + " mark for student " + id + ": ");
        marks[id][subId - 1] = Double.parseDouble(sc.nextLine().trim());
        System.out.println("Updated.");
    }

    static void handleAverageSubject(String[] parts) {
        if (parts.length != 2) {
            System.out.println("Usage: average_s [subjectID]");
            return;
        }
        int subId = Integer.parseInt(parts[1]);
        if (subId < 1 || subId > 3) {
            System.out.println("Invalid subject ID. Must be 1 (Math), 2 (Chemistry), or 3 (Physics).");
            return;
        }

        double sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (added[i]) {
                sum += marks[i][subId - 1];
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No marks recorded yet.");
            return;
        }
        System.out.printf("Average %s mark: %.2f%n", SUBJECTS[subId - 1], sum / count);
    }

    static void handleAverageStudent(String[] parts) {
        if (parts.length != 2) {
            System.out.println("Usage: average [studentID]");
            return;
        }
        int id = Integer.parseInt(parts[1]);
        if (!validStudent(id)) return;
        if (!added[id]) {
            System.out.println("Student " + id + " has no marks yet.");
            return;
        }

        double sum = marks[id][0] + marks[id][1] + marks[id][2];
        System.out.printf("Average mark for student %d: %.2f%n", id, sum / 3);
    }

    static void handleTotal(String[] parts) {
        if (parts.length != 2) {
            System.out.println("Usage: total [studentID]");
            return;
        }
        int id = Integer.parseInt(parts[1]);
        if (!validStudent(id)) return;
        if (!added[id]) {
            System.out.println("Student " + id + " has no marks yet.");
            return;
        }

        double total = marks[id][0] + marks[id][1] + marks[id][2];
        System.out.printf("Total mark for student %d: %.2f%n", id, total);
    }
}