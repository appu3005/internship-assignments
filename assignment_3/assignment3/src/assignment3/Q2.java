package assignment3;

import java.util.Scanner;

// Custom Exception
class ExceptionLineTooLong extends Exception {
    public ExceptionLineTooLong(String message) {
        super(message);
    }
}

public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            if (input.length() > 80) {
                throw new ExceptionLineTooLong("The string is too long");
            }

            System.out.println("Valid string: " + input);

        } catch (ExceptionLineTooLong e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}