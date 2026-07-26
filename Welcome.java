import java.util.Scanner;

public class Welcome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter your Last Name: ");
        String lastName = sc.nextLine();

        System.out.println("Welcome to the Second Year " + firstName + " " + lastName);

        sc.close();
    }
}